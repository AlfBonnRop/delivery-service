import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Envio } from '../interfaces/envio.interface';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EnviosService {
  constructor(private http: HttpClient){ }

  getEnviosPendientes():Observable<any>{
    const headerDict = {
      'Content-Type': 'application/json',
      'Accept': 'application/json',
      'Access-Control-Allow-Headers': 'Content-Type',
      'Autenticacion': localStorage.getItem('token'),
    }
    const requestOptions = {                                                                                                                                                                                 
      headers: new HttpHeaders(headerDict),
    };
    
    return this.http.get<Envio[]>('http://localhost:8080/envios/pendientesid', requestOptions);
    
  }

}
