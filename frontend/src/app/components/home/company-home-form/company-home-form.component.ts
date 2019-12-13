import { Component, OnInit } from '@angular/core';
import {Service} from "../../../model/services/service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {ServicesService} from "../../../services/service/services.service";
import {Subscription} from "rxjs";
import {TokenStorage} from "../../../token.storage";

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

  constructor(private modalService: NgbModal,
              private servicesService:ServicesService,
              private tokenStorage: TokenStorage)
  {
    this.page=1;
  }

  ngOnInit() {
    this.getServicesSize();
    this.getServices();
  }

  getServices() {
    this.subscriptionsRxjs.push(
      this.servicesService.getByCompanyId(this.page,this.pageSize,
        this.tokenStorage.getCurrentCompany().id)
      .subscribe((services: Service[])=>{
        this.services = services
      }));
  }

  getServicesSize(){
    this.servicesService.getSizeByCompanyId(this.tokenStorage.getCurrentCompany().id).subscribe
    ((size:number)=>{this.collectionSize = size});
  }

  onPageChanged(pageNum){
    this.page=pageNum
    this.getServices();
  }

  openModal(content, service) {
    this.selectedService = service;
    this.modalService.open(content);
  }


}
