import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {RegCompany} from '../../model/company/reg-company';
import {Observable} from "rxjs";
import {RegUser} from "../../model/user/reg-user";

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  private regCompanyUrl: string;
  private companyUrl: string;

  constructor(private http: HttpClient) {
    this.regCompanyUrl = 'http://localhost:8081/api/registration-company';
    this.companyUrl = 'http://localhost:8081/api/company';
  }

  public save(regCompany: RegCompany): Observable<RegCompany> {
    return this.http.post<RegCompany>(this.regCompanyUrl, regCompany)
  }
  getByLoginId(loginId: number): Observable<RegCompany> {
    return this.http.get<RegCompany>(this.companyUrl + '/find-by-loginId/' + loginId);
  }
}
