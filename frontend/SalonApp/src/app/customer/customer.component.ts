import { Component, OnInit } from '@angular/core';
import { CustomerServiceService, Customer } from '../service/customer-service.service';
import { Router } from "@angular/router";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customer: Customer = new Customer(0, '', '', '', '', '', '', 1);
  pk: number = 0;
  deactivated: boolean = false;
  loggedin: boolean = false;
  g: string = "";

  constructor(private customerService: CustomerServiceService, public myrouter: Router) { }

  ngOnInit() {

    if(this.loggedin) {
      this.getDetails();
    } else {
      this.pk=0;
    }

  }

  setGender(gg) {
    this.g = gg;
    console.log(this.g);
  }

  handleGetDetails(response) {
    this.customer = new Customer(
      response.pk,
      response.firstName,
      response.lastName,
      response.email,
      response.contact1,
      response.contact2,
      response.gender,
      response.activeDeactive);
    this.g = response.gender;
    this.pk=response.pk;
    console.log("g=" + this.g);
  }

  getDetails() {
    this.customerService.getCustomerDetails(this.pk).subscribe(
      response => this.handleGetDetails(response)
    );
  }

  //update and update handler

  handleUpdate(response) {
    this.customer = new Customer(
      response.pk,
      response.firstName,
      response.lastName,
      response.email,
      response.contact1,
      response.contact2,
      response.gender,
      response.activeDeactive);
  }

  updateCustomer(customer) {
    console.log(customer);
    console.log(this.g);
    customer.gender = this.g;
    this.customerService.updateCustomerDetails(customer).subscribe(
      response => this.handleUpdate(response)
    );
  }

  handleAdded(response) {
    this.myrouter.navigate(['login']);
  }

  //main handler

  handleCustomerData(c) {
    if(c.pk!=0) {
      this.updateCustomer(c);
    } else {
      c.gender=this.g;
      this.customerService.addCustomer(c).subscribe(
        response => this.handleAdded(response)
      );
    }
  }

  //deactivation and handler

  handleDeactivation(response) {
    if (response.message == "deactivated")
      this.deactivated = true;
    //log him out and redirect him to the home page
    //this.location.replaceState('/'); // clears browser history so they can't navigate with back button
    this.myrouter.navigate(['login']);
  }

  deactivate() {
    this.customerService.deactivateCustomer(this.customer).subscribe(
      response => this.handleDeactivation(response)
    );
  }


}
