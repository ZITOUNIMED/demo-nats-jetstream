import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";

@Injectable({
    providedIn: 'root'
})
export class SrService {
    url = environment.api_url + "/sr";
    constructor(private http: HttpClient){}
    createSr(srFormDto: any){
        return this.http.post(this.url+'/create', srFormDto);
    }
}