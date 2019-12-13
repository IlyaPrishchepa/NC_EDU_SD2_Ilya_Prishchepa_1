import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {RegCompany} from '../../../model/company/reg-company';
import {CompanyService} from '../../../services/company/company.service';
import {Subscription} from "rxjs";
import {Role} from "../../../model/enums/role";
import {UserService} from "../../../services/reg-user/user.service";

@Component({
  selector: 'app-company-form',
  templateUrl: './company-form.component.html',
  styleUrls: ['./company-form.component.css']
})
export class CompanyFormComponent implements OnInit {

  regCompany: RegCompany = {loginId: {}} as RegCompany;

  private subscriptionsRxjs: Subscription[] = [];
  private role: Role.COMPANY;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private companyService: CompanyService) {

    this.regCompany = new RegCompany();
    this.regCompany.role = this.role;
  }

  signIn(): void {
    this.subscriptionsRxjs.push(
      this.companyService.save(this.regCompany).subscribe(data => {
          this.regCompany = data;
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
