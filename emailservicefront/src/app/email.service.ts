import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Email } from './models/emails';

@Injectable({
  providedIn: 'root'
})
export class EmailService {

  constructor( private http:HttpClient) { }

  uri = 'http://localhost:8080/email'

  getAll(){
    
    return this.http.get(`${this.uri}/getAll`);

  }
  getBySender(sender){
    
    return this.http.post(`${this.uri}/getBySender`,sender);
  }
  getByReciver(reciver){
    
    return this.http.post(`${this.uri}/getByReciver`,reciver);
  }
  sendEmail(sender,reciver,message,timestamp){

    const data = new Email();
    data.sender=sender;
    data.message=message;
    data.reciver=reciver;
    data.timestamp=timestamp;
    return this.http.post(`${this.uri}/sendEmail`,data);
  }
  deleteEmail(id){

    
    
    return this.http.post(`${this.uri}/deleteEmail`,id);

  }

}
