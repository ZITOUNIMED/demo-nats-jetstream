import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs";
import { Desk } from "../models/desk.model";

@Injectable({
    providedIn: 'root'
})
export class AppStoreService {
 user$ = new BehaviorSubject<{userId: any, name: any}|undefined>(undefined); 
 desks$ = new BehaviorSubject<Desk[]>([]);
 selectedDesksChanged$ = new BehaviorSubject<boolean>(false);

 setUser(userId: any, name: any){
    this.user$.next({userId, name});
 }
 
 setDesks(desks: Desk[]){
    this.desks$.next(desks);
 }

 getSelectedDeskIds(): string[] {
    let deskIdsStr = sessionStorage.getItem('deskIds');
    let deskIds: string[] = [];
    if(!deskIdsStr){
        sessionStorage.setItem('deskIds', JSON.stringify(deskIds))
    } else {
        deskIds = JSON.parse(deskIdsStr);
    }
    return deskIds;
 }

 selectOrUnselect(deskId: any){
    let deskIds = this.getSelectedDeskIds();
    if(deskIds.indexOf(deskId)>=0){
       deskIds = deskIds.filter(d => d !== deskId); 
    } else {
        deskIds.push(deskId)
    }
    sessionStorage.setItem('deskIds', JSON.stringify(deskIds))
    this.selectedDesksChanged$.next(true);
 }

 resetUser(){
    this.user$.next({userId: '', name: ''});
 }

 resetDesks(){
    this.desks$.next([]);
    sessionStorage.setItem('deskIds', '');
 }

}