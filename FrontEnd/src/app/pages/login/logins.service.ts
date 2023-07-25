import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Resp } from './resp.interface';

@Injectable({
  providedIn: 'root'
})
export class LoginsService {
  admin:boolean;

  constructor(private http: HttpClient) {

  }

  iniciarSesion(email:string, psw:string):Observable<Resp>{
    return this.http.post<Resp>('http://localhost:8080/login',
                                {"email" : email,
                                 "password" : psw});
  }



}
