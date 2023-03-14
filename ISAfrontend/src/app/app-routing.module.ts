import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeRegisteredUserComponent } from './home-registered-user/home-registered-user.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { QuestionnaireComponent } from './questionnaire/questionnaire.component';
import { RegistrationComponent } from './registration/registration.component';
import { ProfileCenterComponent } from './profile-center/profile-center.component';
import { SearchCenterComponent } from './search-center/search-center.component';
import { DonationTermsComponent } from './donation-terms/donation-terms.component';
import { RegisteredUserEditComponent } from './registered-user-edit/registered-user-edit.component';
import { StuffEditComponent } from './stuff-edit/stuff-edit.component';
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
import { Questionnaire2Component } from './questionnaire2/questionnaire2.component';
import { AddFastReservationComponent } from './add-fast-reservation/add-fast-reservation.component';
import { ChangePasswordComponent } from './change-password/change-password.component';

const routes: Routes = [
  {path: '', component:HomeComponent},
  {path: 'login', component:LoginComponent},
  {path: 'registration', component:RegistrationComponent},
  {path: 'questionnaire', component:QuestionnaireComponent},
  {path: 'home/registered-user', component:HomeRegisteredUserComponent},
  {path: 'profile-center', component: ProfileCenterComponent},
  { path: 'search-center', component: SearchCenterComponent },
  {path: 'profile_center/:id', component: ProfileCenterComponent},
  {path: 'new_profile_center', component:NewProfileCenterComponent },
  {path: 'new_profile_center/:id', component:NewProfileCenterComponent },
  {path: 'donation_terms/:id', component: DonationTermsComponent},
  {path: 'donation_terms', component: DonationTermsComponent},
  {path: 'regUser_edit/:id', component: RegisteredUserEditComponent},
  {path: 'stuff_edit/:id', component: StuffEditComponent},
  {path: 'registration-stuff', component: RegistrationStuffComponent},
  {path: 'registered-users-search', component:  SerchRegisteredUserComponent},
  {path: 'registration-blood-center', component:  RegistrationBloodCenterComponent},

  {path: 'confirm-registration/:id', component:  ConfirmRegistrationRegisteredUserComponent},
  {path: 'create-term', component:CreateDonationTermComponent},
  {path: 'all_registered_users',component: AllRegisteredUsersComponent},
  {path: 'stuff_user_profile/:id',component: StuffUserProfileComponent},

  {path: 'defined_terms/:id', component:CalendarDefindedTermsComponent},  
  {path:'viewAllTerms', component:ListOfTermsComponent},


  {path: 'stuff_survey/:id', component: StuffSurveyComponent},
  {path: 'add_fast_reservation', component: AddFastReservationComponent},


  {path: 'scheduled-appointments/:id', component:  ScheduledAppointmentsComponent},

  {path: 'defined_terms/:id', component:CalendarDefindedTermsComponent},
  {path: 'avaliableTerms', component: SearchAvaliableTermsComponent},
  {path: 'avaliableCenters', component: SearchAvaliableCentersComponent},
  {path: 'history-terms', component: HistoryTermsComponent},
  {path: 'future-terms', component: FutureTermsComponent},

  {path: 'questionnaire2', component: Questionnaire2Component},
  {path: 'change_password', component: ChangePasswordComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
