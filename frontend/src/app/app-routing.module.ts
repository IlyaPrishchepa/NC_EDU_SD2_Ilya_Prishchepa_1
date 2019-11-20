import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserFormComponent } from './components/registration/form/user-form/user-form.component';
import {EwalletFormComponent} from './components/ewallet/ewallet-form/ewallet-form.component';
import {CompanyFormComponent} from './components/registration/form/company-form/company-form.component';
import {LoginFormComponent} from './components/login/login-form/login-form.component';
import {UserHomeFormComponent} from './components/home/form/user-home-form/user-home-form.component';

const routes: Routes = [
  { path: 'registration-user', component: UserFormComponent },
  { path: 'registration-company', component: CompanyFormComponent },
  { path: 'login', component: LoginFormComponent },
  { path: 'ewallet', component: EwalletFormComponent },
  { path: 'user-home', component: UserHomeFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
