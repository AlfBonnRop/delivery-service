import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl, Form } from '@angular/forms';
import { Subscription } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { CotizadorService } from './cotizador.service';
import { Envioc } from './envioc.interface';
import { Router } from '@angular/router';
import { Map, tileLayer } from 'leaflet';

@Component({
  selector: 'cotizador',
  templateUrl: './cotizador.component.html',
  styleUrls: ['./cotizador.component.css']
})
export class CotizadorComponent {
  paqueteForm: FormGroup;
  recoleccionForm: FormGroup;
  entregaForm: FormGroup;

  sobre: boolean;

  constructor(private fb: FormBuilder, private envioSvc: CotizadorService, private router:Router) {
    this.sobre = false;
    this.paqueteForm = this.fb.group({
      alto: ['', Validators.required],
      ancho: ['', Validators.required],
      profundo: [''],
      peso: ['',]
    });

    this.recoleccionForm = this.fb.group({
      calle_recoleccion: ['', Validators.required],
      num_exterior_recoleccion: ['', Validators.required],
      num_interior_recoleccion: [''],
      codigo_postal_recoleccion: ['', Validators.required],
      delegacion_recoleccion: ['', Validators.required],
      fecha: ['', Validators.required]
    });

    this.entregaForm = this.fb.group({
      calle_entrega: ['', Validators.required],
      num_exterior_entrega: ['', Validators.required],
      num_interior_entrega: [''],
      codigo_postal_entrega: ['', Validators.required],
      delegacion_entrega: ['', Validators.required],
      nombre_entrega: ['', Validators.required],
      telefono_entrega: ['',]
    })
  }


  ngAfterViewInit(): void {
    const map = new Map('map').setView([19.4294, -99.1332], 14);
    tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
	  maxZoom: 19,
	  attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(map);
  }


  negarSobre() {
    this.sobre = !this.sobre;
  }

  postEnvio(): void {
      if(localStorage.getItem("token")==null){
        this.router.navigate(['/login']);
      }
    let env:Envioc = {
      alto: this.paqueteForm.get('alto').value,
      ancho: this.paqueteForm.get('ancho').value,
      profundo: this.paqueteForm.get('profundo').value,
      peso: this.paqueteForm.get('peso').value,
      calle_recoleccion: this.recoleccionForm.get('calle_recoleccion').value,
      num_exterior_recoleccion: this.recoleccionForm.get('num_exterior_recoleccion').value,
      num_interior_recoleccion: this.recoleccionForm.get('num_interior_recoleccion').value,
      codigo_postal_recoleccion: this.recoleccionForm.get('codigo_postal_recoleccion').value,
      delegacion_recoleccion: this.recoleccionForm.get('delegacion_recoleccion').value,
      calle_entrega: this.entregaForm.get('calle_entrega').value,
      num_exterior_entrega: this.entregaForm.get('num_exterior_entrega').value,
      num_interior_entrega: this.entregaForm.get('num_interior_entrega').value,
      codigo_postal_entrega: this.entregaForm.get('codigo_postal_entrega').value,
      delegacion_entrega: this.entregaForm.get('delegacion_entrega').value,
      fecha: this.recoleccionForm.get('fecha').value,
      costo: 10,
      nombre_entrega: this.entregaForm.get('nombre_entrega').value,
      telefono_entrega: this.entregaForm.get('telefono_entrega').value
    }
    this.envioSvc.crearEnvio(env).subscribe((response: any) => { console.log(response) });
  }
}
