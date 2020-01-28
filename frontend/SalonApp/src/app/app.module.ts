import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AlertModule } from 'ngx-bootstrap';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { CustomPasswordValidator } from './customer/customer.component'

import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';
import { LoginComponent } from './login/login.component';
import { FooterComponent } from './footer/footer.component';
import { CatalogComponent } from './catalog/catalog.component';
import { ProductComponent } from './product/product.component';
import { CustomerComponent } from './customer/customer.component';
import { SalonComponent } from './salon/salon.component';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './signup/signup.component';
import { LogoutComponent } from './logout/logout.component';
import { ProductdetailComponent } from './productdetail/productdetail.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SalonsComponent } from './salons/salons.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'salons', component: SalonsComponent },
  { path: 'services', component: ProductdetailComponent },
  { path: 'catalog', component: CatalogComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'profile', component: CustomerComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'productdetail', component: ProductdetailComponent },
  { path: '**', component: HomeComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    LoginComponent,
    FooterComponent,
    CatalogComponent,
    ProductComponent,
    CustomerComponent,
    SalonComponent,
    HomeComponent,
    SignupComponent,
    LogoutComponent,
    CustomPasswordValidator,
    DashboardComponent,
    ProductdetailComponent,
    SalonsComponent
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
