import { Component, OnInit } from '@angular/core';
import {Service} from "../../../model/services/service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {ServicesService} from "../../../services/service/services.service";
import {Login} from "../../../model/login/login";
import {Subscription} from "rxjs";
import {LoginService} from "../../../services/login/login.service";
import {UserService} from "../../../services/reg-user/user.service";
import {RegCompany} from "../../../model/company/reg-company";
import {CompanyService} from "../../../services/company/company.service";

@Component({
  selector: 'app-company-home-form',
  templateUrl: './company-home-form.component.html',
  styleUrls: ['./company-home-form.component.css']
})
export class CompanyHomeFormComponent implements OnInit {

  public page:number;
  public pageSize: number = 6;
  public collectionSize: number;

  public selectedService: Service;
  public services: Service[] = [];
  private subscriptionsRxjs: Subscription[] = [];

  private currentLogin: Login;
  private currentCompany: RegCompany;

  constructor(private modalService: NgbModal,
              private servicesService:ServicesService,
              private loginService: LoginService,
              private companyService: CompanyService)
  {
    this.page=1;
  }

  ngOnInit() {
    this.loadLogin();
  }


  private loadLogin(): void {
    this.subscriptionsRxjs.push(
      this.loginService.getLogin().subscribe(login => {
        this.currentLogin = login;
        this.loadCompany();
      })
    )
  }

  private loadCompany(): void {
    this.subscriptionsRxjs.push(
      this.companyService.getByLoginId(this.currentLogin.id).subscribe(company => {
        this.currentCompany = company;
        this.getServicesSize();
        this.getServices();
      })
    )
  }

  getServices() {
    this.subscriptionsRxjs.push(
      this.servicesService.getByCompanyId(this.page,this.pageSize,this.currentCompany.id)
      .subscribe((services: Service[])=>{
        this.services = services
      }));
  }

  getServicesSize(){
    this.servicesService.getSize().subscribe
    ((size:number)=>{this.collectionSize = size});
  }

  onPageChanged(pageNum){
    this.page=pageNum
    this.getServices();
  }

  openModal(content, service) {
    this.selectedService = service;
    const modalRef = this.modalService.open(content);
  }


}
