import { Component, OnInit } from '@angular/core';
import {TokenStorage} from "../../../token.storage";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header-company-form',
  templateUrl: './header-company-form.component.html',
  styleUrls: ['./header-company-form.component.css']
})
export class HeaderCompanyFormComponent implements OnInit {

  constructor(private router: Router,
              private tokenStorage: TokenStorage) { }

  ngOnInit() {
  }

  login(){
    this.tokenStorage.clearAll();
    this.router.navigateByUrl('login');
  }

}
