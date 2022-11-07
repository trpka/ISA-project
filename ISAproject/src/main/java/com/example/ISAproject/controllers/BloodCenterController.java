package com.example.ISAproject.controllers;

import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.service.BloodCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class BloodCenterController {

    @Autowired
    private BloodCenterService bloodCenterService;

    @RequestMapping(value="api/bloodCenter",method = RequestMethod.GET,produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<BloodCenter>> findAll(){
        List<BloodCenter> bloodCenters =this.bloodCenterService.findAll();
        return new ResponseEntity<>(bloodCenters, HttpStatus.OK);
    }

}
