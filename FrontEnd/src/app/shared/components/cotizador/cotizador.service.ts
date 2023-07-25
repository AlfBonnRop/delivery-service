import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Envioc } from './envioc.interface';


@Injectable({
  providedIn: 'root'
})
export class CotizadorService {

  constructor(private http: HttpClient) { }

  headerAut() {

  }

  crearEnvio(env: Envioc): Observable<Envioc> {
    let headers = { 'Autenticacion': localStorage.getItem('token') };
    return this.http.post<Envioc>('http://localhost:8080/envio', env, { headers });
  }
  
}
