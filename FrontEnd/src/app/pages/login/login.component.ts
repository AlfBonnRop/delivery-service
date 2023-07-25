import { OnInit, ViewEncapsulation } from '@angular/core';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { LoginsService } from './logins.service';
import { TaggedTemplateExpr } from '@angular/compiler';
import { tap } from 'rxjs';
import { Resp } from './resp.interface';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';


@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  encapsulation: ViewEncapsulation.None,
})

export class LoginComponent implements OnInit {
  
  email:string;
  psw:string;
  hide=true;
  form:FormGroup;
  data:Resp;

  constructor(private fb: FormBuilder, private loginSvc:LoginsService, private _snackBar: MatSnackBar,
              private router:Router) {
    this.form = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  sendValues(){
    console.log(this.email);
    console.log(this.psw);

  }

  login():void{
    this.loginSvc.iniciarSesion(this.email,this.psw).pipe(
      tap( (llave: Resp) => 
      {if(llave==null){
        this.openSnackBar();
      }else{
        localStorage.setItem('token', llave.token);
        localStorage.setItem('admin', llave.admin);
        this.router.navigate(['/usuario']);
      }})
    ).subscribe();
    
    
  }

  openSnackBar() {
    this._snackBar.open("El correo o contraseña es incorrecto, intentelo de nuevo","Aceptar",{horizontalPosition:"center", verticalPosition:"top"});
  }

  ngOnInit(): void {

  }
}
