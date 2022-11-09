package com.example.ISAproject.controllers;

import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.model.DonationTerms;
import com.example.ISAproject.service.DonationTermsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class DonationTermsController
{
    @Autowired
    private DonationTermsService donationTermsService;

    //Prikaz Svih Termina
    @RequestMapping(value="api/terms",method = RequestMethod.GET,produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<DonationTerms>> findAll()
    {
        List<DonationTerms> terms= this.donationTermsService.findAll();
        return new ResponseEntity<>(terms, HttpStatus.OK);
    }

    //Prikazivanje Slobodnih  i Zauzetih termina
   /* @RequestMapping(value="api/term", method = RequestMethod.GET,
            params = "isFree",
            produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

    public ResponseEntity<List<DonationTerms>> findFreeTerms(@RequestParam Boolean isFree)
    {
        List<DonationTerms> donationTerms = this.donationTermsService.findFreeTerms(isFree);
        return new ResponseEntity<>(donationTerms,HttpStatus.OK);
    }*/

    @RequestMapping(value="api/terms/{isFree}",method = RequestMethod.GET,produces= {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<DonationTerms>> findFreeTerms(@PathVariable Boolean isFree)
    {

        List<DonationTerms> donationTerms =this.donationTermsService.findFreeTerms(isFree);

        return new ResponseEntity<>(donationTerms,HttpStatus.OK);
    }

}