package com.example.ISAproject.service;

import com.example.ISAproject.dto.DefinedTermDTO;
import org.springframework.data.repository.query.Param;
import com.example.ISAproject.dto.DonationTermsDTO;
import com.example.ISAproject.dto.ScheduleDonationTermDTO;
import com.example.ISAproject.dto.SearchForReservationDTO;
import com.example.ISAproject.dto.TimePeriodDTO;
import com.example.ISAproject.model.*;
import com.example.ISAproject.repository.BloodCenterRepository;
import com.example.ISAproject.repository.DonationTermsRepository;
import com.example.ISAproject.repository.RegisteredUserRepository;
import com.example.ISAproject.repository.StuffRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DonationTermsService
{
    @Autowired
    private DonationTermsRepository donationTermsRepository;
    @Autowired
    private BloodCenterRepository bloodCenterRepository;
    @Autowired
    private BloodCenterService bloodCenterService;
    @Autowired
    private CalendarService calendarService;
    @Autowired
    private StuffRepository stuffReposiory;
    @Autowired
    private RegisteredUserRepository registeredUserRepository;
    @Autowired
    private RegisteredUserService registeredUserService;
    @Autowired
    private SurveyService surveyService;



    public List<DonationTerms> findAll() {
        return this.donationTermsRepository.findAll();
    }

    public Optional<DonationTerms> findById(Long id) {
        return this.donationTermsRepository.findById(id);
    }

	
    public List<DonationTerms> sortByDate(Long id){

        //List<DonationTerms> donationTermsList=this.donationTermsRepository.findAll();
        List<DonationTerms> donationTermsList = this.donationTermsRepository.findByOrderByDate();
        List<DonationTerms> list = new ArrayList<>();
        for(DonationTerms donTerm : donationTermsList)
        {
            if(donTerm.getBloodCenter().getId().equals(id))
            {
                if(donTerm.isFree() == true)
                {
                    list.add(donTerm);
                }

            }
        }
        return list;
        //return this.donationTermsRepository.findByOrderByDate();
    }

    //Pretraga Termina po centru(NE GLEDAJ OVU F-JU)
    public List<DonationTerms> findByCenter(Long id)
    {
        Optional<DonationTerms> opt=this.donationTermsRepository.findById(id);
        if(!opt.isPresent())
        {
            return null;
        }
        return (List<DonationTerms>) opt.get();

    }

    public DonationTerms findByTermsId(Long id)
    {
        Optional<DonationTerms> opt=this.donationTermsRepository.findById(id);
        if(!opt.isPresent())
        {
            return null;
        }
        return opt.get();


    }
    
  


    //Pretraga Termina Po Centru kojem pripadaju
    public List<DonationTerms> findAllTermsByCentre(Long id)
    {
        List<DonationTerms> allTerms = donationTermsRepository.findAll();
        List<DonationTerms> findedTerms = new ArrayList<>();

        for(DonationTerms dt: allTerms)
        {
            if(dt.getBloodCenter().getId() == id)
            {
                if(dt.isFree() == true)
                {
                    findedTerms.add(dt);
                }

            }
        }

        return findedTerms;
    }

    public List<DonationTerms> findAllScheduledTermsByCentre(Long bloodCenterId,Long registeredUserId)
    {
        List<DonationTerms> allTerms = donationTermsRepository.findAll();
        List<DonationTerms> findedTerms = new ArrayList<>();

        for(DonationTerms dt: allTerms)
        {
            if(dt.getBloodCenter().getId() == bloodCenterId)
            {
                if(dt.isFree() == false)
                {
                    if(dt.getRegisteredUser().getId() == registeredUserId)
                    {
                        findedTerms.add(dt);
                    }
                }

            }
        }

        return findedTerms;
    }
    
    //Pretraga Termina Po Kalendaru kojem pripadaju
    public List<DonationTerms> findAllTermsByCalendar(Long id)
    {
        List<DonationTerms> allTerms = donationTermsRepository.findAll();
        List<DonationTerms> findedTerms = new ArrayList<>();

        for(DonationTerms dt: allTerms)
        {
            if(dt.getCalendar().getId() == id)
            {
                findedTerms.add(dt);
            }
        }

        return findedTerms;
    }

    //Pretraga Termina Prema korisniku koji ih je zakazao
    public List<DonationTerms> findAllTermsByUser(Long id)
    {
        List<DonationTerms> allTerms = donationTermsRepository.findAll();
        List<DonationTerms> findedTerms = new ArrayList<>();

        for(DonationTerms dt: allTerms)
        {
            if(dt.getRegisteredUser() != null && dt.getRegisteredUser().getId() == id)
            {
                findedTerms.add(dt);
            }
        }

        return findedTerms;
    }





    //Prikazivanje Lista Slobodnih i Zauzetih termina
    public List<DonationTerms> findFreeTerms(boolean isFree)
    {
        List<DonationTerms> all_terms =  this.donationTermsRepository.findAll();
        List<DonationTerms> free_terms = new ArrayList<>();
        List<DonationTerms> reserved_terms = new ArrayList<>();

        for(DonationTerms dt: all_terms)
        {
            if(dt.isFree() == true)
            {
                free_terms.add(dt);
            }
            else
            {
                reserved_terms.add(dt);
            }
        }

        if(isFree == true)
        {
            return free_terms;
        }
        else
        {
            return reserved_terms;
        }
    }

    

	
	/*  @Transactional(readOnly=false) public DonationTerms addDonationTerm(DonationTerms dt) throws PessimisticLockingFailureException, DateTimeException { // BloodCenter bloodCenter =
	 // bloodCenterService.findById(dt.getBloodCenter().getId()); 
		  Calendar calendar = calendarService.findById(dt.getCalendar().getId());
	  
	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"); 
	  LocalDateTime date =LocalDateTime.parse(dt.getDate().toString(),formatter);
	  LocalDateTime start = LocalDateTime.parse(dt.getReservationStart().toString(),formatter);
	  LocalDateTime end = LocalDateTime.parse(dt.getReservationEnd().toString(),formatter);
	  
	  DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	  
	  
	  DonationTerms donationTerms = new DonationTerms(dt.getId(),date,start, end, dt.getDuration(),calendar);
	  
	  donationTermsRepository.save(donationTerms);
	  
	  
	  return donationTerms;
	  }*/
	 
    
    //Nikolina 3.8
    @Transactional(readOnly=false) public DefinedTermDTO addDonationTerm(DefinedTermDTO dt) throws PessimisticLockingFailureException, DateTimeException { // BloodCenter bloodCenter =
    	
    	Calendar calendar = calendarService.findById(dt.getCalendar().getId());
        BloodCenter bloodCenter = bloodCenterService.findById(dt.getBloodCenter().getId());
        
      
    			
   	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"); 
   	  LocalDateTime date =LocalDateTime.parse(dt.getDate().toString(),formatter);
   	  LocalDateTime start = LocalDateTime.parse(dt.getReservationStart(),formatter);
      LocalDateTime end = LocalDateTime.parse(dt.getReservationEnd(),formatter);
   	  
   	  

      TimePeriodDTO time=new TimePeriodDTO();
      time.setStart(dt.getReservationStart());
      time.setEnd(dt.getReservationEnd());

   	  DonationTerms newTerm = new DonationTerms(dt.getId(),date,dt.isFree(),start,end, dt.getDuration(),dt.getRegisteredUser(),calendar,bloodCenter);
   	  
   	  donationTermsRepository.save(newTerm);
   	  
   	DefinedTermDTO definedTermsDTO = new DefinedTermDTO(newTerm.getId(), newTerm.getDuration(),
   			newTerm.getDate().format(formatter), newTerm.isFree(),
   			newTerm.getReservationStart().format(formatter),newTerm.getReservationEnd().format(formatter),dt.getRegisteredUser(),calendar,bloodCenter);

   	
     return definedTermsDTO;

   	  }


    @Transactional(readOnly=false)
    public DonationTermsDTO CreateFreeTermForReservation(DonationTermsDTO dto) throws PessimisticLockingFailureException, DateTimeException
    {
        //BloodCenter bloodCenter = bloodCenterRepository.getById(dto.getBloodCenter().getId());
        BloodCenter bloodCenter = bloodCenterService.findById(dto.getBloodCenter().getId());


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
       // LocalDateTime date = LocalDateTime.parse(dto.getDate(),formatter);
        LocalDateTime start = LocalDateTime.parse(dto.getReservationStart(),formatter);
        LocalDateTime end = LocalDateTime.parse(dto.getReservationEnd(),formatter);

        TimePeriodDTO time=new TimePeriodDTO();
        time.setStart(dto.getReservationStart());
        time.setEnd(dto.getReservationEnd());




        DonationTerms new_term = new DonationTerms(dto.getId(),start,end, dto.getDuration(), dto.isFree(),
                                                   dto.getRegisteredUser(), bloodCenter);

        donationTermsRepository.save(new_term);


        DonationTermsDTO donationTermsDTO = new DonationTermsDTO(new_term.getId(), new_term.getDuration(), new_term.isFree(),
                new_term.getReservationStart().format(formatter),
                new_term.getReservationEnd().format(formatter),  new_term.getRegisteredUser(),bloodCenter);

        //return CottageFastReservationMapper.convertToDTO(fast);
        return donationTermsDTO;

    }
    


    public DonationTerms save(DonationTerms newDonationTerm) {
        return this.donationTermsRepository.save(newDonationTerm);
    }

    public boolean RegisteredUserCanNotHaveTwoTerms(Long registeredUserId)
    {
        List<DonationTerms> donationTerms = this.findAll();


        for(DonationTerms donationTerm:donationTerms)
        {
            if(donationTerm.getRegisteredUser() != null)
            {
               if(donationTerm.getRegisteredUser().getId() == registeredUserId && donationTerm.isRegisteredUserCome() == true)
               {
                   return true;
               }
               else if(donationTerm.getRegisteredUser().getId() == registeredUserId && donationTerm.isRegisteredUserCome() == false)
               {
                   return false;
               }
            }

        }

      return true;
    }

    public DonationTerms scheduleTerm(ScheduleDonationTermDTO dto) {
    	
        Optional<DonationTerms> donationTerms = this.findById(dto.getDonationTermId());
        RegisteredUser registeredUser = this.registeredUserService.findById(dto.getRegisteredUserId());
        Survey survey = this.surveyService.findByRegisteredUserId(dto.getRegisteredUserId());
        if (!donationTerms.isPresent()) {
            return null;
        }

        DonationTerms donationTerms1 = donationTerms.get();
        if(this.surveyService.registeredUserHasFilledOutQuestionnaire(dto.getRegisteredUserId()) == true){
        
          if(RegisteredUserCanNotHaveTwoTerms(dto.getRegisteredUserId()) == true)
            {
        	
                LocalDateTime endTime = donationTerms1.getReservationEnd();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String endTimeString = endTime.format(formatter);
                survey.setDate(endTimeString);

                donationTerms1.setRegisteredUser(registeredUser);
                donationTerms1.setFree(false);
            
            }

        }


     return this.save(donationTerms1);
   
    }



    public DonationTerms cancelTerm(ScheduleDonationTermDTO dto) {
        Optional<DonationTerms> donationTerms = this.findById(dto.getDonationTermId());
        RegisteredUser registeredUser = this.registeredUserService.findById(dto.getRegisteredUserId());
        if (!donationTerms.isPresent()) {
            return null;
        }

        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime currentDateMinus1Day = currentTime.plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentDateMinus1DayString = currentDateMinus1Day.format(formatter);
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime currentDateMinus1Day1 = LocalDateTime.parse(currentDateMinus1DayString, formatter1);


        DonationTerms donationTerms1 = donationTerms.get();

        LocalDateTime timeOfDonationTerm = donationTerms1.getReservationStart();

        if (!timeOfDonationTerm.isBefore(currentDateMinus1Day1)) {
            if(donationTerms1.getRegisteredUser().getId().equals(registeredUser.getId()))
            {
                donationTerms1.setRegisteredUser(null);
                donationTerms1.setFree(true);
            }
        }


      return this.save(donationTerms1);
       
    }
    
    
    //3.11
    public List<DonationTerms> findAllAvailableTerms(LocalDateTime term,Long id) {
        return this.donationTermsRepository.getAvailableTerms(term,id);
    }
    
    public DonationTerms createTerm(LocalDateTime userDate,int userDuration,LocalDateTime userStart,LocalDateTime  userEnd ,Long  bloodCenter_id,Long calendar_id) {  
        return this.donationTermsRepository.createTerm(userDate, userDuration, userStart, userEnd,  bloodCenter_id, calendar_id);
    }

}
