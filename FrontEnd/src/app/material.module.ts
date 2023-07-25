import {MatCheckboxModule} from '@angular/material/checkbox';
import { NgModule } from "@angular/core";
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { FormsModule } from "@angular/forms";
import {MatSelectModule} from '@angular/material/select';
import {MatStepperModule} from '@angular/material/stepper';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatListModule} from '@angular/material/list';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';
import { MatSnackBarModule} from '@angular/material/snack-bar';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatTableModule} from '@angular/material/table';
import {MatDividerModule} from '@angular/material/divider';
import { MatPaginatorModule } from '@angular/material/paginator';

@NgModule({
    exports:[ //Aqui debemos colocar todos los componentes de material que vayamos a utilizar.
        MatButtonModule,
        MatDividerModule,
        MatSnackBarModule,
        MatPaginatorModule,
        MatIconModule,
        MatSidenavModule,
        MatToolbarModule,
        MatCardModule,
        MatFormFieldModule,
        MatInputModule,
        MatStepperModule,
        MatSelectModule,
        MatTableModule,
        MatCheckboxModule,
        MatGridListModule,
        MatListModule,
        MatDatepickerModule,
        MatNativeDateModule
    ]
})

export class MaterialModule{}