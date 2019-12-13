import { Component, OnInit } from '@angular/core';
import {Service} from "../../model/services/service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {Ewallet} from "../../model/ewallet/ewallet";
import {Subscription} from "rxjs";
import {LoginService} from "../../services/login/login.service";
import {EwalletService} from "../../services/ewallet/ewallet.service";
import {ServicesService} from "../../services/service/services.service";
import {CompanyService} from "../../services/company/company.service";
import {TokenStorage} from "../../token.storage";

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

  public ewallets: Ewallet[] = [];
  public selectedEwallet: Ewallet;

  public message?: string;

  constructor(private modalService: NgbModal,
              private tokenStorage: TokenStorage,
              private loginService: LoginService,
              private ewalletService: EwalletService,
              private companyService: CompanyService,
              private servicesService: ServicesService) {
    this.page = 1;
  }

  ngOnInit() {
    this.loadWallets();
    this.getSize();
  }


  private loadWallets(): void {
    this.subscriptionsRxjs.push(
      this.ewalletService.getByLoginID(this.page, this.pageSize, this.tokenStorage.getCurrentLogin().id)
        .subscribe(wallets => {
        this.ewallets = wallets as Ewallet[];
      })
    )
  }

  getSize() {
    this.ewalletService.getSizeByLoginId(this.tokenStorage.getCurrentLogin().id).subscribe
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

  openMessageModal(content2) {
    this.modalService.open(content2, { size: 'sm' });
  }

  createService() {
    this.selectedService.companyId = this.tokenStorage.getCurrentCompany().id;
    this.selectedService.selectedEwallet = this.selectedEwallet.id;
    this.servicesService.add(this.selectedService).subscribe(() => {
      this.message = 'Service created!'
    },error => {
      this.message = 'Error! Check entered data.';
      console.log(error);
    });
  }

  public closeModal(): void {
    this.modalService.dismissAll();
  }

}
