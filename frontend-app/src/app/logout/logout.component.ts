import { Component, OnInit } from '@angular/core';
import { AppStoreService } from '../services/app-store.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private appStoreService: AppStoreService,
    private router: Router) { }

  ngOnInit(): void {
    sessionStorage.setItem('userId', '');
    sessionStorage.setItem('name', '');
    this.appStoreService.resetUser();
    this.appStoreService.resetDesks();
    this.router.navigate(['/login'])
  }

}
