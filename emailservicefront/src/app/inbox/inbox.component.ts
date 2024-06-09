import { Component } from '@angular/core';
import { EmailService } from '../email.service';
import { Router } from '@angular/router';
import { Email } from '../models/emails';
import { User } from '../models/users';

@Component({
  selector: 'app-inbox',
  templateUrl: './inbox.component.html',
  styleUrls: ['./inbox.component.css']
})
export class InboxComponent {


  constructor(private emailService:EmailService, private router:Router){}

  ngOnInit(){
    this.user = JSON.parse(localStorage.getItem("user"));
    
    this.emailService.getByReciver(this.user.email).subscribe(
      (email:Email[])=>{
        this.emails = email;
      }
      
    );
  }
  user:User;
  emails:Email[];
  obrisi(email){
    this.emailService.deleteEmail(email.id).subscribe(
      (response:Boolean)=>{
        if(response){
          alert("true");
          this.router.navigate(['inbox']);
        }
      }
    )
  }
}
