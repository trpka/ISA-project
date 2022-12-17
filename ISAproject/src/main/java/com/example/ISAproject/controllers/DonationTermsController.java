package com.example.ISAproject.controllers;

import com.example.ISAproject.dto.DonationTermsDTO;
import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.model.DonationTerms;
import com.example.ISAproject.service.DonationTermsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PessimisticLockException;
import java.time.DateTimeException;
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

    @RequestMapping(value="api/terms/addTerm",method = RequestMethod.PUT,produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    //@PreAuthorize("hasRole('STUFF')")
    public ResponseEntity<DonationTerms>addDonationTerm(@RequestBody DonationTerms dt)
    {
        DonationTerms donationTerms = new DonationTerms();
        try {
            donationTerms = this.donationTermsService.addDonationTerm(dt);
        } catch (PessimisticLockException e)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (DateTimeException e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(donationTerms,HttpStatus.OK);
    }

    @RequestMapping(value="api/terms/create_reservation",method = RequestMethod.PUT,produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    //@PreAuthorize("hasRole('STUFF')")
    public ResponseEntity<DonationTermsDTO>  addTermFastReservation(@RequestBody DonationTermsDTO dto){
        DonationTermsDTO donationTermsDTO=new DonationTermsDTO();
        DonationTerms donationTerms = new DonationTerms();
        try {
            donationTermsDTO = this.donationTermsService.CreateFreeTermForReservation(dto);
        } catch (PessimisticLockException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (DateTimeException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(donationTermsDTO,HttpStatus.OK);
    }


    //Pretraga Termina Po ID-ju, samo termina na koje dolaze korisnici
    @RequestMapping(value="api/term/{id}",method = RequestMethod.GET,produces= {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<DonationTerms> getById(@PathVariable Long id)
    {
        DonationTerms donationTerms =this.donationTermsService.findById(id);
        if(donationTerms.isRegisteredUserCome() == false)
        {
            return  null;
        }
        else
        {
            return new ResponseEntity<>(donationTerms,HttpStatus.OK);

        }
    }


}
