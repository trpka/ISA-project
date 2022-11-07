package com.example.ISAproject.controllers;

import com.example.ISAproject.model.ProfileCenter;
import com.example.ISAproject.service.ProfileCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProfileCenterController
{
    @Autowired
    private ProfileCenterService profileCenterService;

    //Prikaz Svih Centara
    @RequestMapping(value="api/centers",method = RequestMethod.GET,produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<ProfileCenter>> findAll()
    {
        List<ProfileCenter> centers= this.profileCenterService.findAll();
        return new ResponseEntity<>(centers,HttpStatus.OK);
    }
    //Pretraga Centra Po ID-ju
    @RequestMapping(value="api/center/{id}",method = RequestMethod.GET,produces= {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ProfileCenter> getById(@PathVariable Long id)
    {

        ProfileCenter profileCenter=this.profileCenterService.findById(id);

        return new ResponseEntity<>(profileCenter,HttpStatus.OK);
    }

    //Dodavanje Novog Centra
    @RequestMapping(value="api/center",method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ProfileCenter> save(@RequestBody ProfileCenter profileCenter)
    {
        ProfileCenter savedProfile = this.profileCenterService.save(profileCenter);
        return new ResponseEntity<>(savedProfile, HttpStatus.CREATED);
        //return new ResponseEntity("Succesfully created a new Blood Center!", HttpStatus.CREATED);
    }



}
