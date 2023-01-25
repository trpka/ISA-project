package com.example.ISAproject.model;

import com.example.ISAproject.service.RegisteredUserService;
import com.example.ISAproject.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Date;


@Component
public class MySchedule {

    @Autowired
    private RegisteredUserService registeredUserService;


    @Scheduled(cron = "0 0 0 1 * *") // svaki prvi dan u mesecu
    //@Scheduled(cron = "0 * * * * *") //svaki minut
    public void myMethod() throws ParseException {


        List<RegisteredUser>  registeredUsers= this.registeredUserService.findAll();
        for(RegisteredUser registeredUser: registeredUsers)
        {
           registeredUser.setPoints(0);
           this.registeredUserService.save(registeredUser);
        }
    }
}
