import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../../../../services/reg-user/user.service';
import { RegUser } from '../../../user/model/reg-user';
import {Subscription} from "rxjs";


@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})

export class UserFormComponent implements  OnInit{

  regUser: RegUser = {loginid: {}} as RegUser;

  private subscriptions: Subscription[] = [];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService) {

    this.regUser = new RegUser();
  }

  signIn(): void {
    this.subscriptions.push(
      this.userService.save(this.regUser).subscribe(data => {
          this.regUser = data;
          alert('Ok');
          this.router.navigateByUrl('login');
        },
        error => {
          alert('Error xxx');
          console.log(error);
        })
    );
  }

  ngOnInit(): void {
  }

}
