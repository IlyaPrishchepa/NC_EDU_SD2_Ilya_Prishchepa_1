import { Component, OnInit } from '@angular/core';
import {RegUser} from "../../user/model/reg-user";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  public user: RegUser = new RegUser();

  public _logIn() {
    console.log(this.user);
  }

  constructor() { }

  ngOnInit() {
  }

}
