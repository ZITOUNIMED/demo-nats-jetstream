import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { InboxFilterModel } from "../models/inbox.filter.model";
import { environment } from "src/environments/environment";
import { InboxModel } from "../models/inbox.model";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class InboxService {
    url = environment.api_url + "/inbox";
    constructor(private http: HttpClient){}

    loadData(inboxFilter: InboxFilterModel): Observable<InboxModel[]>{
        return this.http.post<InboxModel[]>(this.url+'/load-data', inboxFilter);
    }
}