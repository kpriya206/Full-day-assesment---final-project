import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import { Customer } from './customer';
import { Orders } from './orders';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http : Http) { }

  validateCustomer(user : string, pwd : string) : Observable<string> {
    return this.
    http.get("http://localhost:8080/MLP196/api/customer/check/"+user+"/"+pwd).
    map((res : Response) => res.text());
  }
  findByCustomerName(user : string) : Observable<Customer> {
    return this.
    http.get("http://localhost:8080/MLP196/api/customer/showCustomer/"+user).
    map((res : Response) => res.json());
  }
  orderHistory(custId : number) : Observable<Orders[]> {
    return this.
    http.get("http://localhost:8080/MLP196/api/orders/orderHis/"+custId).
    map((res : Response) => res.json());
  }
  pendingHistory(custId : number) : Observable<Orders[]> {
    return this.
    http.get("http://localhost:8080/MLP196/api/orders/pendingcus/"+custId).
    map((res : Response) => res.json());
  }
  placeOrder(orders : Orders) : Observable<string> {
    return this.http.post("http://localhost:8080/MLP196/api/orders/insertorders/",orders).
    map((res : Response) => res.text());
  }
  cancelOrder(cusId : number, status : String,) : Observable<string> {
    return this.http.get("http://localhost:8080/MLP196/api/orders/ordercancel/"+cusId+ "/" +status,null).
    map((res : Response) => res.text());
  }
}