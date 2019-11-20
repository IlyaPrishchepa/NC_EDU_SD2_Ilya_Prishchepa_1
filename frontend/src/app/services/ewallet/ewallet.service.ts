import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Ewallet} from '../../components/ewallet/model/ewallet';

@Injectable({
  providedIn: 'root'
})
export class EwalletService {
  private ewalletUrl: string;

  constructor(private http: HttpClient) {
    this.ewalletUrl = 'http://localhost:8081/ewallet';
  }
  public save(ewallet: Ewallet) {
    return this.http.post<Ewallet>(this.ewalletUrl, ewallet).subscribe(() => alert("Created"));
  }
}
