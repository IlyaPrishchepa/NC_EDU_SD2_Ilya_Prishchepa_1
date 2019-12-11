import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Service} from "../../model/services/service"
import {Observable} from "rxjs";
import {SubscriptionUser} from "../../model/subscriptionUser/subscriptionUser";

@Injectable({
  providedIn: 'root'
})
export class ServicesService {

  private servicesUrl: string;

  constructor(private http: HttpClient) {
    this.servicesUrl = 'http://localhost:8081/api/services';
  }
  public getServices(page:number, size:number) {
    return this.http.get<Service[]>(this.servicesUrl + '?pageNo=' + page + '&pageSize=' + size );
  }
  public getSize() {
    return this.http.get<number>(this.servicesUrl + '/size');
  }

  public getByCompanyId(pageNo: number,pageSize: number, id: number): Observable<Service[]> {
    return this.http.get<Service[]>(this.servicesUrl+"/find-by-companyId?pageNo="+pageNo+"&pageSize="
      + pageSize + "&id="+id);
  }

  public add(service: Service){
    return this.http.post<Service>(this.servicesUrl,service);
  }
}
