import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from "@angular/router";
import { Observable, catchError, map } from "rxjs";
import { LoginService } from "./login.service";
import { AppStoreService } from "./app-store.service";

@Injectable({
    providedIn: 'root'
})
export class InboxGuardService implements CanActivate {
    constructor(private loginService: LoginService, 
        private router: Router,
        private appStoreService: AppStoreService){}
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | Observable<boolean> {
        const userId = sessionStorage.getItem('userId');
        if(!userId){
            return false;
        }

        return this.loginService.login(userId)
                .pipe(
                    catchError(() => this.router.navigate(['/login'])),
                    map(() => {
                        const userId = sessionStorage.getItem('userId');
                        const name = sessionStorage.getItem('name');
                        this.appStoreService.setUser(userId, name);
                        return true;
                    })
                );
    }
}