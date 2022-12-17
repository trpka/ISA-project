import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';

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
    StuffSurveyComponent


    StuffUserProfileComponent,
    ScheduledAppointmentsComponent,


    StuffUserProfileComponent,
    CalendarDefindedTermsComponent,
    StuffUserProfileComponent


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
    MatRadioModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptor,
    multi: true
  }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
