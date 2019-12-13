import { Component, OnInit,Input } from '@angular/core';

import {Service} from "../../../model/services/service";
import {Ewallet} from "../../../model/ewallet/ewallet";
import {Subscription} from "rxjs";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {EwalletService} from "../../../services/ewallet/ewallet.service";
import {LoginService} from "../../../services/login/login.service";
import {TokenStorage} from "../../../token.storage";
import {UserService} from "../../../services/reg-user/user.service";
import {SubscriptionUser} from "../../../model/subscriptionUser/subscriptionUser";
import {SubscriptionService} from "../../../services/subscription/subscription.service";

@Component({
  selector: 'app-subscribe-form',
  templateUrl: './subscribe-form.component.html',
  styleUrls: ['./subscribe-form.component.css']
})
export class SubscribeFormComponent implements OnInit {

  @Input()serviceGet:Service;

  public page:number;
  public pageSize: number = 3;
  public collectionSize: number;

  public ewallets: Ewallet[] = [];

  private subscriptionsRxjs: Subscription[] = [];

  private subscriptionUser: SubscriptionUser= new SubscriptionUser();

  constructor(private modalService: NgbModal,
              private ewalletService: EwalletService,
              private loginService: LoginService,
              private userService:UserService,
              private subscriptionService:SubscriptionService,
              private tokenStorage: TokenStorage) {
  }

  ngOnInit() {
    this.page = 1;
    this.getSize();
    this.loadWallets();
    this.subscriptionUser.status=true;
  }


  private loadWallets(): void {
    this.subscriptionsRxjs.push(
      this.ewalletService.getByLoginID(this.page,this.pageSize,
        this.tokenStorage.getCurrentLogin().id).subscribe(wallets => {
        this.ewallets = wallets as Ewallet[];
      })
    )
  }

  private initializeSub(id:number): void {
    this.subscriptionUser.ewalletId = id;
    this.subscriptionUser.status = true;
    this.subscriptionUser.servicesId = this.serviceGet;
    this.subscriptionUser.userId = this.tokenStorage.getCurrentUser().id;
  }

  subscribe(id:number){
    this.initializeSub(id);
      this.subscriptionService.add(this.subscriptionUser)
        .subscribe(() => {})
    this.closeModal();
  }

  getSize(){
    this.ewalletService.getSizeByLoginId(this.tokenStorage.getCurrentLogin().id).subscribe
    ((size:number)=>{this.collectionSize = size});
  }

  onPageChanged(pageNum){
    this.page=pageNum;
    this.loadWallets();
  }

  closeModal(): void {
    this.modalService.dismissAll();
  }
}
