import { Component, OnInit } from '@angular/core';
import {RegUser} from "../../../model/user/reg-user";
import {Subscription} from "rxjs";
import {Router} from "@angular/router";
import {LoginService} from "../../../services/login/login.service";
import {TokenStorage} from "../../../token.storage";
import {Login} from "../../../model/login/login";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  public login: Login = new Login();

  private subscriptions: Subscription[] = [];

  constructor(private router: Router,
              private loginService: LoginService,
              private tokenStorage: TokenStorage) { }

  public logIn(): void {
    this.subscriptions.push(
    this.loginService.authenticate(this.login.email, this.login.password).subscribe(
      data => {
        this.tokenStorage.setToken(data.token);
        this.router.navigateByUrl('user-home');
      },
      error => {
        console.log(error);
      })
  );
  }
  ngOnInit() {
  }

}
