import { Component } from '@angular/core';
import {LoginServiceService} from "./service/login-service.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  usuario = { username: "", password: "" };

  constructor(private loginService: LoginServiceService) {}

  public login(){
    this.loginService.login(this.usuario);
  }

}
