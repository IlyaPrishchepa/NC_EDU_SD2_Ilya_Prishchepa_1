import { Component, OnInit } from '@angular/core';
import {EwalletService} from '../../../services/ewallet/ewallet.service';
import {Ewallet} from '../../../model/ewallet/ewallet';
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {Subscription} from "rxjs";
import {Login} from "../../../model/login/login";
import {Service} from "../../../model/services/service";
import {TokenStorage} from "../../../token.storage";
import {LoginService} from "../../../services/login/login.service";

@Component({
  selector: 'app-ewallet-form',
  templateUrl: './ewallet-form.component.html',
  styleUrls: ['./ewallet-form.component.css']
})
export class EwalletFormComponent implements OnInit {

  public page:number;
  public pageSize: number = 6;
  public collectionSize: number;

  public ewallet: Ewallet = new Ewallet();
  public ewallets: Ewallet[] = [];
  public selectedEwallet: Ewallet;

  public amountOne?: number;

  private currentLogin: Login;

  private subscriptions: Subscription[] = [];

  constructor(private modalService: NgbModal,
              private ewalletService: EwalletService,
              private loginService: LoginService,
              private storage: TokenStorage) {
  }

  ngOnInit() {
    this.loadLogin();
    this.page = 1;
    this.getSize();
  }

  public create(): void {
    this.subscriptions.push(
      this.ewalletService.save(this.ewallet).subscribe(data => {
        this.ewallet = data;
        alert('Ok');
        this.ewallets.push(this.ewallet)
      },
      error => {
        alert('Error xxx');
        console.log(error);
      })
  );
  }

  private loadLogin(): void {
    this.subscriptions.push(
      this.loginService.getLogin().subscribe(login => {
        this.currentLogin = login;
        this.loadWallets();
        this.ewallet.loginId3 = this.currentLogin.id;
      })
    )
  }

  private loadWallets(): void {
    this.subscriptions.push(
      this.ewalletService.getByLoginID(this.page,this.pageSize,this.currentLogin.id).subscribe(wallets => {
        this.ewallets = wallets as Ewallet[];
      })
    )
  }


  openModal(content) {
    this.modalService.open(content);
  }

  openModal2(content2,ewallet) {
    this.selectedEwallet = ewallet;
    this.modalService.open(content2);
  }

  amount(): void {
    this.subscriptions.push(
      this.ewalletService.replenish(this.selectedEwallet.id, this.amountOne)
        .subscribe((ewallet: Ewallet) => {
          this.ewallet = ewallet;
          this.loadWallets();
        })
    )
  }

  getSize(){
    this.ewalletService.getSize().subscribe
    ((size:number)=>{this.collectionSize = size});
  }

  onPageChanged(pageNum){
    this.page=pageNum;
    this.loadWallets();
  }

}
