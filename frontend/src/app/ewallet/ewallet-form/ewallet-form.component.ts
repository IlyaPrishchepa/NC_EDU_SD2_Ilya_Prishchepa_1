import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {EwalletService} from '../services/ewallet.service';
import {Ewallet} from '../model/ewallet';

@Component({
  selector: 'app-ewallet-form',
  templateUrl: './ewallet-form.component.html',
  styleUrls: ['./ewallet-form.component.css']
})
export class EwalletFormComponent implements OnInit {

  ewallet: Ewallet = {id: {}} as Ewallet;

  constructor(
  private route: ActivatedRoute,
  private router: Router,
  private ewalletService: EwalletService) { }

  ngOnInit() {
  }

  onSubmit() {
    this.ewalletService.save(this.ewallet);
  }

}
