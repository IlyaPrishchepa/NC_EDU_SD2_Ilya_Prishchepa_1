import { Component, OnInit } from '@angular/core';

import {NgbModal} from "@ng-bootstrap/ng-bootstrap";

import {Category} from "../model/category";
import {CategoryService} from "../../../services/category/category.service";

@Component({
  selector: 'app-category-form',
  templateUrl: './category-form.component.html',
  styleUrls: ['./category-form.component.css']
})
export class CategoryFormComponent implements OnInit {

  public page: number;
  public pageSize: number = 6;
  public collectionSize: number;

  public category: Category = {};
  public categories: Category[] = [];


  constructor(private modalService: NgbModal, private categoryService: CategoryService) {
    this.page = 1;
  }

  getCategory() {
    this.categoryService.getCategory(this.page, this.pageSize)
      .subscribe((categories: Category[]) => {
        this.categories = categories
      });
  }

  getSize() {
    this.categoryService.getSize().subscribe
    ((size: number) => {
      this.collectionSize = size
    });
  }

  ngOnInit() {
    this.getCategory();
    this.getSize();
  }

  onPageChanged(pageNum) {
    this.page = pageNum
    this.getCategory();
  }

  delete(id:number){
      this.categoryService.delete(id).subscribe(() => {this.ngOnInit();});
  }

  create(){
    this.categoryService.create(this.category).subscribe(() => {this.ngOnInit()});
  }

  openModal(content) {
    const modalRef = this.modalService.open(content);
  }

}


