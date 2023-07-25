import { Component, Input } from '@angular/core';
import { Envio } from '../interfaces/envio.interface';
@Component({
  selector: 'envio',
  templateUrl: './envio.component.html',
  styleUrls: ['./envio.component.css']
})
export class EnvioComponent {
  @Input() envio!: Envio;

  getFecha(f:string){
    let d = new Date(f);
    return `${d.getDay()}/${d.getMonth()}/${d.getFullYear()}`; 
  }
}
