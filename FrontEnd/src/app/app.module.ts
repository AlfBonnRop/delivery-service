import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HeaderComponent } from './shared/components/header/header.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material.module';
import { HttpClientModule } from '@angular/common/http';
import { MatFormFieldModule } from '@angular/material/form-field';
import { LoginComponent } from './pages/login/login.component';
import { SinginComponent } from './pages/singin/singin.component';
import { CotizadorComponent } from './shared/components/cotizador/cotizador.component';
import { CotizarComponent } from './pages/cotizar/cotizar.component';
import {MatIconModule} from '@angular/material/icon';
import { IndexComponent } from './pages/index/index.component';
import { UsuarioComponent } from './pages/usuario/usuario.component';
import { WelcomeComponent } from './shared/components/welcome/welcome.component';
import { AsignarComponent } from './shared/components/asignar/asignar.component';



@NgModule({
  declarations: [ //COMPONENTES Y DIRECTIVAS
    AppComponent, 
    HeaderComponent, 
    LoginComponent,
    AsignarComponent,
    UsuarioComponent,
    SinginComponent, 
    CotizadorComponent, 
    CotizarComponent,
    IndexComponent,
    WelcomeComponent
  ],
  imports: [    //Cosas extras que necesita nuestra aplicacion
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatIconModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
