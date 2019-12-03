 import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { UserFormComponent } from './components/registration/form/user-form/user-form.component';
import { UserService } from './services/reg-user/user.service';
import { EwalletFormComponent } from './components/ewallet/ewallet-form/ewallet-form.component';
import {NgbDropdownModule, NgbModule, NgbPaginationModule} from '@ng-bootstrap/ng-bootstrap';
import { CompanyFormComponent } from './components/registration/form/company-form/company-form.component';
import { LoginFormComponent } from './components/login/login-form/login-form.component';
import { UserHomeFormComponent } from './components/home/form/user-home-form/user-home-form.component';
import { UserRegistrationPageFormComponent } from './pages/user-registration-page-form/user-registration-page-form.component';
import { HeaderFormComponent } from './components/header/header-form/header-form.component';
import { CompanyRegistrationPageFormComponent } from './pages/company-registration-page-form/company-registration-page-form.component';
import { LoginPageFormComponent } from './pages/login-page-form/login-page-form.component';
import { UserHomePageFormComponent } from './pages/user-home-page-form/user-home-page-form.component';
import { CompanyHomePageFormComponent } from './pages/company-home-page-form/company-home-page-form.component';
import { HeaderAdminFormComponent } from './components/header/header-admin-form/header-admin-form.component';
import { UserTableFormComponent } from './components/user/user-table-form/user-table-form.component';
import { ServicesFormComponent } from './components/service/services-form/services-form.component';
import { HeaderCompanyFormComponent } from './components/header/header-company-form/header-company-form.component';
import { HeaderUserFormComponent } from './components/header/header-user-form/header-user-form.component';
import { SubscriptionFormComponent } from './components/subscription/subscription-form/subscription-form.component';
import { UserSubscriptionPageFormComponent } from './pages/user-subscription-page-form/user-subscription-page-form.component';
import { EwalletPageFormComponent } from './pages/ewallet-page-form/ewallet-page-form.component';
import { AdminHomeFormComponent } from './components/home/form/admin-home-form/admin-home-form.component';
import { AdminHomePageFormComponent } from './pages/admin-home-page-form/admin-home-page-form.component';
import { CategoryFormComponent } from './components/category/category-form/category-form.component';
import { CategoryPageFormComponent } from './pages/category-page-form/category-page-form.component';
import {TokenStorage} from "./token.storage";

@NgModule({
  declarations: [
    AppComponent,
    UserFormComponent,
    EwalletFormComponent,
    CompanyFormComponent,
    LoginFormComponent,
    UserHomeFormComponent,
    UserRegistrationPageFormComponent,
    HeaderFormComponent,
    CompanyRegistrationPageFormComponent,
    LoginPageFormComponent,
    UserHomePageFormComponent,
    CompanyHomePageFormComponent,
    HeaderAdminFormComponent,
    UserTableFormComponent,
    ServicesFormComponent,
    HeaderCompanyFormComponent,
    HeaderUserFormComponent,
    SubscriptionFormComponent,
    UserSubscriptionPageFormComponent,
    EwalletPageFormComponent,
    AdminHomeFormComponent,
    AdminHomePageFormComponent,
    CategoryFormComponent,
    CategoryPageFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbDropdownModule,
    NgbPaginationModule,
    NgbModule
  ],
  providers: [UserService,TokenStorage],
  bootstrap: [AppComponent]
})
export class AppModule { }
