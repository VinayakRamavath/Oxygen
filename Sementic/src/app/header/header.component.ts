import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';

import { UserDetailsService } from '../auth/userdetails.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor( private _userservice: UserDetailsService,private router: Router) {}
  
    
  ngOnInit() {
  }

  checkforlogin(){
    if(this._userservice.getToken()) {
      this.router.navigate(['/sidebardomain']);
    }
    else{
      this.router.navigate(['/login'])
    }
  }

}
