import {Injectable} from "@angular/core";
import {Login} from "./model/login/login";
import {RegUser} from "./model/user/reg-user";
import {RegCompany} from "./model/company/reg-company";

@Injectable()
export class TokenStorage {

  private readonly TOKEN_KEY: string = "token";
  private readonly CURRENT_LOGIN: string = "currentLogin";
  private readonly CURRENT_USER: string = "currentUser";
  private readonly CURRENT_COMPANY: string = "currentCompany";

  private currentLogin: Login;
  private currentUser: RegUser;
  private currentCompany: RegCompany;

  public setCurrentLogin(currentLogin: Login): void {
    this.currentLogin = currentLogin;
    localStorage.setItem(this.CURRENT_LOGIN, JSON.stringify(currentLogin));
  }

  public getCurrentLogin(): Login {
    return this.currentLogin || JSON.parse(localStorage.getItem(this.CURRENT_LOGIN));
  }

  public clearLogin(): void {
    localStorage.setItem(this.CURRENT_LOGIN, null);
  }

  public getCurrentUser(): RegUser {
    return this.currentUser || JSON.parse(localStorage.getItem(this.CURRENT_USER));
  }

  public setCurrentUser(currentUser: RegUser): void {
    this.currentUser = currentUser;
    localStorage.setItem(this.CURRENT_USER, JSON.stringify(currentUser));
  }

  public clearCurrentUser(): void {
    localStorage.setItem(this.CURRENT_USER, null);
  }

  public getCurrentCompany(): RegCompany {
    return this.currentCompany || JSON.parse(localStorage.getItem(this.CURRENT_COMPANY));
  }

  public setCurrentCompany(currentCompany: RegCompany): void {
    this.currentCompany = currentCompany;
    localStorage.setItem(this.CURRENT_COMPANY, JSON.stringify(currentCompany));
  }

  public clearCurrentCompany(): void {
    localStorage.setItem(this.CURRENT_COMPANY, null);
  }

  public setToken(token: string): void {
    localStorage.setItem(this.TOKEN_KEY, token);
  }

  public getToken(): string {
    return localStorage.getItem(this.TOKEN_KEY);
  }

  public clearToken(): void {
    localStorage.setItem(this.TOKEN_KEY, null);
  }

  public clearAll(): void {
    localStorage.setItem(this.TOKEN_KEY, null);
    localStorage.setItem(this.CURRENT_LOGIN, null);
    localStorage.setItem(this.CURRENT_USER, null);
    localStorage.setItem(this.CURRENT_COMPANY, null);
  }
}
