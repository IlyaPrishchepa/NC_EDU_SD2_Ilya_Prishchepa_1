import { Component, OnInit } from '@angular/core';
import {Role} from "../../model/enums/role";
import {TokenStorage} from "../../token.storage";

@Component({
  selector: 'app-company-home-page-form',
  templateUrl: './company-home-page-form.component.html',
  styleUrls: ['./company-home-page-form.component.css']
})
export class CompanyHomePageFormComponent implements OnInit {

  company:Role.COMPANY;

  constructor(private tokenStorage: TokenStorage) { }

  ngOnInit() {
  }

}
