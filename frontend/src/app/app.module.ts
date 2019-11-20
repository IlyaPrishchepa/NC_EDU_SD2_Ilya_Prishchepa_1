import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { UserFormComponent } from './components/registration/form/user-form/user-form.component';
import { UserService } from './services/reg-user/user.service';
import { EwalletFormComponent } from './components/ewallet/ewallet-form/ewallet-form.component';
import {NgbDropdownModule, NgbPaginationModule} from '@ng-bootstrap/ng-bootstrap';
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
    UserTableFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbDropdownModule,
    NgbPaginationModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
