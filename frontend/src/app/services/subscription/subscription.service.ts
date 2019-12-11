import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {SubscriptionUser} from "../../model/subscriptionUser/subscriptionUser";

@Injectable({
  providedIn: 'root'
})
export class SubscriptionService {

  private subscriptionUrl: string;

  constructor(private http: HttpClient) {
    this.subscriptionUrl = 'http://localhost:8081/api/subscription';
  }


  public getByUserId(pageSize: number,pageNo: number, id: number): Observable<SubscriptionUser[]> {
    return this.http.get<SubscriptionUser[]>(this.subscriptionUrl+"/find-by-userId?pageNo="+pageSize+"&pageSize="
      + pageNo + "&id="+id);
  }

  public getSize() {
    return this.http.get<number>(this.subscriptionUrl + '/size');
  }

  public add(subscription: SubscriptionUser): Observable<SubscriptionUser> {
    return this.http.post<SubscriptionUser>(this.subscriptionUrl, subscription);
  }
}
