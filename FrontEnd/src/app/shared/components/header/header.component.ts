import { Component } from '@angular/core';

@Component({
  selector: 'headeri',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent{
  enSesion(){
    return localStorage.getItem('token') != null;
  }
  cerrarSesion(){
    localStorage.clear();
  }

}
