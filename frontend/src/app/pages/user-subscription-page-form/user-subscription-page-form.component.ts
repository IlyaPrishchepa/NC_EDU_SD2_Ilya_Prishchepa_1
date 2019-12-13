import { Component, OnInit } from '@angular/core';
import {Role} from "../../model/enums/role";
import {TokenStorage} from "../../token.storage";

@Component({
  selector: 'app-user-subscription-page-form',
  templateUrl: './user-subscription-page-form.component.html',
  styleUrls: ['./user-subscription-page-form.component.css']
})
export class UserSubscriptionPageFormComponent implements OnInit {

  user:Role.USER;

  constructor(private tokenStorage: TokenStorage) { }

  ngOnInit() {
  }

}
