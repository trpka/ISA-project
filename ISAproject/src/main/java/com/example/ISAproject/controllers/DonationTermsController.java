package com.example.ISAproject.controllers;

import com.example.ISAproject.dto.DefinedTermDTO;
import com.example.ISAproject.dto.DonationTermsDTO;
import com.example.ISAproject.dto.ScheduleDonationTermDTO;
import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.model.Calendar;
import com.example.ISAproject.model.DonationTerms;
import com.example.ISAproject.model.QRCodeGenerator;
import com.example.ISAproject.service.DonationTermsService;
import com.example.ISAproject.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PessimisticLockException;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin
public class DonationTermsController
{
    @Autowired
    private DonationTermsService donationTermsService;
    @Autowired
    private EmailService emailService;

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
   // @PreAuthorize("hasAnyRole('REGISTERED_USER','STUFF')")
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
        DonationTerms donationTerms =this.donationTermsService.findByTermsId(id);
        if(donationTerms.isRegisteredUserCome() == false)
        {
            return  null;
        }
        else
        {
            return new ResponseEntity<>(donationTerms,HttpStatus.OK);

        }
    }


    @RequestMapping(value="api/terms/sort-by-date", method = RequestMethod.GET, params = "id",
            produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @PreAuthorize("hasRole('REGISTERED_USER')")
    public ResponseEntity<List<DonationTerms>> sortByDate(@RequestParam Long id){
        List<DonationTerms> donationTerms=this.donationTermsService.sortByDate(id);
        return new ResponseEntity<>(donationTerms,HttpStatus.OK);
    }

    @RequestMapping(value="api/schedule-term",method = RequestMethod.PUT,
            consumes=MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('REGISTERED_USER')")
    public ResponseEntity<DonationTerms>  scheduleTerm(@RequestBody ScheduleDonationTermDTO dto)throws Exception{
    	
        DonationTerms updatedDonationTerm=this.donationTermsService.scheduleTerm(dto);

      
        String text = "Reservation info: \n\nReservation start: " + updatedDonationTerm.getReservationStart() +
                "\nReservation end: " + updatedDonationTerm.getReservationEnd() +
                "\nDuration: " + updatedDonationTerm.getDuration() +
                "\nFirst name: " + updatedDonationTerm.getRegisteredUser().getFirstName() +
                "\nLast name: " + updatedDonationTerm.getRegisteredUser().getLastName()+
                "\nCenter name: " + updatedDonationTerm.getBloodCenter().getCenterName() +
                "\nCenter address: " + updatedDonationTerm.getBloodCenter().getAddress();
        String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";
        QRCodeGenerator.generateQRCodeImage(text, 350, 350, QR_CODE_IMAGE_PATH);
        String body = "This is qr code for your reservation";
        String subject = "QR CODE";
        this.emailService.sendMailWithAttachment(updatedDonationTerm.getRegisteredUser().getEmail(), body, subject, QR_CODE_IMAGE_PATH);
        return new ResponseEntity<>(new DonationTerms(updatedDonationTerm),HttpStatus.OK);

    }

    
    @RequestMapping(value="api/schedule-new-term",method = RequestMethod.PUT,
            consumes=MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('REGISTERED_USER')")
    public ResponseEntity<DonationTerms>  scheduleNewTerm(@RequestBody ScheduleDonationTermDTO dto)throws Exception{
    	
        DonationTerms updatedDonationTerm=this.donationTermsService.scheduleTerm(dto);

       
        return new ResponseEntity<>(new DonationTerms(updatedDonationTerm),HttpStatus.OK);

    }

    @RequestMapping(value="api/cancel-term",method = RequestMethod.PUT,
            consumes=MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('REGISTERED_USER')")
    public ResponseEntity<DonationTerms>  cancelTerm(@RequestBody ScheduleDonationTermDTO dto){
        DonationTerms updatedDonationTerm=this.donationTermsService.cancelTerm(dto);

        return new ResponseEntity<>(new DonationTerms(updatedDonationTerm),HttpStatus.OK);

    }

    

    


}
