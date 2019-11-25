import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EwalletFormComponent} from './components/ewallet/ewallet-form/ewallet-form.component';
import {UserRegistrationPageFormComponent} from "./pages/user-registration-page-form/user-registration-page-form.component";
import {CompanyRegistrationPageFormComponent} from "./pages/company-registration-page-form/company-registration-page-form.component";
import {LoginPageFormComponent} from "./pages/login-page-form/login-page-form.component";
import {UserHomePageFormComponent} from "./pages/user-home-page-form/user-home-page-form.component";
import {ServicesFormComponent} from "./components/services/services-form/services-form.component";

const routes: Routes = [
  { path: 'registration-user', component: UserRegistrationPageFormComponent },
  { path: 'registration-company', component: CompanyRegistrationPageFormComponent},
  { path: 'login', component: LoginPageFormComponent },
  { path: 'user-home', component: UserHomePageFormComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
