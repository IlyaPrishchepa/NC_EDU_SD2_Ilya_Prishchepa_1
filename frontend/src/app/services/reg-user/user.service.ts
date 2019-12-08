import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { RegUser } from '../../model/user/reg-user';
import {Observable} from "rxjs";

@Injectable()
export class UserService {

  private regUsersUrl: string;
  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.regUsersUrl = 'http://localhost:8081/registration-user';
    this.usersUrl = 'http://localhost:8081/user';
  }

  save(regUser: RegUser): Observable<RegUser> {
    return this.http.post<RegUser>(this.regUsersUrl, regUser);
  }

  getUserByLoginId(loginId: number): Observable<RegUser> {
    return this.http.get<RegUser>(this.usersUrl + '/find-by-loginId/' + loginId);
  }
}
