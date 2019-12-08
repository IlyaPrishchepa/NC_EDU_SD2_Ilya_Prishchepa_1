import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Ewallet} from '../../model/ewallet/ewallet';
import {Observable} from "rxjs";
import {Service} from "../../model/services/service";

@Injectable({
  providedIn: 'root'
})
export class EwalletService {
  private ewalletUrl: string;

  constructor(private http: HttpClient) {
    this.ewalletUrl = 'http://localhost:8081/ewallet';
  }
  public save(ewallet: Ewallet): Observable<Ewallet> {
    return this.http.post<any>(this.ewalletUrl, ewallet);
  }

  public getByLoginID(id: number): Observable<Ewallet[]> {
    return this.http.get<Ewallet[]>(this.ewalletUrl + '/find-by-loginId/' + id);
  }

  public replenish(ewalletId: number, amount:number){
    return this.http.get<Ewallet>(this.ewalletUrl + '?ewalletId=' + ewalletId + '&amount=' + amount );

  }
}
