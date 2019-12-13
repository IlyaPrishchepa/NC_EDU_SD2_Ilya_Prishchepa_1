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
    this.ewalletUrl = 'http://localhost:8081/api/ewallet';
  }
  public save(ewallet: Ewallet): Observable<Ewallet> {
    return this.http.post<any>(this.ewalletUrl, ewallet);
  }

  public getByLoginID(page: number, size: number,id: number): Observable<Ewallet[]> {
    return this.http.get<Ewallet[]>(this.ewalletUrl + '/find-by-loginId?pageNo=' + page + '&pageSize=' + size +'&id='+id);
  }

  public replenish(ewalletId: number, amount:number){
    return this.http.get<Ewallet>(this.ewalletUrl + '?ewalletId=' + ewalletId + '&amount=' + amount );
  }

  public getSize() {
    return this.http.get<number>(this.ewalletUrl + '/size');
  }
  public getSizeByLoginId(id:number) {
    return this.http.get<number>(this.ewalletUrl + '/size-by-loginId/'+id);
  }
}
