import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor( private http:HttpClient) { }

  uri = 'http://localhost:8080/user'

  login(email,password){
    const data = {
      email:email,
      password:password
    }
    return this.http.post(`${this.uri}/login`, data);

  }

}
