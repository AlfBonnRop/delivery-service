import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { SinginComponent } from './pages/singin/singin.component';
import { CotizarComponent } from './pages/cotizar/cotizar.component';
import { IndexComponent } from './pages/index/index.component';
import { UsuarioComponent } from './pages/usuario/usuario.component';
import { EnviosComponent } from './pages/envios/envios.component';
import { CotizadorComponent } from './shared/components/cotizador/cotizador.component';
import { HeaderComponent } from './shared/components/header/header.component';
import { WelcomeComponent } from './shared/components/welcome/welcome.component';
import { AsignarComponent } from './shared/components/asignar/asignar.component';

const routes: Routes = [
  {path: 'cotizar', component: CotizarComponent},
  {path: 'login', component: LoginComponent},
  {path: 'singin', component: SinginComponent},
  {path: 'index', component: IndexComponent},
  {path: 'usuario', 
    component: UsuarioComponent,
    children:[
      {path:'', component:WelcomeComponent},
      {path:'asignar', component:AsignarComponent},
      {path:'encamino', component:EnviosComponent},
      {path:'cotizar', component:CotizadorComponent}
    ]},
  {path: 'envios', loadChildren: () => import('./pages/envios/envios.module').then(m => m.EnviosModule)},
  {path: '**', redirectTo : 'index', pathMatch:'full'}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
}
