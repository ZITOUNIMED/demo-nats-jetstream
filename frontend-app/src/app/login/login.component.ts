import { Component, OnInit } from '@angular/core';
import { LoginService } from '../services/login.service';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { AppStoreService } from '../services/app-store.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userIdCtrl = new FormControl();
  constructor(private loginService: LoginService, 
    private router: Router,
    private appStoreService: AppStoreService,) { }

  ngOnInit(): void {
    this.login();
  }

  login(){
    let userId = this.userIdCtrl.value;
    if(!userId){
      userId = sessionStorage.getItem('userId');
    }
    if(userId){
      this.loginService.login(userId)
      .subscribe(res => {
        this.setUserInSessionStorage(res.id, res.name);
        this.router.navigate(['/inbox']);
      })
    }
  }

  private setUserInSessionStorage(userId: any, name: string){
    sessionStorage.setItem('userId', userId);
    sessionStorage.setItem('name', name);
    this.appStoreService.setUser(userId, name);
  }
}
