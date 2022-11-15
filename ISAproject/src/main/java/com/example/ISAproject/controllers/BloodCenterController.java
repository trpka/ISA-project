package com.example.ISAproject.controllers;

import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.model.DonationTerms;
import com.example.ISAproject.model.Stuff;
import com.example.ISAproject.service.BloodCenterService;
import com.example.ISAproject.service.DonationTermsService;
import com.example.ISAproject.service.StuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BloodCenterController
{
    @Autowired
    private BloodCenterService bloodCenterService;
    @Autowired
    private DonationTermsService donationTermsService;
    @Autowired
    private StuffService stuffService;

    //Prikaz Svih Centara
    @RequestMapping(value="api/centers",method = RequestMethod.GET,produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<BloodCenter>> findAll()
    {
        List<BloodCenter> centers= this.bloodCenterService.findAll();
        return new ResponseEntity<>(centers,HttpStatus.OK);
    }
    //Pretraga Centra Po ID-ju
    @RequestMapping(value="api/center/{id}",method = RequestMethod.GET,produces= {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<BloodCenter> getById(@PathVariable Long id)
    {

        BloodCenter bloodCenter =this.bloodCenterService.findById(id);

        return new ResponseEntity<>(bloodCenter,HttpStatus.OK);
    }

    //Dodavanje Novog Centra
    @RequestMapping(value="api/center",method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BloodCenter> save(@RequestBody BloodCenter bloodCenter)
    {
        BloodCenter savedProfile = this.bloodCenterService.save(bloodCenter);
        return new ResponseEntity<>(savedProfile, HttpStatus.CREATED);
        //return new ResponseEntity("Succesfully created a new Blood Center!", HttpStatus.CREATED);
    }

    //Izmena centra
    @PutMapping("api/centers/edit")
    public ResponseEntity<BloodCenter> UpdateCenter(@RequestBody BloodCenter bc)
    {
        BloodCenter bloodCenter = this.bloodCenterService.UpdateCenter(bc);
        return  new ResponseEntity<>(bloodCenter,HttpStatus.OK);
    }



    @RequestMapping(value="api/centerName", method = RequestMethod.GET,
			params = "name",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<BloodCenter>> findByName(@RequestParam String name){
		List<BloodCenter> bloodCenters=this.bloodCenterService.findByCenterName(name);
		return new ResponseEntity<>(bloodCenters,HttpStatus.OK);
	}
  

	
	  @RequestMapping(value="api/centerName", method = RequestMethod.GET, params =
	  "address", produces= {MediaType.APPLICATION_JSON_VALUE,
	  MediaType.APPLICATION_XML_VALUE}) 
	  public ResponseEntity<List<BloodCenter>>findByAddressCentre(@RequestParam String address){ 
		  List<BloodCenter> bloodCenters=this.bloodCenterService.findByAddress(address); 
		  return new ResponseEntity<>(bloodCenters,HttpStatus.OK); }
	  
	 
    
	
	  @RequestMapping(value="api/centerName", method = RequestMethod.GET, params =
	  "averageGradeCentre", produces= {MediaType.APPLICATION_JSON_VALUE,
	  MediaType.APPLICATION_XML_VALUE}) public ResponseEntity<List<BloodCenter>>
	  findByAverageGradeCentre(@RequestParam Long averageGradeCentre){
	  List<BloodCenter>
	  bloodCenters=this.bloodCenterService.findByAverageGradeCentre(
	  averageGradeCentre); return new ResponseEntity<>(bloodCenters,HttpStatus.OK);
	  }
	 
    
    @RequestMapping(value="api/centerName", method = RequestMethod.GET,
			params = "city",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<BloodCenter>> findCenterByCity(@RequestParam String city){
		List<BloodCenter> bloodCenters=this.bloodCenterService.findCenterByCity(city);
		return new ResponseEntity<>(bloodCenters,HttpStatus.OK);
	}

	 @RequestMapping(value="api/centerName", method = RequestMethod.GET, params =
	  {"address","averageGradeCentre"}, produces=
	  {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}) 
	  public ResponseEntity<List<BloodCenter>> findByAddressAndAverageGrade(@RequestParam String address,@RequestParam Long averageGradeCentre){
		 List<BloodCenter> centers=this.bloodCenterService.findByAddressAndAverageGradeCentre(address, averageGradeCentre);
	  return new ResponseEntity<>(centers,HttpStatus.OK); }
	 

    @GetMapping(path = "/search/{centerName}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchForUsername(@PathVariable("centerName") String centerName){
        List<BloodCenter> bloodCenters = bloodCenterService.findByUsernameContaining(centerName);
        if(bloodCenters.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<BloodCenter>>(bloodCenters, HttpStatus.OK);
    }

    //Prikazivanje termina prema centru kojem pripada
    @RequestMapping(value="api/centers/terms/{id}",method = RequestMethod.GET,produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })

    public ResponseEntity<List<DonationTerms>> findAllTermsByCentre(@PathVariable Long id)
    {
        List<DonationTerms> terms=this.donationTermsService.findAllTermsByCentre(id);
        return new ResponseEntity<>(terms,HttpStatus.OK);
    }

    //Prikazivanje Radnika(Stuff-ova) prema centru kojem pripadaju
    @RequestMapping(value="api/centers/stuffs/{id}",method = RequestMethod.GET,produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })

    public ResponseEntity<List<Stuff>> FindAllStuffsByCentre(@PathVariable Long id)
    {
        List<Stuff> stuffs = this.stuffService.FindStuffByCenter(id);
        return new ResponseEntity<>(stuffs,HttpStatus.OK);
    }


    @RequestMapping(value="api/centers/sort-by-name", method = RequestMethod.GET,
            produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<BloodCenter>> sortByName(){
        List<BloodCenter> bloodCenters=this.bloodCenterService.sortByName();
        return new ResponseEntity<>(bloodCenters,HttpStatus.OK);
    }

    @RequestMapping(value="api/centers/sort-by-average-grade", method = RequestMethod.GET,
            produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<BloodCenter>> sortByGrade(){
        List<BloodCenter> bloodCenters=this.bloodCenterService.sortByGrade();
        return new ResponseEntity<>(bloodCenters,HttpStatus.OK);
    }
    @RequestMapping(value="api/centers/sort-by-city", method = RequestMethod.GET,
            produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    //@PreAuthorize("hasRole('REGISTERED_USER')")
    public ResponseEntity<List<BloodCenter>> sortByCity(){
        List<BloodCenter> bloodCenters=this.bloodCenterService.sortByCity();
        return new ResponseEntity<>(bloodCenters,HttpStatus.OK);
    }


    
}
