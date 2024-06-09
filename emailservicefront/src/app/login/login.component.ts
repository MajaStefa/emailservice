import { Component } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { User } from '../models/users';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  constructor(private userService:UserService, private router:Router){}
  ngOnInit(){
    
   
  }
  message:String;
  email:String;
  password:String;
  login(){
    if(this.email==''){
      this.message="Email not entered "
    }
    if(this.password==''){
      this.message = this.message+"Password not entered"
    }
    if(this.email!='' || this.password!=''){
      this.userService.login(this.email,this.password).subscribe(
        (user:User)=>{
          if(!user){
            this.message="Email not found."
          }else{
            localStorage.setItem("user",JSON.stringify(user));
            this.router.navigate(['inbox']);
          }
        }
      )
    }
    
  }
}
