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


const routes: Routes = [
  {path: '', component:HomeComponent},
  {path: 'login', component:LoginComponent},
  {path: 'registration', component:RegistrationComponent},
  {path: 'questionnaire', component:QuestionnaireComponent},
  {path: 'home/registered-user', component:HomeRegisteredUserComponent},
  {path: 'profile-center', component: ProfileCenterComponent},
  { path: 'search-center', component: SearchCenterComponent },
  {path: 'profile_center/:id', component: ProfileCenterComponent},

  {path: 'donation_terms/:id', component: DonationTermsComponent},
  

  {path: 'donation_terms', component: DonationTermsComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
