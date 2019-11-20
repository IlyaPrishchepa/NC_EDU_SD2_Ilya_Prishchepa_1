import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {RegCompany} from '../../components/registration/model/company/reg-company';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8081/registration-company';
  }

  public save(regCompany: RegCompany) {
    return this.http.post<RegCompany>(this.usersUrl, regCompany).subscribe(() => alert("Company was successfully created"));
  }
}
