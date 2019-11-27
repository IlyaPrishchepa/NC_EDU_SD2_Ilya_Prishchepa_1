import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {EwalletService} from '../../../services/ewallet/ewallet.service';
import {Ewallet} from '../model/ewallet';
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-ewallet-form',
  templateUrl: './ewallet-form.component.html',
  styleUrls: ['./ewallet-form.component.css']
})
export class EwalletFormComponent implements OnInit {

  ewallet: Ewallet = {id: {}} as Ewallet;

  constructor(private modalService: NgbModal,
              private ewalletService: EwalletService) { }

  ngOnInit() {
  }

  openModal(content) {
    this.modalService.open(content);
  }

}
