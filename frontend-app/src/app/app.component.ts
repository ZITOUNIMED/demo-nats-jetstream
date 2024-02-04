import { Component, OnInit } from '@angular/core';
import { AppStoreService } from './services/app-store.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  user$?: Observable<{userId: any, name: any}|undefined>;
  desks: any[] = [];
  nc: any;
  constructor(private appStoreService: AppStoreService){}

  ngOnInit(): void {
    this.user$ = this.appStoreService.user$.asObservable();
    this.appStoreService.desks$.subscribe(desks => {
      this.desks = desks;
      this.colorDesks();
    });
    this.connectNats();
  }

  selectOrUnselect(deskId: any){
    this.appStoreService.selectOrUnselect(deskId);
    this.colorDesks();
  }

  colorDesks(){
    const selectedDeskIds = this.appStoreService.getSelectedDeskIds();
    for(let i = 0; i<this.desks.length; i++){
      const isExisting = selectedDeskIds.indexOf(this.desks[i].id)>=0;
      if(isExisting){
        this.desks[i].isExisting = true;
      } else {
        this.desks[i].isExisting = false;
      }
    }
  }

  private connectNats(){
  }

}
