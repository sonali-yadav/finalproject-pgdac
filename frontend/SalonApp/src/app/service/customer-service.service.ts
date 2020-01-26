import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


//for the customer object
export class Customer {
  constructor(
    public pk: number,
    public firstName: string,
    public lastName: string,
    public email: string,
    public contact1: string,
    public contact2: string = "",
    public gender:string,
    public activeDeactive:number
  ) { }
}
@Injectable({
  providedIn: 'root'
})

export class CustomerServiceService {

  constructor(private httpClient: HttpClient) { }

  public getCustomerDetails(pk) {
    console.log("test rest api call");
    return this.httpClient.get<Customer>('http://localhost:8080/salon/customer/profile/'+pk);
  }

  public deactivateCustomer(customer) {
    return this.httpClient.get<string>('http://localhost:8080/salon/customer/deactivate/' + customer.pk);
  }

  public addCustomer(cust) {
    return this.httpClient.post<number>('http://localhost:8080/salon/customer/add',cust);
  }

  public updateCustomerDetails(cust) {
    return this.httpClient.put<Customer>('http://localhost:8080/salon/customer/update',cust);
  }
}
