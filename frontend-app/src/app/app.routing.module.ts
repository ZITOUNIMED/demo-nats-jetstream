import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { LoginComponent } from "./login/login.component";
import { InboxComponent } from "./inbox/inbox.component";
import { InboxGuardService } from "./services/inbox-guard-service";
import { LogoutComponent } from "./logout/logout.component";

const routes: Routes = [
    {path: 'inbox', component: InboxComponent, canActivate: [InboxGuardService]},
    {path: 'login', component: LoginComponent},
    {path: 'login', component: LoginComponent},
    {path: 'logout', component: LogoutComponent},
    {path: '', redirectTo: '/inbox', pathMatch: 'full'}
];

@NgModule({
    imports: [
        RouterModule.forRoot(routes, {
            enableTracing: false,
            useHash: true
        })
    ],
    exports: [
        RouterModule
    ]
})
export class AppRoutingModule {

}