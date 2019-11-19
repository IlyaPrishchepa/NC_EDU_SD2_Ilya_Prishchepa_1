import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../../service/user/user.service';
import { RegUser } from '../../model/user/reg-user';


@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})

export class UserFormComponent implements  OnInit{

  regUser: RegUser = {loginid: {}} as RegUser;
  // создать отдельный модуль для компонент связанных с пользователем +
  // переименовать loginid +
  // желательно сделать модель пользователя на фронте без вложенности +

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService) {

  }

  onSubmit() {
    this.userService.save(this.regUser);
  }

  ngOnInit(): void {
  }

}
