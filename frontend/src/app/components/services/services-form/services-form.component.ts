import { Component, OnInit } from '@angular/core';
import {ServicesService} from "../../../services/services/services.service";
import {Services} from "../model/services";
import {compareNumbers} from "@angular/compiler-cli/src/diagnostics/typescript_version";

@Component({
  selector: 'app-services-form',
  templateUrl: './services-form.component.html',
  styleUrls: ['./services-form.component.css']
})
export class ServicesFormComponent implements OnInit {

  public page:number;
  public pageSize: number = 6;
  public collectionSize: number;

  public services: Services[] = [];


  constructor(private servicesService:ServicesService) {
    this.page=1;
  }

  getServices() {
    this.servicesService.getServices(this.page-1,this.pageSize)
      .subscribe((services: Services[])=>{this.services = services});
  }

  getServicesSize(){
    this.servicesService.getSize().subscribe
    ((size:number)=>{this.collectionSize = size});
  }

  ngOnInit() {
    this.getServices();
    this.getServicesSize();
  }

  onPageChanged(page){
    this.getServices();
  }



}
