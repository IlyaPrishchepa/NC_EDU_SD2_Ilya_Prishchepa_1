import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { RegUser } from '../../components/user/model/reg-user';
import {Observable} from "rxjs";

@Injectable()
export class UserService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8081/registration-user';
  }
  save(regUser: RegUser): Observable<RegUser> {
    return this.http.post<RegUser>(this.usersUrl, regUser);
  }

/*  public get(regUser: RegUser) {
    return this.http.get<RegUser>(this.usersUrl + '?pageNo=' + page + '&pageSize=' + size );
  }*/
}
