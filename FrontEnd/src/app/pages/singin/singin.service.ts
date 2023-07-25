import { Injectable } from '@angular/core';
import { Usuario } from './usuario.interface'
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SinginService {

  constructor(private http:HttpClient) { }

  registrarUsuario(usr:Usuario):Observable<Usuario>{
    return this.http.post<Usuario>('http://localhost:8080/usuario', usr);
  }

  
}
