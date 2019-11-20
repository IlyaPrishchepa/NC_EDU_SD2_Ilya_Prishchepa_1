import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { UserFormComponent } from './components/registration/form/user-form/user-form.component';
import { UserService } from './services/user/user.service';
import { EwalletFormComponent } from './components/ewallet/ewallet-form/ewallet-form.component';
import {NgbDropdownModule, NgbPaginationModule} from '@ng-bootstrap/ng-bootstrap';
import { CompanyFormComponent } from './components/registration/form/company-form/company-form.component';
import { LoginFormComponent } from './components/login/login-form/login-form.component';
import { UserHomeFormComponent } from './components/home/form/user-home-form/user-home-form.component';

@NgModule({
  declarations: [
    AppComponent,
    UserFormComponent,
    EwalletFormComponent,
    CompanyFormComponent,
    LoginFormComponent,
    UserHomeFormComponent
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
