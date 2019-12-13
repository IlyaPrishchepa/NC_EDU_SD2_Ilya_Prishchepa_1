import { Component, OnInit } from '@angular/core';
import {Role} from "../../model/enums/role";
import {TokenStorage} from "../../token.storage";

@Component({
  selector: 'app-ewallet-page-form',
  templateUrl: './ewallet-page-form.component.html',
  styleUrls: ['./ewallet-page-form.component.css']
})
export class EwalletPageFormComponent implements OnInit {

  user:Role.USER;

  constructor(private tokenStorage: TokenStorage) { }

  ngOnInit() {
  }

}
