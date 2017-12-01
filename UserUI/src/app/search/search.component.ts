
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OnDestroy, Input } from '@angular/core';
import { DisplayService } from '../display.service';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  // router:Router
   
 intent:any = "basic";
  ngOnInit() {
  }
 
  @Input() fetchedUrls:any;
  //   @Input() Restaurants:any;
    constructor(private usersApi:DisplayService,private router: Router) { }
  
//  onSelect(value:string,intent:string) {
//         //  this.router.navigate(['/user']);
//         console.log(value);
//         console.log(intent);
//         this.usersApi.getUrls(value,intent).then((res)=>{
          
//             this.fetchedUrls = res;
//             console.log(res);
          
//         })
//       }

      onClick(value:string) {
        console.log(value);
        // console.log(intent);
        this.router.navigate(['/sideres/'+value+'/'+this.intent]);
          
      }

}
