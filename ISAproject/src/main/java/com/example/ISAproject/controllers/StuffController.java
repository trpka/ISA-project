package com.example.ISAproject.controllers;


import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.model.Stuff;
import com.example.ISAproject.service.StuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
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





}
