import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Services} from  "../../components/services/model/services"

@Injectable({
  providedIn: 'root'
})
export class ServicesService {
  private servicesUrl: string;

  constructor(private http: HttpClient) {
    this.servicesUrl = 'http://localhost:8081/services';
  }
  public getServices(page:number, size:number) {
    return this.http.get<Services[]>(this.servicesUrl + '?pageNo=' + page + '&pageSize=' + size );
  }
  public getSize() {
    return this.http.get<number>(this.servicesUrl + '/size');
  }

}
