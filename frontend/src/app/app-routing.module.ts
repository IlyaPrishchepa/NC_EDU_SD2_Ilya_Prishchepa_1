import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UserRegistrationPageFormComponent} from "./pages/user-registration-page-form/user-registration-page-form.component";
import {CompanyRegistrationPageFormComponent} from "./pages/company-registration-page-form/company-registration-page-form.component";
import {LoginPageFormComponent} from "./pages/login-page-form/login-page-form.component";
import {UserHomePageFormComponent} from "./pages/user-home-page-form/user-home-page-form.component";
import {UserSubscriptionPageFormComponent} from "./pages/user-subscription-page-form/user-subscription-page-form.component";
import {EwalletPageFormComponent} from "./pages/ewallet-page-form/ewallet-page-form.component";
import {AdminHomePageFormComponent} from "./pages/admin-home-page-form/admin-home-page-form.component";
import {CategoryPageFormComponent} from "./pages/category-page-form/category-page-form.component";

const routes: Routes = [
  { path: 'registration-user', component: UserRegistrationPageFormComponent },
  { path: 'registration-company', component: CompanyRegistrationPageFormComponent},
  { path: 'login', component: LoginPageFormComponent },
  { path: 'user-subscription', component: UserSubscriptionPageFormComponent },
  { path: 'user-home', component: UserHomePageFormComponent },
  { path: 'ewallet', component: EwalletPageFormComponent },
  { path: 'admin-home', component: AdminHomePageFormComponent },
  { path: 'category', component: CategoryPageFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
