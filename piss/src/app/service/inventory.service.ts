import { Injectable } from '@angular/core';
import { Product } from './product';
import {
  HttpClient,
  HttpHeaders,
  HttpErrorResponse,
} from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { map } from 'rxjs';
import { catchError } from 'rxjs';
import { throwError } from 'rxjs';
import { LoggingService } from "./logging.service";

@Injectable({
  providedIn: 'root'
})
export class InventoryService {

  url: string = 'https://496be6d8-f897-488a-a630-bcd778f323ee.mock.pstmn.io'
  constructor(private http: HttpClient, private loggingService: LoggingService) { }

  getAllProducts() : Observable<any> {
    let URL = `${this.url}/products`;
    return this.http.get(URL)
    .pipe(
      tap(() => {
        this.loggingService.log("All products retrieved from UI");
      }),
      map((res: any) => {
        return res.products;
    }));
  }

  getSingleProdutct(id: string) : Observable<any> {
    let URL = `${this.url}/products/${id}`
    return this.http.get(URL)
    .pipe(
      tap(() => {
        this.loggingService.log(`Single product with ID ${id} retrieved from UI`);
      }),
      map((res: any) => {
        return res;
    }))
  }

  updateProduct(product: Product) {
    let URL = `${this.url}/products/${product.id}`

    return this.http.patch(URL, JSON.stringify(product))
    .pipe(
      tap(() => {
        this.loggingService.log(`Successfully updated product with ID ${product.id} through UI`);
      }),
      map((res: any) => {
        return res;
    }))
  }

    addProduct(product: Product) {
      let URL = `${this.url}/products`

      return this.http.post(URL, JSON.stringify(product))
      .pipe(
        tap(() => {
          this.loggingService.log(`Successfully added a new product with name ${product.name} through UI`);
        }),
        map((res: any) => {
          return res;
      }))
    }
}
