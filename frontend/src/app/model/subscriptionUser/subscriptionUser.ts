import {Service} from "../services/service";

export class SubscriptionUser {
  id?:number;
  status?:boolean;
  startDate?:Date;
  ewalletId?:number;
  servicesId?:Service;
  userId?:number;

}
