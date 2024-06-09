import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmailService {

  constructor( private http:HttpClient) { }

  uri = 'http://localhost:8080/email'

  getAll(){
    
    return this.http.get(`${this.uri}/getAll`);

  }

}
