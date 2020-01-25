import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AlertModule } from 'ngx-bootstrap';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { FooterComponent } from './footer/footer.component';
import { CatalogComponent } from './catalog/catalog.component';
import { ProductComponent } from './product/product.component';
import { CustomerComponent } from './customer/customer.component';
import { SalonComponent } from './salon/salon.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'caccount', component: CustomerComponent },
  { path: 'saccount', component: SalonComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    LoginComponent,
    RegisterComponent,
    FooterComponent,
    CatalogComponent,
    ProductComponent,
    CustomerComponent,
    SalonComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AlertModule.forRoot(),
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
