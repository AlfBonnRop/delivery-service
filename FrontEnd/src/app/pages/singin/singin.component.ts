import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { ViewEncapsulation } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import {Usuario} from './usuario.interface';
import { OnInit } from '@angular/core';
import { SinginService } from './singin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'singin',
  templateUrl: './singin.component.html',
  styleUrls: ['./singin.component.css'],
  encapsulation: ViewEncapsulation.None,
})
export class SinginComponent implements OnInit {
  hide:boolean;
  personalForm:FormGroup;
  direccionForm:FormGroup;
  acepto:boolean;
  

  ngOnInit(): void {

  }

  constructor(private fb: FormBuilder, private singinSvc:SinginService, private router:Router){
    this.hide=true;
    this.acepto=false;
    this.personalForm = this.fb.group({
      nombre:['',[Validators.required, Validators.maxLength(30)]],
      apellidos:['',[Validators.required, Validators.maxLength(30)]],
      email:['',[Validators.required, Validators.email]],
      password:['', Validators.required],
    });

    this.direccionForm = this.fb.group({
      calle:['', [Validators.required, Validators.maxLength(30)]],
      num_exterior:['', [Validators.required, Validators.maxLength(11)]],
      num_interior:['',Validators.maxLength(11)],
      codigo_postal:['', [Validators.required,Validators.maxLength(5)]],
      delegacion:['', Validators.required],
    });
  }


  negarAcepto(){
    this.acepto=!this.acepto;
  }

  singIn():void{
    let uss={
      nombre : this.personalForm.get('nombre').value,
      apellidos : this.personalForm.get('apellidos').value,
      email : this.personalForm.get('email').value,
      password : this.personalForm.get('password').value,
      calle : this.direccionForm.get('calle').value,
      num_exterior : this.direccionForm.get('num_exterior').value,
      num_interior : this.direccionForm.get('num_interior').value,
      codigo_postal : this.direccionForm.get('codigo_postal').value,
      delegacion : this.direccionForm.get('delegacion').value,
    }
    this.singinSvc.registrarUsuario(uss).subscribe((response: any) => {
      console.log(response);
    });
  };


}
