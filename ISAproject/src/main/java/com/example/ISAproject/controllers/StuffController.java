package com.example.ISAproject.controllers;


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

    @RequestMapping(value="api/stuffs/{id}",method = RequestMethod.GET,produces=
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Stuff> getById(@PathVariable Long id)
    {

        Optional<Stuff> stuff= stuffService.findById(id);

        if(!stuff.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Stuff s=new Stuff();
        return new ResponseEntity<>(s,HttpStatus.OK);
    }




}
