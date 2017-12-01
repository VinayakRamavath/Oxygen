import { Injectable } from '@angular/core';

import {Http,Headers, Response, RequestOptions} from '@angular/http';

import 'rxjs/add/operator/map';



@Injectable()
export class AudioService {

url= "http:/localhost:8080/v1/speech/text";

  constructor( private http:Http) { }


show(val: string) {
  console.log(val);
  let body = {username: "user1", text: val};

  let headers = new Headers({ 'Content-Type': 'application/json' });
  let options = new RequestOptions({ headers: headers });
  

return this.http.post('http://172.23.238.194:8787/nlp-parsing-service/v1/virtualassistance/receive-and-parse',JSON.stringify(body) , options)


}

}
