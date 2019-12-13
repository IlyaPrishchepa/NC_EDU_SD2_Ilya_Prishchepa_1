import {Component, OnInit} from '@angular/core';
import {TokenStorage} from "../../../token.storage";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header-user-form',
  templateUrl: './header-user-form.component.html',
  styleUrls: ['./header-user-form.component.css']
})
export class HeaderUserFormComponent implements OnInit {

  constructor(private router: Router,
              private tokenStorage: TokenStorage) {
  }

  ngOnInit() {
  }

  login() {
    this.tokenStorage.clearAll();
    this.router.navigateByUrl('login');
  }

}
