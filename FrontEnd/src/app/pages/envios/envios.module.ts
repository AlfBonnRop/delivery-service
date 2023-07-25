import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EnviosRoutingModule } from './envios-routing.module';
import { EnviosComponent } from './envios.component';
import { EnvioComponent } from './envio/envio.component';
import { MaterialModule } from 'src/app/material.module';


@NgModule({
  declarations: [
    EnviosComponent,
    EnvioComponent
  ],
  imports: [
    CommonModule,
    EnviosRoutingModule,
    MaterialModule
  ]
})
export class EnviosModule { 

}
