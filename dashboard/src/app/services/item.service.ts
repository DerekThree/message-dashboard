import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
// import { PEOPLE } from '../people';
import { Item } from '../Item';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ItemApiResponse } from '../people-api-response';

@Injectable({
  providedIn: 'root',
})
export class ItemService {
  items: Item[] = [];

  private peopleApiUrl = (howMany: number) =>
    `http://localhost:8080/${howMany}`;

  constructor(private httpClient: HttpClient) {}

  getItems(howMany: number): Observable<Item[]> {
    return this.httpClient.get<Item[]>(this.peopleApiUrl(howMany));
  }
}
