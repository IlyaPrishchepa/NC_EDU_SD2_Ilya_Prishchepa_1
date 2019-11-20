import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {CompanyService} from "../../services/company/company.service";

@Component({
  selector: 'app-user-registration-page-form',
  templateUrl: './user-registration-page-form.component.html',
  styleUrls: ['./user-registration-page-form.component.css']
})
export class UserRegistrationPageFormComponent implements OnInit {

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private companyService: CompanyService) {

  }

  ngOnInit() {
  }

}
