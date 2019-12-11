import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from "rxjs";
import {Login} from "../../model/login/login";

@Injectable({
  providedIn: 'root'
})
export class LoginService  {

  private loginUrl: string;
  private getLoginUrl: string;

  constructor(private http: HttpClient) {
    this.loginUrl = 'http://localhost:8081/token/generate-token';
    this.getLoginUrl = 'http://localhost:8081/api/login/get-current-login';
  }

  public authenticate(email: string, password: string): Observable<any> {
    const userDetails = {email: email, password: password};
    return this.http.post<any>(this.loginUrl, userDetails);
  }

  getLogin(): Observable<Login> {
    return this.http.get<Login>(this.getLoginUrl);
  }


}
