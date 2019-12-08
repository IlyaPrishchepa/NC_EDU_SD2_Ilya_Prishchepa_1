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

@Component({
  selector: 'app-subscription-form',
  templateUrl: './subscription-form.component.html',
  styleUrls: ['./subscription-form.component.css'],
  styles: [`
    .dark-modal .modal-content {
      background-color: #292b2c;
      color: white;
    }
    .dark-modal .close {
      color: white;
    }
    .light-blue-backdrop {
      background-color: #5cb3fd;
    }
  `]
})
export class SubscriptionFormComponent implements OnInit {

  public page:number;
  public pageSize: number = 6;
  public collectionSize: number;

  private currentLogin: Login;
  private currentUser: RegUser;
  private subscriptionsRxjs: Subscription[] = [];
  private subscriptionsUser: SubscriptionUser[] = [];


  constructor(private subscriptionService:SubscriptionService,
              private loginService: LoginService,
              private userService: UserService) {
    this.page=1;
    this.collectionSize=12
  }

  ngOnInit() {
    this.loadLogin();
    this. getSubscriptionSize();
  }

  private loadLogin(): void {
    this.subscriptionsRxjs.push(
      this.loginService.getLogin().subscribe(login => {
        this.currentLogin = login;
        this.loadUser();
      })
    )
  }

  private loadUser(): void {
    this.subscriptionsRxjs.push(
      this.userService.getUserByLoginId(this.currentLogin.id).subscribe(user => {
        this.currentUser = user;
        this.loadSubscription();
      })
    )
  }
  private loadSubscription() : void{
    this.subscriptionsRxjs.push(
      this.subscriptionService.getByUserId(this.page,this.pageSize,this.currentUser.id)
      .subscribe((subscription: SubscriptionUser[])=>{this.subscriptionsUser = subscription}));
  }

  onPageChanged(pageNum){
    this.page=pageNum
    this.loadSubscription();
  }

  getSubscriptionSize(){
    this.subscriptionService.getSize().subscribe
    ((size:number)=>{this.collectionSize = size});
  }


}
