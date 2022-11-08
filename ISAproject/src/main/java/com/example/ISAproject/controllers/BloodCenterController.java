package com.example.ISAproject.controllers;

import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.service.BloodCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BloodCenterController
{
    @Autowired
    private BloodCenterService bloodCenterService;

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
    @PutMapping("api/edit/center")
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
  
    @RequestMapping(value="api/centerName", method = RequestMethod.GET,
			params = "address",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<BloodCenter>> findByAddress(@RequestParam String address){
		List<BloodCenter> bloodCenters=this.bloodCenterService.findByAddress(address);
		return new ResponseEntity<>(bloodCenters,HttpStatus.OK);
	}

//    @RequestMapping(value="api/centers/sort-by-grade", method = RequestMethod.GET,
//			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//	public ResponseEntity<List<BloodCenter>> sortByAverageGrade(){
//		List<BloodCenter> centers=this.bloodCenterService.sortByAverageGrade();
//		return new ResponseEntity<>(centers,HttpStatus.OK);
//	}
    
}
