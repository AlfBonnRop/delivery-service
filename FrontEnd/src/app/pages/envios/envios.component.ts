import { Component, OnInit } from '@angular/core';
import { EnviosService } from './services/envios.service';
import { tap } from 'rxjs';
import { Envio } from './interfaces/envio.interface';

@Component({
  selector: 'app-envios',
  templateUrl: './envios.component.html',
  styleUrls: ['./envios.component.css']
})
export class EnviosComponent implements OnInit {
  envios : Envio[];
  
  constructor(private envioSvc : EnviosService){
  }

  ngOnInit(): void {
    this.envioSvc.getEnviosPendientes().pipe(
      tap( (enviosPendientes: Envio[]) => this.envios = enviosPendientes)
    ).subscribe();
  }
  
  

}
