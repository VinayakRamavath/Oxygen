import { RegisterComponent } from './register/register.component';
import { UserDetailsService } from './auth/userdetails.service';
import { UserService } from './auth/user.service';
import { AuthenticationService } from './auth/authentication.service';
import { LinksService } from './auth/links.service';
import { MatTabsModule } from '@angular/material/tabs';
import { SidebarDomainComponent } from './sidebardomain/sidebardomain.component';
import { StompService } from 'ng2-stomp-service';
import { SocketService } from './sidebarresults/socket.service';
import { SidebarAdminComponent } from './sidebaradmin/sidebaradmin';
import { AdminpanelComponent } from './adminpanel/adminpanel.component';
import { SideResComponent } from './sidebarresults/sideres.component';
import { FinalComponent } from './final/final.component';
import { MatCardModule } from '@angular/material/card';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ViewEncapsulation } from '@angular/core';

import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatButtonModule, MatCheckboxModule} from '@angular/material';
import {RouterModule} from '@angular/router';
import { MatToolbarModule } from '@angular/material';
import {MatAutocompleteModule} from '@angular/material';
import { MatInputModule, MatIconModule, MatDialogModule, MatFormFieldModule } from '@angular/material';

import { DisplayService } from './display.service';
import { HttpModule } from '@angular/http';

import {MatSidenavModule} from '@angular/material/sidenav';
import { ChatModule } from './chat.module';
import { AudioService } from './audio.service';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import {BusyModule} from 'angular2-busy';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import { HeaderComponent } from './header/header.component';
import { ChatDialogComponent } from './chat-dialog/chat-dialog.component';
import { FakeComponent } from './fake/fake.component';
import { SigninComponent } from './signin/signin.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatExpansionModule} from '@angular/material/expansion';
import { PostgraphadminComponent } from './postgraphadmin/postgraphadmin.component';

@NgModule({
  declarations: [
    AppComponent,
    FinalComponent,
    SideResComponent,
    AdminpanelComponent,
    SidebarAdminComponent,
    RegisterComponent,
    SidebarDomainComponent,
    HeaderComponent,
    FakeComponent,
    SigninComponent,
    PostgraphadminComponent
    
    
  ],
  imports: [
    HttpModule,
    BrowserModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatAutocompleteModule,
    MatInputModule,
    MatSidenavModule,
    MatCardModule,
    MatTabsModule,
    ChatModule,
    FormsModule,
    BrowserAnimationsModule,
    BusyModule,
    MatProgressBarModule,
    
    MatSnackBarModule,
    MatExpansionModule,
    BrowserModule,
    BrowserModule,  
    MatToolbarModule,
    MatButtonModule,
    MatAutocompleteModule,
    MatInputModule,
    MatSidenavModule,
    MatCardModule,
    MatTabsModule,
    MatIconModule,
    FormsModule,
    MatCardModule,
    MatDialogModule,
    MatFormFieldModule,
    BrowserModule,
    FormsModule,
    HttpModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatDialogModule,
    RouterModule.forRoot([

      { path: '', component: FinalComponent },
      { path: 'final', component: FinalComponent },
      { path: 'main/:domain', component: SideResComponent },
      { path: 'admin', component: AdminpanelComponent },
      { path: 'sidebaradmin', component: SidebarAdminComponent },
      { path: 'register', component: RegisterComponent },
      { path: 'sidebardomain', component: SidebarDomainComponent },
      { path: 'register', component: RegisterComponent },
      { path: 'chat', component: ChatDialogComponent },
      { path: 'login', component: SigninComponent },
      { path: 'administrator/neo4j/admin', component: PostgraphadminComponent }
      
    ])
  ],
  providers: [DisplayService,AudioService,SocketService,StompService,
    UserService,AuthenticationService,UserDetailsService,LinksService],
  bootstrap: [AppComponent],
  exports:[RouterModule]
})
export class AppModule { }
