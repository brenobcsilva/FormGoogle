import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AppConstants} from "../app-constants";

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  constructor(private http: HttpClient) { }

  login(usuario){
    return this.http.post(AppConstants.baseLogin, JSON.stringify(usuario)).subscribe(data =>{
      var token = JSON.parse(JSON.stringify(data)).token

      localStorage.setItem("token", token);
    })
  }


}
