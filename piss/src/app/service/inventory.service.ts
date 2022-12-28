import { Injectable } from '@angular/core';
import { Product } from './product';
import {
  HttpClient,
  HttpHeaders,
  HttpErrorResponse,
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs';
import { catchError } from 'rxjs';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InventoryService {

  url: string = 'https://496be6d8-f897-488a-a630-bcd778f323ee.mock.pstmn.io'
  constructor(private http: HttpClient) { }

  getAllProducts() : Observable<any> {
    let URL = `${this.url}/products`;
    return this.http.get(URL)
    .pipe(
      map((res: any) => {
        return res.products;
    }));
  }

  getSingleProdutct(id: string) : Observable<any> {
    let URL = `${this.url}/products/${id}`
    return this.http.get(URL)
    .pipe(
      map((res: any) => {
        return res;
    }))
  }

  updateProduct(product: Product) {
    let URL = `${this.url}/products/${product.id}`

    return this.http.patch(URL, JSON.stringify(product))
    .pipe(
      map((res: any) => {
        return res;
    }))
  }

    addProduct(product: Product) {
      let URL = `${this.url}/products`

      return this.http.post(URL, JSON.stringify(product))
      .pipe(
        map((res: any) => {
          return res;
      }))
    }
}
