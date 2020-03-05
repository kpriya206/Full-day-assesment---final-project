import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import { Vendor } from './vendor';
import { Orders } from './orders';
@Injectable({
  providedIn: 'root'
})
export class VendorService {

  constructor(private http : Http) { }

  validateVendor(user : string, pwd : string) : Observable<string> {
    return this.
    http.get("http://localhost:8080/MLP196/api/vendor/loginven/"+user+"/"+pwd).
    map((res : Response) => res.text());
  }
  findByVendorName(user : string) : Observable<Vendor> {
    return this.
    http.get("http://localhost:8080/MLP196/api/vendor/showvendor/"+user).
    map((res : Response) => res.json());
  }
  orderHistory(vendId : number) : Observable<Orders[]> {
    return this.
    http.get("http://localhost:8080/MLP196/api/orders/historyven/"+vendId).
    map((res : Response) => res.json());
}
pendingHistory(vendId : number) : Observable<Orders[]> {
  return this.
  http.get("http://localhost:8080/MLP196/api/orderdetail/pendingven/"+vendId).
  map((res : Response) => res.json());
}
  searchVendor(venName : number) : Observable<Vendor>{
    return this.
    http.get("http://localhost:8080/MLP196/api/vendor/VendorName/"+venName).
    map((res : Response)=> res.json());
}
showVendor() : Observable<Vendor[]>{
  return this.
  http.get("http://localhost:8080/MLP196/api/vendor").
  map((res : Response)=> res.json());
}
acceptOrReject(cusId : number, status : string) : Observable<string> {
  return this.http.get("http://localhost:8080/MLP196/api/orders/updateorders/"+cusId + "/" +status,null).
  map((res : Response) => res.text());
}

}