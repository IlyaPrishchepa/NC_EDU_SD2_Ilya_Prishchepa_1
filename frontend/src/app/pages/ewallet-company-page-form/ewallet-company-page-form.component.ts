import { Component, OnInit } from '@angular/core';
import {Role} from "../../model/enums/role";
import {TokenStorage} from "../../token.storage";

@Component({
  selector: 'app-ewallet-company-page-form',
  templateUrl: './ewallet-company-page-form.component.html',
  styleUrls: ['./ewallet-company-page-form.component.css']
})
export class EwalletCompanyPageFormComponent implements OnInit {

  company:Role.COMPANY;

  constructor(private tokenStorage: TokenStorage) { }

  ngOnInit() {
  }


}
