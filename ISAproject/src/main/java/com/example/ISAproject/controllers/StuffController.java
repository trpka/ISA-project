package com.example.ISAproject.controllers;


import com.example.ISAproject.dto.PasswordChangeDTO;
import com.example.ISAproject.model.*;
import com.example.ISAproject.service.StuffService;
import com.example.ISAproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")

public class StuffController
{
    @Autowired
    private StuffService stuffService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "api/stuffs", method = RequestMethod.GET, produces =
            { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })

    public ResponseEntity<List<Stuff>> findAll()
    {
        List<Stuff> stuffs = this.stuffService.findAll();
        return new ResponseEntity<>(stuffs,HttpStatus.OK);
    }

    @RequestMapping(value="api/stuff/{id}",method = RequestMethod.GET,produces= {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Stuff> getById(@PathVariable Long id)
    {

        Stuff stuff =this.stuffService.findById(id);

        return new ResponseEntity<>(stuff,HttpStatus.OK);
    }



    //Izmena podataka o administratoru centra
    @PreAuthorize("hasRole('STUFF')")
    @PutMapping("api/stuff/edit")
    public ResponseEntity<Stuff> UpdateStuff(@RequestBody Stuff st)
    {
        Stuff stuff = this.stuffService.UpdateStuff(st);
        return  new ResponseEntity<>(stuff, HttpStatus.OK);
    }



    //Dodavanje penala ukoliko se korisnik ne pojavi na pregledu
    @PreAuthorize("hasRole('STUFF')")
    @RequestMapping(value="api/addPenal",method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DonationTerms> addPenal(@RequestBody DonationTerms dt)
    {
        DonationTerms donationTerms = this.stuffService.addPenalty(dt);
        return new ResponseEntity<>(donationTerms, HttpStatus.CREATED);
    }

    //Provera Da Li se Korisnik pojavio na pregledu
    @PreAuthorize("hasRole('STUFF')")
    @PutMapping("api/exam/edit")
    public ResponseEntity<DonationTerms> UpdateExam(@RequestBody DonationTerms dt)
    {
        DonationTerms donationTerms = this.stuffService.UpdateExam(dt);
        return  new ResponseEntity<>(donationTerms, HttpStatus.OK);
    }

    //Izvlacenje Juzera na osnovu ID-a
    @RequestMapping(value="api/user/{id}",method = RequestMethod.GET,produces= {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> getUserById(@PathVariable Long id)
    {
        User user = this.userService.findById1(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    //Izmena Lozinke za Admina
    @RequestMapping(value="api/stuff/changePassword/{id}",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Stuff> changePassword(@RequestBody PasswordChangeDTO dto, @PathVariable Long id){
        Stuff stuff = stuffService.changePassword(id, dto);
        if(stuff==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        return new ResponseEntity<>(stuff,HttpStatus.OK);
    }










}
