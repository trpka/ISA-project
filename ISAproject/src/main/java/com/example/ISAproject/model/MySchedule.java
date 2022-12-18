package com.example.ISAproject.model;

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
    private SurveyService surveyService;

    @Scheduled(cron = "0 0 6 * * ?") // svaki dan u 6 ujutru
    //@Scheduled(cron = "0 * * ? * *") //svaki minut
    public void myMethod() throws ParseException {
        //trenutno vreme
        LocalDateTime currentTime = LocalDateTime.now();
        //trenutno vreme - 6 meseci
        LocalDateTime currentDateMinus6Months = currentTime.minusMonths(6);
        //LocalDateTime currentDateMinus6Months = currentTime.minusMinutes(1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //pretvoreno u string
        String currentDateMinus6MonthsString = currentDateMinus6Months.format(formatter);


        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime currentDateMinus6Months1 = LocalDateTime.parse(currentDateMinus6MonthsString, formatter1);

        List<Survey> surveys = this.surveyService.findAll();
        for(Survey survey: surveys)
        {
            String timeOfCreatingTheQuestionnaireString = survey.getDate();

            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime timeOfCreatingTheQuestionnaire = LocalDateTime.parse(timeOfCreatingTheQuestionnaireString, formatter2);

            if (timeOfCreatingTheQuestionnaire.isBefore(currentDateMinus6Months1)) {
                this.surveyService.delete(survey);
            }

        }
    }
}
