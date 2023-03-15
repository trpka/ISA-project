import { NgModule } from '@angular/core';
import {MatDialogModule} from '@angular/material/dialog';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { NavbarComponent } from './navbar/navbar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon'; 
import {MatButtonModule} from '@angular/material/button';
import { HomeComponent } from './home/home.component';
import { NavbarHomeComponent } from './navbar-home/navbar-home.component';
import { QuestionnaireComponent } from './questionnaire/questionnaire.component'; 
import {MatRadioModule} from '@angular/material/radio';
import { HomeRegisteredUserComponent } from './home-registered-user/home-registered-user.component';
import { ProfileCenterComponent } from './profile-center/profile-center.component';
import { TokenInterceptor } from './interceptor/TokenInterceptor';
import { SearchCenterComponent } from './search-center/search-center.component';
import { DonationTermsComponent } from './donation-terms/donation-terms.component';
import { RegisteredUserEditComponent } from './registered-user-edit/registered-user-edit.component';
import { StuffEditComponent } from './stuff-edit/stuff-edit.component';
import { ReactiveFormsModule } from '@angular/forms';
import { RegistrationStuffComponent } from './registration-stuff/registration-stuff.component';
import { SerchRegisteredUserComponent } from './serch-registered-user/serch-registered-user.component';
import { RegistrationBloodCenterComponent } from './registration-blood-center/registration-blood-center.component';

import { ConfirmRegistrationRegisteredUserComponent } from './confirm-registration-registered-user/confirm-registration-registered-user.component';

import { CreateDonationTermComponent } from './create-donation-term/create-donation-term.component';
import { AllRegisteredUsersComponent } from './all-registered-users/all-registered-users.component';
import { StuffUserProfileComponent } from './stuff-user-profile/stuff-user-profile.component';
import { StuffSurveyComponent } from './stuff-survey/stuff-survey.component';

import { ScheduledAppointmentsComponent } from './scheduled-appointments/scheduled-appointments.component';

import { CalendarDefindedTermsComponent } from './calendar-definded-terms/calendar-definded-terms.component';
import { ListOfTermsComponent } from './list-of-terms/list-of-terms.component';
import { SearchAvaliableTermsComponent } from './search-avaliable-terms/search-avaliable-terms.component';
import { SearchAvaliableCentersComponent } from './search-avaliable-centers/search-avaliable-centers.component';
import { NewProfileCenterComponent } from './new-profile-center/new-profile-center.component';
import { HistoryTermsComponent } from './history-terms/history-terms.component';
import { FutureTermsComponent } from './future-terms/future-terms.component';
import { PopUpCannotReservateTermComponent } from './pop-up-cannot-reservate-term/pop-up-cannot-reservate-term.component';
import { PopUpCanReservateTermComponent } from './pop-up-can-reservate-term/pop-up-can-reservate-term.component';
import { Questionnaire2Component } from './questionnaire2/questionnaire2.component';
import { PopUpRegisteredUserHaveThreePenaltiesComponent } from './pop-up-registered-user-have-three-penalties/pop-up-registered-user-have-three-penalties.component';
import { PopUpDisableCancelReservationComponent } from './pop-up-disable-cancel-reservation/pop-up-disable-cancel-reservation.component';
import { PopUpSuccessfullyMakeAppointmentComponent } from './pop-up-successfully-make-appointment/pop-up-successfully-make-appointment.component';
import { PopUpCancelReservationComponent } from './pop-up-cancel-reservation/pop-up-cancel-reservation.component';
import { AddFastReservationComponent } from './add-fast-reservation/add-fast-reservation.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { BloodCalendarComponent } from './blood-calendar/blood-calendar.component';






@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    NavbarComponent,
    HomeComponent,
    NavbarHomeComponent,
    QuestionnaireComponent,
    HomeRegisteredUserComponent,
    ProfileCenterComponent,
    SearchCenterComponent,
    DonationTermsComponent,
    RegisteredUserEditComponent,
    StuffEditComponent,
    RegistrationStuffComponent,
    SerchRegisteredUserComponent,
    RegistrationBloodCenterComponent,

    ConfirmRegistrationRegisteredUserComponent,

    CreateDonationTermComponent,
    AllRegisteredUsersComponent,
    StuffUserProfileComponent,
    StuffSurveyComponent,


    StuffUserProfileComponent,
    ScheduledAppointmentsComponent,


    StuffUserProfileComponent,
    CalendarDefindedTermsComponent,
    StuffUserProfileComponent,
    ListOfTermsComponent,
    SearchAvaliableTermsComponent,
    SearchAvaliableCentersComponent,
    NewProfileCenterComponent,
    HistoryTermsComponent,
    FutureTermsComponent,
    PopUpCannotReservateTermComponent,
    PopUpCanReservateTermComponent,
    Questionnaire2Component,
    PopUpRegisteredUserHaveThreePenaltiesComponent,
    PopUpDisableCancelReservationComponent,
    PopUpSuccessfullyMakeAppointmentComponent,
    PopUpCancelReservationComponent,
    AddFastReservationComponent,
    ChangePasswordComponent,
    BloodCalendarComponent


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatRadioModule,
    MatDialogModule,
    ReactiveFormsModule
  ],
  providers: [
    DatePipe,
    {
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptor,
    multi: true
  }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
