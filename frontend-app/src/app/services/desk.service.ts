import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Desk } from '../models/desk.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DeskService {
  url = environment.api_url + "/desks";
  constructor(private http: HttpClient) { }

  public getUserDesks(userId: any): Observable<Desk[]>{
    return this.http.get<Desk[]>(this.url + `/by-user-id/${userId}`);
  }
}
