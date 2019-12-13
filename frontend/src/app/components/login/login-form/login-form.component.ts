import {Component, OnInit} from '@angular/core';
import {UserService} from "../../../services/reg-user/user.service";
import {Subscription} from "rxjs";
import {Router} from "@angular/router";
import {LoginService} from "../../../services/login/login.service";
import {TokenStorage} from "../../../token.storage";
import {Login} from "../../../model/login/login";
import {Role} from "../../../model/enums/role";
import {CompanyService} from "../../../services/company/company.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  public loginForm;
  public showValidationMessages: boolean = false;

  constructor(private router: Router,
              private loginService: LoginService,
              private tokenStorage: TokenStorage,
              private userService: UserService,
              private companyService: CompanyService) {
  }

  public logIn(): void {
    if (!this.loginForm.get("login").valid || !this.loginForm.get("password").valid) {
      this.showValidationMessages = true;
    } else {

        this.loginService.authenticate(this.loginForm.get("login").value, this.loginForm.get("password").value).subscribe(
          data => {
            this.tokenStorage.setToken(data.token);
            this.loginService.getLogin().subscribe(login => {
              this.tokenStorage.setCurrentLogin(login);
              if (login.role == Role.COMPANY) {
                this.companyService.getByLoginId(login.id).subscribe(company => {
                  this.tokenStorage.setCurrentCompany(company)
                });
                this.router.navigateByUrl('company-home');
              } else if (login.role == Role.USER) {
                this.userService.getUserByLoginId(login.id).subscribe(user => {
                  this.tokenStorage.setCurrentUser(user)
                });
                this.router.navigateByUrl('user-home');
              }
            });

          },
          error => {
            console.log(error);
          });
    }

  }

  ngOnInit() {
    this.loginForm = new FormGroup({
      login: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', Validators.required),
    });
  }

}
