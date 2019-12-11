import { Component, OnInit } from '@angular/core';
import {Service} from "../../model/services/service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {Ewallet} from "../../model/ewallet/ewallet";
import {Subscription} from "rxjs";
import {Login} from "../../model/login/login";
import {LoginService} from "../../services/login/login.service";
import {EwalletService} from "../../services/ewallet/ewallet.service";
import {ServicesService} from "../../services/service/services.service";
import {RegCompany} from "../../model/company/reg-company";
import {CompanyService} from "../../services/company/company.service";

@Component({
  selector: 'app-add-service-form',
  templateUrl: './add-service-form.component.html',
  styleUrls: ['./add-service-form.component.css']
})
export class AddServiceFormComponent implements OnInit {

  public page: number;
  public pageSize: number = 3;
  public collectionSize: number;

  public selectedService: Service = new Service();
  private subscriptionsRxjs: Subscription[] = [];

  public ewallet: Ewallet = new Ewallet();
  public ewallets: Ewallet[] = [];
  public selectedEwallet: Ewallet;

  private currentLogin: Login;
  private currentCompany: RegCompany;

  constructor(private modalService: NgbModal,
              private loginService: LoginService,
              private ewalletService: EwalletService,
              private companyService: CompanyService,
              private servicesService: ServicesService) {
  }

  ngOnInit() {
    this.loadLogin();
    this.page = 1;
    this.getSize();
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
        this.loadWallets();
      })
    )
  }

  private loadWallets(): void {
    this.subscriptionsRxjs.push(
      this.ewalletService.getByLoginID(this.page, this.pageSize, this.currentLogin.id).subscribe(wallets => {
        this.ewallets = wallets as Ewallet[];
      })
    )
  }

  getSize() {
    this.ewalletService.getSize().subscribe
    ((size: number) => {
      this.collectionSize = size
    });
  }

  onPageChanged(pageNum) {
    this.page = pageNum;
    this.loadWallets();
  }

  openModal(content, ewallet) {
    this.selectedEwallet = ewallet;
    this.modalService.open(content, {centered: true});
  }

  createService() {
    this.selectedService.companyId = this.currentCompany.id;
    this.servicesService.add(this.selectedService).subscribe(() => {
    });
  }
}
