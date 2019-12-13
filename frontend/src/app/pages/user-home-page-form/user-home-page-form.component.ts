import { Component, OnInit } from '@angular/core';
import {TokenStorage} from "../../token.storage";
import {Role} from "../../model/enums/role";

@Component({
  selector: 'app-user-home-page-form',
  templateUrl: './user-home-page-form.component.html',
  styleUrls: ['./user-home-page-form.component.css']
})
export class UserHomePageFormComponent implements OnInit {

  user:Role.USER;

  constructor(private tokenStorage: TokenStorage) { }

  ngOnInit() {
  }

}
