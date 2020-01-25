import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from '../service/customer-service.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customer:any;

  constructor(private customerService:CustomerServiceService) { }

  ngOnInit() {
    this.customerService.getCustomerDetails().subscribe(
      response=>this.handleSuccessfulResponse(response)
    );
  }

  handleSuccessfulResponse(response) {
    this.customer=response;
  }

}
