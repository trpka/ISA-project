import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeRegisteredUserComponent } from './home-registered-user/home-registered-user.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { QuestionnaireComponent } from './questionnaire/questionnaire.component';
import { RegistrationComponent } from './registration/registration.component';

const routes: Routes = [
  {path: '', component:HomeComponent},
  {path: 'login', component:LoginComponent},
  {path: 'registration', component:RegistrationComponent},
  {path: 'questionnaire', component:QuestionnaireComponent},
  {path: 'home/registered-user', component:HomeRegisteredUserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
