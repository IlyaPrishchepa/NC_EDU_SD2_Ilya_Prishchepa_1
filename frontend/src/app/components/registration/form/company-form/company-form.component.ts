import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {RegCompany} from '../../model/company/reg-company';
import {CompanyService} from '../../../../services/company/company.service';

@Component({
  selector: 'app-company-form',
  templateUrl: './company-form.component.html',
  styleUrls: ['./company-form.component.css']
})
export class CompanyFormComponent implements OnInit {

  regCompany: RegCompany = {loginid: {}} as RegCompany;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private companyService: CompanyService) {

  }

  onSubmit() {
    this.companyService.save(this.regCompany);
  }

  ngOnInit(): void {
  }

}
