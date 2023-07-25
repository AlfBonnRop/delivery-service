import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { Envioa } from './envioa.interface';

@Injectable({
  providedIn: 'root'
})
export class AsignarService {

  constructor(private http: HttpClient) {
  }

  getEnviosAsignables():Observable<any>{
    let headers = {'Autenticacion' : localStorage.getItem('token')};
    return this.http.get<Envioa[]>('http://localhost:8080/envios/pendientes',{ headers });
  }
  
  marcarEnvio(id:string):Observable<any>{
    let headers = {'Autenticacion' : localStorage.getItem('token')};
    return this.http.post('http://localhost:8080/envio/marcar/'.concat(id),{},{headers});
  }
}
