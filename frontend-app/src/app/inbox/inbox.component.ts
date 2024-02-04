import { Component, OnInit } from '@angular/core';
import { DeskService } from '../services/desk.service';
import { AppStoreService } from '../services/app-store.service';
import { InboxService } from '../services/inbox.service';
import { InboxFilterModel } from '../models/inbox.filter.model';
import { InboxModel } from '../models/inbox.model';
import { FormControl, FormGroup } from '@angular/forms';
import { Desk } from '../models/desk.model';
import { SrService } from '../services/sr.service';

@Component({
  selector: 'app-inbox',
  templateUrl: './inbox.component.html',
  styleUrls: ['./inbox.component.scss']
})
export class InboxComponent implements OnInit {
  inboxData: InboxModel[] = [];
  srForm = new FormGroup({
    summary: new FormControl(''),
    deskId: new FormControl(''),
  });
  desks: Desk[] = [];

  constructor(private deskService: DeskService,
    private appStoreService: AppStoreService,
    private inboxService: InboxService,
    private srService: SrService) { }

  ngOnInit(): void {
    this.deskService.getUserDesks(sessionStorage.getItem('userId'))
    .subscribe(desks => {
      this.desks = desks;
      this.appStoreService.setDesks(desks);
      this.loadInboxData();
    })

    this.appStoreService.selectedDesksChanged$.subscribe(() => this.loadInboxData());
  }

  loadInboxData(){
    const selectedDeskIds = this.appStoreService.getSelectedDeskIds();
    if(selectedDeskIds && selectedDeskIds.length>0){
      const inboxFilter: InboxFilterModel = {
        userId: sessionStorage.getItem('userId'),
        selectedDesksIds: selectedDeskIds,
        entityType: 'SR'
      }
      this.inboxService.loadData(inboxFilter)
      .subscribe(data => {
        this.inboxData = [...data].sort((s1, s2) => s1.lastUpdate>s2.lastUpdate? -1:1);
      })
    } else {
      this.inboxData = [];
    }
  }


  createSr(){
    const value = this.srForm.value;
    if(value){
      const creatorUserId = sessionStorage.getItem('userId');
      const srFormDto = {
        creatorUserId,
        ...value
      }
      this.srService.createSr(srFormDto).subscribe(() => {
        this.loadInboxData();
      })
    }
  }

}
