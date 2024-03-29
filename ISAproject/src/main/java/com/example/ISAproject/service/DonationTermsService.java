
package com.example.ISAproject.service;

import com.example.ISAproject.dto.*;
import com.example.ISAproject.model.*;
import com.example.ISAproject.repository.*;

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
    @Autowired
    private SurveyService surveyService;
    @Autowired
    private SurveyRepository surveyRepository;
    @Autowired
    private StuffService stuffService;



    public List<DonationTerms> findAll() {
        return this.donationTermsRepository.findAll();
    }

    public Optional<DonationTerms> findById(Long id) {
        return this.donationTermsRepository.findById(id);
    }



    public List<DonationTerms> sortByDate(Long id){

        //List<DonationTerms> donationTermsList=this.donationTermsRepository.findAll();
        List<DonationTerms> donationTermsList = this.donationTermsRepository.findByOrderByReservationStart();
        List<DonationTerms> list = new ArrayList<>();
        LocalDateTime currentTime = LocalDateTime.now();
        for(DonationTerms donTerm : donationTermsList)
        {
            if(donTerm.getBloodCenter().getId().equals(id))
            {
                if(donTerm.isFreeTerm() == true && donTerm.isRegisteredUserCome() == false && donTerm.getReservationStart().isAfter(currentTime))
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
                if(dt.isFreeTerm() == true || dt.isFreeTerm() == false)
                {
                    findedTerms.add(dt);
                }

            }
        }

        return findedTerms;
    }

    public List<DonationTerms> findAllFreeTermsByCentre(Long id)
    {
        List<DonationTerms> allTerms = donationTermsRepository.findAll();
        List<DonationTerms> foundFreeTerms = new ArrayList<>();
        LocalDateTime currentTime = LocalDateTime.now();

        for(DonationTerms dt: allTerms)
        {
            if(dt.getBloodCenter().getId() == id && dt.getReservationStart().isAfter(currentTime))
            {
                if(dt.isFreeTerm() == true && dt.isRegisteredUserCome() == false)
                {
                    foundFreeTerms.add(dt);
                }

            }
        }

        return foundFreeTerms;
    }

    public List<DonationTerms> historyTermsForRegisteredUser(Long id)
    {
        List<DonationTerms> allTerms = this.donationTermsRepository.findAll();
        List<DonationTerms> historyTerms = new ArrayList<>();

        for(DonationTerms dt: allTerms)
        {
            if(dt.getRegisteredUser() != null)
            {
                if(dt.getRegisteredUser().getId() == id)
                {
                    if((dt.isFreeTerm() == true && dt.isRegisteredUserCome() == true) || (dt.isFreeTerm() == false && dt.isRegisteredUserCome() == true))
                    {
                        historyTerms.add(dt);
                    }
                }
            }
        }

        return historyTerms;
    }


    public List<DonationTerms> sortHistoryTermsForRegisteredUser(Long idUser)
    {
        List<DonationTerms> allTerms =  this.donationTermsRepository.findByOrderByReservationStart();
        List<DonationTerms> sortedHistoryTerms = new ArrayList<>();

        for(DonationTerms donTerm : allTerms)
        {
            if(donTerm.getRegisteredUser() != null)
            {
                if(donTerm.getRegisteredUser().getId() == idUser) {
                    if ((donTerm.isFreeTerm() == false && donTerm.isRegisteredUserCome() == true) ||(donTerm.isFreeTerm() == true && donTerm.isRegisteredUserCome() == true)) {
                        sortedHistoryTerms.add(donTerm);
                    }
                }
            }
        }
        return sortedHistoryTerms;
    }

    public List<DonationTerms> sortHistoryTermsForRegisteredUserByDuration(Long idUser)
    {
        List<DonationTerms> allTerms =  this.donationTermsRepository.findByOrderByDuration();
        List<DonationTerms> sortedHistoryTerms = new ArrayList<>();

        for(DonationTerms donTerm : allTerms)
        {
            if(donTerm.getRegisteredUser() != null)
            {
                if(donTerm.getRegisteredUser().getId() == idUser) {
                    if ((donTerm.isFreeTerm() == false && donTerm.isRegisteredUserCome() == true) ||(donTerm.isFreeTerm() == true && donTerm.isRegisteredUserCome() == true)) {
                        sortedHistoryTerms.add(donTerm);
                    }
                }
            }
        }
        return sortedHistoryTerms;
    }



    public List<DonationTerms> futureTermsForRegisteredUser(Long id)
    {
        List<DonationTerms> allTerms = this.donationTermsRepository.findAll();
        List<DonationTerms> futureTerms = new ArrayList<>();
        LocalDateTime currentTime = LocalDateTime.now();

        for(DonationTerms dt: allTerms)
        {
            if(dt.getRegisteredUser() != null)
            {
                if(dt.getRegisteredUser().getId() == id)
                {
                    if((dt.isFreeTerm() == false && dt.isRegisteredUserCome() == false && dt.getReservationStart().isAfter(currentTime)))
                    {
                        futureTerms.add(dt);
                    }
                }
            }
        }

        return futureTerms;
    }

    public List<DonationTerms> findAllScheduledTermsByCentre(Long bloodCenterId,Long registeredUserId)
    {
        List<DonationTerms> allTerms = donationTermsRepository.findAll();
        List<DonationTerms> foundTerms = new ArrayList<>();
        LocalDateTime currentTime = LocalDateTime.now();

        for(DonationTerms dt: allTerms)
        {

            if(dt.getBloodCenter().getId() == bloodCenterId)
            {
                if(dt.isFreeTerm() == false && dt.isRegisteredUserCome()==false && dt.getReservationStart().isAfter(currentTime))
                {
                    //if(dt.getRegisteredUser().getId()!= null){
                    if(dt.getRegisteredUser().getId().equals(registeredUserId))
                    {
                        foundTerms.add(dt);
                    }
                }
            }
        }

        return foundTerms;
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
            if(dt.isFreeTerm() == true)
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







    //Nikolina 3.8
    public DefinedTermDTO addDonationTerm(DefinedTermDTO dt) throws PessimisticLockingFailureException, DateTimeException { // BloodCenter bloodCenter =

        Calendar calendar = calendarService.findById(dt.getCalendar().getId());
        BloodCenter bloodCenter = bloodCenterService.findById(dt.getBloodCenter().getId());
        RegisteredUser registeredUser = registeredUserService.findById(dt.getRegisteredUser().getId());
        Survey survey = this.surveyService.findById(dt.getSurvey().getId());


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime date =LocalDateTime.parse(dt.getDate().toString(),formatter);
        LocalDateTime start = LocalDateTime.parse(dt.getReservationStart(),formatter);
        LocalDateTime end = LocalDateTime.parse(dt.getReservationEnd(),formatter);



        TimePeriodDTO time=new TimePeriodDTO();
        time.setStart(dt.getReservationStart());
        time.setEnd(dt.getReservationEnd());

        DonationTerms newTerm = new DonationTerms(dt.getId(),date,dt.isFree(),start,end, dt.getDuration(),registeredUser,calendar,bloodCenter,survey);

        donationTermsRepository.save(newTerm);

        System.out.println("POZVAO SI 3.8 F-JU");

        DefinedTermDTO definedTermsDTO = new DefinedTermDTO(newTerm.getId(), newTerm.getDuration(),
                newTerm.getDate().format(formatter), newTerm.isFreeTerm(),
                newTerm.getReservationStart().format(formatter),
                newTerm.getReservationEnd().format(formatter),registeredUser,calendar,bloodCenter,survey);


        return definedTermsDTO;

    }

    //3.4 Kreiranje Brzih rezervacija sa jednim klikom
    public DefinedTermDTO createFastReservation(DefinedTermDTO dt) throws PessimisticLockingFailureException, DateTimeException
    {
        Calendar calendar = calendarService.findById(dt.getCalendar().getId());
        BloodCenter bloodCenter = bloodCenterService.findById(dt.getBloodCenter().getId());
        RegisteredUser registeredUser = registeredUserService.findById(dt.getRegisteredUser().getId());
        Survey survey = this.surveyService.findById(dt.getSurvey().getId());
        Stuff  stuff = this.stuffService.findById(dt.getStuff().getId());

        LocalDateTime present_time = LocalDateTime.now();
        boolean is_past_term = false;


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime date =LocalDateTime.parse(dt.getDate().toString(),formatter);
        LocalDateTime start = LocalDateTime.parse(dt.getReservationStart(),formatter);
        LocalDateTime end = LocalDateTime.parse(dt.getReservationEnd(),formatter);

        TimePeriodDTO time=new TimePeriodDTO();
        time.setStart(dt.getReservationStart());
        time.setEnd(dt.getReservationEnd());

        DonationTerms newTerm = new DonationTerms(dt.getId(), date, dt.getDuration(), dt.isFree(), start, end,
                                                      registeredUser, bloodCenter, calendar, stuff, survey);

        if(newTerm.getDate().isAfter(present_time.minusDays(1)) &&
                newTerm.getReservationStart().isAfter(present_time.minusDays(1)) &&
                newTerm.getReservationEnd().isAfter(present_time.minusDays(1)))
        {
            is_past_term = false;
            donationTermsRepository.save(newTerm);
            System.out.println("Zoves Kako treba");
        }



        //donationTermsRepository.save(newTerm);

       // System.out.println("POZVAO SI 3.4 F-JU");


        DefinedTermDTO definedTermsDTO = new DefinedTermDTO(newTerm.getId(), newTerm.getDuration(),
                newTerm.getDate().format(formatter), newTerm.isFreeTerm(),
                newTerm.getReservationStart().format(formatter),newTerm.getReservationEnd().format(formatter),
                registeredUser,calendar,bloodCenter,survey, stuff);


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


        DonationTermsDTO donationTermsDTO = new DonationTermsDTO(new_term.getId(), new_term.getDuration(), new_term.isFreeTerm(),
                new_term.getReservationStart().format(formatter),
                new_term.getReservationEnd().format(formatter),  new_term.getRegisteredUser(),bloodCenter);

        //return CottageFastReservationMapper.convertToDTO(fast);
        return donationTermsDTO;

    }



    public DonationTerms save(DonationTerms newDonationTerm)
    {
        return this.donationTermsRepository.save(newDonationTerm);
    }


    public boolean isUserScheduleDonationTerm(Long userId){
        int number_of_schedule_donation=0;
        RegisteredUser registeredUser=this.registeredUserService.findById(userId);
        List<DonationTerms> donationTerms=this.donationTermsRepository.findAll();
        for (DonationTerms dt:donationTerms) {
            if(dt.getRegisteredUser()!=null && dt.getRegisteredUser()==registeredUser){
                number_of_schedule_donation++;
            }
        }
        if(number_of_schedule_donation!=0){
            return true;
        }
        return false;
    }
    public boolean isUserGaveBloodInLast6Month(Long userId){
        LocalDateTime currentTime = LocalDateTime.now();
        RegisteredUser registeredUser=this.registeredUserService.findById(userId);
        List<DonationTerms> donationTerms=this.donationTermsRepository.findAll();
        int num_of_give_blood_in_last_6_month=0;
        for (DonationTerms dt:donationTerms) {
            if(dt.getRegisteredUser()!=null){
                // 1.provera da li je to taj korisnik
                // 2.provera da li je termin pre 6 meseci
                // 3.provera da li je korisnik odsao na termin
                if(dt.getRegisteredUser()==registeredUser && dt.getReservationStart().isAfter(currentTime.minusMonths(6)) &&dt.isRegisteredUserCome()==true && dt.isFreeTerm()==true){
                    num_of_give_blood_in_last_6_month=num_of_give_blood_in_last_6_month+1;
                }
            }
        }
        if(num_of_give_blood_in_last_6_month!=0){
            return true;
        }
        return false;
    }

    public boolean whetherRegisteredUserHasThreePenalties(Long userId){
        RegisteredUser registeredUser=this.registeredUserService.findById(userId);
        if(registeredUser.getPoints()>2)
        {
            return true;
        }
        return false;

    }


    public DonationTerms findById1(Long id){
        Optional<DonationTerms> donationTermOptional = this.donationTermsRepository.findById(id);
        if (!donationTermOptional.isPresent()) {
            return null;
        }
        return donationTermOptional.get();
    }
    public DonationTerms scheduleTerm(ScheduleDonationTermDTO dto){
        RegisteredUser registeredUser = this.registeredUserService.findById(dto.getRegisteredUserId());
        Survey survey = this.surveyService.findById(dto.getSurveyId());
        DonationTerms donationTerm = this.findById1(dto.getDonationTermId());
        if(this.isUserGaveBloodInLast6Month(dto.getRegisteredUserId())==false){
            donationTerm.setFreeTerm(false);
            donationTerm.setRegisteredUserCome(false);
            donationTerm.setRegisteredUser(registeredUser);
            donationTerm.setSurvey(survey);
            return this.donationTermsRepository.save(donationTerm);
        }
        return null;
    }
    public DonationTerms scheduleTerm1(ScheduleDonationTerm1DTO dto){
        RegisteredUser registeredUser = this.registeredUserService.findById(dto.getRegisteredUserId());
        Survey survey = this.surveyRepository.save(dto.getSurvey());
        DonationTerms donationTerm = this.findById1(dto.getDonationTermId());
        if(this.isUserGaveBloodInLast6Month(dto.getRegisteredUserId())==false){
            donationTerm.setFreeTerm(false);
            donationTerm.setRegisteredUserCome(false);
            donationTerm.setRegisteredUser(registeredUser);
            donationTerm.setSurvey(survey);
            return this.donationTermsRepository.save(donationTerm);
        }
        return null;
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

        if (timeOfDonationTerm.isAfter(currentDateMinus1Day1)) {
            if(donationTerms1.getRegisteredUser().getId().equals(registeredUser.getId()))
            {
                donationTerms1.setRegisteredUser(null);
                donationTerms1.setSurvey(null);
                donationTerms1.setFreeTerm(true);

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

    public DonationTerms UpdateDonationTerms(DonationTerms dt)
    {
        DonationTerms donationTerm = donationTermsRepository.getById(dt.getId());

        donationTerm.setSurvey(dt.getSurvey());


        return  this.donationTermsRepository.save(donationTerm);
    }

}