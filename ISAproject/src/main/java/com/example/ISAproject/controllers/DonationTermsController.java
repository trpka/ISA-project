package com.example.ISAproject.controllers;

import com.example.ISAproject.dto.DefinedTermDTO;
import com.example.ISAproject.dto.DonationTermsDTO;
import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.model.DonationTerms;
import com.example.ISAproject.service.DonationTermsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PessimisticLockException;
import java.time.DateTimeException;
import java.time.LocalDateTime;
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
   // @PreAuthorize("hasRole('STUFF')")
    public ResponseEntity<DefinedTermDTO>addDonationTerm(@RequestBody DefinedTermDTO dto)
    {
    	DefinedTermDTO definedTermDTO = new DefinedTermDTO();
    	DonationTerms donationTerms = new DonationTerms();
        try {
        	definedTermDTO = this.donationTermsService.addDonationTerm(dto);
        } catch (PessimisticLockException e)
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (DateTimeException e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(definedTermDTO,HttpStatus.OK);
    }
    
    

    @RequestMapping(value="api/terms/create_reservation",method = RequestMethod.PUT,produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
  //  @PreAuthorize("hasRole('STUFF')")
    public ResponseEntity<DonationTermsDTO>  addCottageFastReservation(@RequestBody DonationTermsDTO dto){
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
    

}
