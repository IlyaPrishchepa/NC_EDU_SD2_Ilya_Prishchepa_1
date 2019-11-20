import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { RegUser } from '../../components/user/model/reg-user';

@Injectable()
export class UserService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8081/registration-user';
  }
  public save(regUser: RegUser) {
    return this.http.post<RegUser>(this.usersUrl, regUser).subscribe(() => alert("User was successfully created"));
  }

}
