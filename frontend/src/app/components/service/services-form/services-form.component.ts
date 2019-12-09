import { Component, OnInit } from '@angular/core';
import {ServicesService} from "../../../services/service/services.service";
import {Service} from "../../../model/services/service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-services-form',
  templateUrl: './services-form.component.html',
  styleUrls: ['./services-form.component.css']
})
export class ServicesFormComponent implements OnInit {

  public page:number;
  public pageSize: number = 6;
  public collectionSize: number;

  public services: Service[] = [];
  public selectedService: Service;


  constructor(private modalService: NgbModal,private servicesService:ServicesService) {
    this.page=1;
  }

  getServices() {
    this.servicesService.getServices(this.page,this.pageSize)
      .subscribe((services: Service[])=>{this.services = services});
  }

  getServicesSize(){
    this.servicesService.getSize().subscribe
    ((size:number)=>{this.collectionSize = size});
  }

  ngOnInit() {
    this.getServices();
    this.getServicesSize();
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
