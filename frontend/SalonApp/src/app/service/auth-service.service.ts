import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

export class UserMapping {

  constructor(
  private userId:string,
  private password:string,
	private masterPk:number,
	private activeDeactive:number,
	private role:number,
  public status: string
    ) { }
}

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  constructor(private httpClient: HttpClient) { }

  authenticate(username, password) {
    console.log(username);
    console.log(password);
    const headers = new HttpHeaders({ Authorization: 'Basic' + btoa(username + ':' + password) });
    return this.httpClient.get<UserMapping>('http://localhost:8080/authentication/validateLogin', { headers }).pipe(
      map(
        userData => {
          sessionStorage.setItem('username', username);
          let authString = 'Basic' + btoa(username + ':' + password);
          sessionStorage.setItem('basicauth',authString);
          return userData;
        }
      )
    );
  }

  isUserLoggedIn() {
    let user=sessionStorage.getItem('username');
    console.log(!(user === null));
    return !(user===null);
  }

  logOut() {
    sessionStorage.removeItem('username');
  }
}

