import { Component, OnInit } from '@angular/core';
import {Role} from "../../model/enums/role";
import {TokenStorage} from "../../token.storage";

@Component({
  selector: 'app-add-service-page-form',
  templateUrl: './add-service-page-form.component.html',
  styleUrls: ['./add-service-page-form.component.css']
})
export class AddServicePageFormComponent implements OnInit {


  company:Role.COMPANY;

  constructor(private tokenStorage: TokenStorage) { }

  ngOnInit() {
  }


}
