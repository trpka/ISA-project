package com.example.ISAproject.controllers;


import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.model.DonationTerms;
import com.example.ISAproject.model.RegisteredUser;
import com.example.ISAproject.model.Stuff;
import com.example.ISAproject.service.StuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")

public class StuffController
{
    @Autowired
    private StuffService stuffService;

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
    @PutMapping("api/stuff/edit")
    public ResponseEntity<Stuff> UpdateStuff(@RequestBody Stuff st)
    {
        Stuff stuff = this.stuffService.UpdateStuff(st);
        return  new ResponseEntity<>(stuff, HttpStatus.OK);
    }

   //Student 3 funkcionalnost dodavanje negativnih poena
    /* @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="api/addPenal", method = RequestMethod.POST,
            params = "id",
            consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<RegisteredUser> AddNegative(@RequestParam Long id)
    {
        RegisteredUser registeredUser = this.stuffService.addNegativePoint(id);

        return new ResponseEntity<>(registeredUser,HttpStatus.OK);
    }*/

    //Dodavanje penala ukoliko se korisnik ne pojavi na pregledu
    @RequestMapping(value="api/addPenal",method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DonationTerms> addPenal(@RequestBody DonationTerms dt)
    {
        DonationTerms donationTerms = this.stuffService.addPenalty(dt);
        return new ResponseEntity<>(donationTerms, HttpStatus.CREATED);
    }

    //Provera Da Li se Korisnik pojavio na pregledu
    @PutMapping("api/exam/edit")
    public ResponseEntity<DonationTerms> UpdateExam(@RequestBody DonationTerms dt)
    {
        DonationTerms donationTerms = this.stuffService.UpdateExam(dt);
        return  new ResponseEntity<>(donationTerms, HttpStatus.OK);
    }










}
