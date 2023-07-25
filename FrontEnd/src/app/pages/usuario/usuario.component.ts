import { tap } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { Respuesta } from './respuesta.interface';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})




export class UsuarioComponent {
  admin:boolean;
  constructor(private router:Router, private http:HttpClient){
  }
  
  
  getSesion(){
    return localStorage.getItem('token') == null; 
  }
  cerrarSesion(){
    localStorage.clear();
    this.router.navigate(['/index']);
  }
  

  wrap():boolean{
    this.esAdministrador();
    return this.admin;
  }
  
  esAdministrador():void{
    let headers = {'Autenticacion' : localStorage.getItem('token')};
    var a= this.http.get<Respuesta>('http://localhost:8080/admin',{headers});
    var b; 
    a.pipe(
      tap((respuesta:Respuesta) => {
        this.admin = respuesta.admin})
    ).subscribe();
  }

  isAdmin():boolean{
    var a = localStorage.getItem('admin');
    if(a==null){
      this.router.navigate(['/login']);
    }
    return !(a == "1");
  }
}
