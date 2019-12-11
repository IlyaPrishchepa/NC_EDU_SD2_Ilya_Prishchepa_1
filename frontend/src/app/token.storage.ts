import {Injectable} from "@angular/core";
import {Login} from "./model/login/login";

@Injectable()
export class TokenStorage {

  private readonly TOKEN_KEY: string = "token";
  private readonly CURRENT_LOGIN: string = "currentUser";

  private currentLogin: Login;

  public setToken(token: string): void {
    localStorage.setItem(this.TOKEN_KEY, token);
  }

  public setCurrentUser(currentUser: Login): void {
    this.currentLogin = currentUser;
    localStorage.setItem(this.CURRENT_LOGIN, JSON.stringify(currentUser));
  }

  public getCurrentUser(): Login {
    return this.currentLogin || JSON.parse(localStorage.getItem(this.CURRENT_LOGIN));
  }

  public getToken(): string {
    return localStorage.getItem(this.TOKEN_KEY);
  }

  public clearToken(): void {
    localStorage.setItem(this.TOKEN_KEY, null);
  }
}
