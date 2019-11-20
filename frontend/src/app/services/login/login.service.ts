import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Login} from '../../components/login/model/login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private loginUrl: string;

  constructor(private http: HttpClient) {
    this.loginUrl = 'http://localhost:8081/login';
  }

  public input(login: Login) {
    return this.http.post<Login>(this.loginUrl, login).subscribe(() => alert("Executed"));
  }
}
