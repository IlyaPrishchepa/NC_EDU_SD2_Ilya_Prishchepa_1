import {HttpEvent,
  HttpHandler,
  HttpHeaders,
  HttpInterceptor,
  HttpRequest} from "@angular/common/http";import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

const TOKEN_HEADER_KEY = 'Authorization';

@Injectable()
export class Interceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    const token: string = localStorage.getItem("token");
    const authReq = req.clone({
      headers: new HttpHeaders(token && token !== "null" ? {
        "Authorization": "Bearer " + token
      } : null)
    });
    console.log("Intercepted HTTP call", authReq);
    return next.handle(authReq);
  }
}
