import { Component } from '@angular/core';
import { EmailService } from '../email.service';
import { Router } from '@angular/router';
import { Email } from '../models/emails';

@Component({
  selector: 'app-inbox',
  templateUrl: './inbox.component.html',
  styleUrls: ['./inbox.component.css']
})
export class InboxComponent {


  constructor(private emailService:EmailService, private router:Router){}

  ngOnInit(){
    this.emailService.getAll().subscribe(
      (email:Email[])=>{
        this.emails = email;
      }
      
    );
  }
  emails:Email[];
}
