import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-home-form',
  templateUrl: './user-home-form.component.html',
  styleUrls: ['./user-home-form.component.css']
})
export class UserHomeFormComponent implements OnInit {

  public page: number;


  constructor() {
    this.page = 1;
  }

  ngOnInit() {
  }

}
