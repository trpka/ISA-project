package com.example.ISAproject.service;

import com.example.ISAproject.dto.DonationTermsDTO;
import com.example.ISAproject.dto.ScheduleDonationTermDTO;
import com.example.ISAproject.dto.TimePeriodDTO;
import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.model.Calendar;
import com.example.ISAproject.model.DonationTerms;
import com.example.ISAproject.model.RegisteredUser;
import com.example.ISAproject.repository.BloodCenterRepository;
import com.example.ISAproject.repository.DonationTermsRepository;
import com.example.ISAproject.repository.RegisteredUserRepository;
import com.example.ISAproject.repository.StuffRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
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

    public DonationTerms findById(Long id)
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

    @Transactional(readOnly=false)
    public DonationTerms addDonationTerm(DonationTerms dt) throws PessimisticLockingFailureException, DateTimeException {
    	BloodCenter bloodCenter = bloodCenterService.findById(dt.getBloodCenter().getId());
    	Calendar calendar = calendarService.findById(dt.getCalendar().getId());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime date = LocalDateTime.parse(dt.getDate().toString(),formatter);
        LocalDateTime start = LocalDateTime.parse(dt.getReservationStart().toString(),formatter);
        LocalDateTime end = LocalDateTime.parse(dt.getReservationEnd().toString(),formatter);

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");


        DonationTerms donationTerms = new DonationTerms(dt.getId(),date,start, end, dt.getDuration(),dt.isFree(),bloodCenter,calendar);

        donationTermsRepository.save(donationTerms);


        return donationTerms;
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

    public DonationTerms scheduleTerm(ScheduleDonationTermDTO dto) {
        Optional<DonationTerms> donationTerms = this.findById(dto.getDonationTermId());
        RegisteredUser registeredUser = this.registeredUserService.findById(dto.getRegisteredUserId());
        if (!donationTerms.isPresent()) {
            return null;
        }
        DonationTerms donationTerms1 = donationTerms.get();
        donationTerms1.setRegisteredUser(registeredUser);
        donationTerms1.setFree(false);
        return this.save(donationTerms1);
    }

    public DonationTerms cancelTerm(ScheduleDonationTermDTO dto) {
        Optional<DonationTerms> donationTerms = this.findById(dto.getDonationTermId());
        RegisteredUser registeredUser = this.registeredUserService.findById(dto.getRegisteredUserId());
        if (!donationTerms.isPresent()) {
            return null;
        }
        DonationTerms donationTerms1 = donationTerms.get();
        if(donationTerms1.getRegisteredUser().getId().equals(registeredUser.getId()))
        {
            donationTerms1.setRegisteredUser(null);
            donationTerms1.setFree(true);
        }

        return this.save(donationTerms1);
    }

}
