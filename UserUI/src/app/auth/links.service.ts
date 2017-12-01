import { Injectable } from '@angular/core';

@Injectable()
export class LinksService {

  authServiceLink: string;
  userServiceLink: string;





 constructor() {
    this.authServiceLink = 'http://13.126.183.132:8090';
    this.userServiceLink = 'http://13.126.183.132:8090/users/';

  }

}
