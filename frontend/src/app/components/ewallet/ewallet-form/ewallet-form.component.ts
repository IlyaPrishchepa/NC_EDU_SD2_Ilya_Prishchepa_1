import {Component, Input, OnInit} from '@angular/core';
import {EwalletService} from '../../../services/ewallet/ewallet.service';
import {Ewallet} from '../../../model/ewallet/ewallet';
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {Subscription} from "rxjs";
import {Login} from "../../../model/login/login";
import {TokenStorage} from "../../../token.storage";
import {LoginService} from "../../../services/login/login.service";

@Component({
  selector: 'app-ewallet-form',
  templateUrl: './ewallet-form.component.html',
  styleUrls: ['./ewallet-form.component.css']
})
export class EwalletFormComponent implements OnInit {

  public message?: string;

  public page:number;
  public pageSize: number = 6;
  public collectionSize: number;

  public ewallet: Ewallet = new Ewallet();
  public ewallets: Ewallet[] = [];
  public selectedEwallet: Ewallet;

  public amountOne?: number;

  private subscriptions: Subscription[] = [];

  constructor(private modalService: NgbModal,
              private ewalletService: EwalletService,
              private loginService: LoginService,
              private tokenStorage: TokenStorage) {
  }

  ngOnInit() {
    this.page = 1;
    this.getSize();
    this.loadWallets();
  }

  public create(): void {
    this.subscriptions.push(
      this.ewalletService.save(this.ewallet).subscribe(data => {
        this.ewallet = data;
        this.ewallets.push(this.ewallet);
        this.message = 'E-wallet created\n ';
      },
      error => {
        this.message = 'Error! Check entered data.';
        console.log(error);
      })
  );
  }

  private loadWallets(): void {
    this.ewallet.loginId3 = this.tokenStorage.getCurrentLogin().id;
    this.subscriptions.push(
      this.ewalletService.getByLoginID(this.page,this.pageSize,
        this.tokenStorage.getCurrentLogin().id).subscribe(wallets => {
        this.ewallets = wallets as Ewallet[];
      })
    )
  }


  openModal(content) {
    this.modalService.open(content);
  }
  public closeModal(): void {
    this.modalService.dismissAll();
  }



  openModal2(content2,ewallet) {
    this.selectedEwallet = ewallet;
    this.modalService.open(content2);
  }

  openMessageModal(content3) {
    this.modalService.open(content3, { size: 'sm' });
  }

  amount(): void {
    this.subscriptions.push(
      this.ewalletService.replenish(this.selectedEwallet.id, this.amountOne)
        .subscribe((ewallet: Ewallet) => {
          this.ewallet = ewallet;
          this.loadWallets();
          this.message = 'Balance replenished';
        },error => {
          this.message = 'Error! Check entered data.';
          console.log(error);
        })
    )
  }

  getSize(){
    this.ewalletService.getSizeByLoginId(this.tokenStorage.getCurrentLogin().id).subscribe
    ((size:number)=>{this.collectionSize = size});
  }

  onPageChanged(pageNum){
    this.page=pageNum;
    this.loadWallets();
  }

}
