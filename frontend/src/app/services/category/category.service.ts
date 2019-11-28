import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Category} from "../../components/category/model/category";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private categoryUrl: string;

  constructor(private http: HttpClient) {
    this.categoryUrl = 'http://localhost:8081/category';
  }
  public getCategory(page:number, size:number) {
    return this.http.get<Category[]>(this.categoryUrl + '?pageNo=' + page + '&pageSize=' + size );
  }
  public getSize() {
    return this.http.get<number>(this.categoryUrl + '/size');
  }

  delete(id: number): Observable<any> {
    return this.http.delete(`${this.categoryUrl}/${id}`, { responseType: 'text' });
  }

  create(categoty: Category): Observable<Category> {
    return this.http.post(`${this.categoryUrl}`, categoty);
  }
}
