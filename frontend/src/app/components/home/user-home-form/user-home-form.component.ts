import { Component, OnInit } from '@angular/core';
import {Service} from "../../../model/services/service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {ServicesService} from "../../../services/service/services.service";

@Component({
  selector: 'app-user-home-form',
  templateUrl: './user-home-form.component.html',
  styleUrls: ['./user-home-form.component.css']
})
export class UserHomeFormComponent implements OnInit {


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
