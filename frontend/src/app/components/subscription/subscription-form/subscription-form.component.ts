import { Component, OnInit } from '@angular/core';
import {Service} from "../../../model/services/service";
import {SubscriptionService} from "../../../services/subscription/subscription.service";
import {Login} from "../../../model/login/login";
import {Subscription} from "rxjs";
import {SubscriptionUser} from "../../../model/subscriptionUser/subscriptionUser";
import {LoginService} from "../../../services/login/login.service";
import {UserService} from "../../../services/reg-user/user.service";
import {RegUser} from "../../../model/user/reg-user";
import {EwalletService} from "../../../services/ewallet/ewallet.service";
import {Ewallet} from "../../../model/ewallet/ewallet";
import {TokenStorage} from "../../../token.storage";

@Component({
  selector: 'app-subscription-form',
  templateUrl: './subscription-form.component.html',
  styleUrls: ['./subscription-form.component.css'],
})
export class SubscriptionFormComponent implements OnInit {

  public page:number;
  public pageSize: number = 6;
  public collectionSize: number;

  private subscriptionsRxjs: Subscription[] = [];
  private subscriptionsUser: SubscriptionUser[] = [];


  constructor(private subscriptionService:SubscriptionService,
              private loginService: LoginService,
              private userService: UserService,
              private tokenStorage: TokenStorage) {
    this.page=1;
    this.collectionSize=12
  }

  ngOnInit() {
    this. getSubscriptionSize();
    this.loadSubscription();
  }

  private loadSubscription() : void{
    this.subscriptionsRxjs.push(
      this.subscriptionService.getByUserId(this.page,this.pageSize,
        this.tokenStorage.getCurrentUser().id).subscribe(
          (subscription: SubscriptionUser[])=>{this.subscriptionsUser = subscription}));
  }

  onPageChanged(pageNum){
    this.page=pageNum
    this.loadSubscription();
  }

  getSubscriptionSize(){
    this.subscriptionService.getSizeByUserId(this.tokenStorage.getCurrentUser().id).subscribe
    ((size:number)=>{this.collectionSize = size});
  }


}
