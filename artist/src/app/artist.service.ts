import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Artist } from './models/artist';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ArtistService {
  url = 'http://localhost:8080/chinook/';
  constructor(private http: HttpClient) {
    // <3 dependency injections
  }

  add(artist: Artist): Observable<any> {
    const api = 'api/artist'; // uri
    return this.http.post(this.url + api, artist);
  }

  list(): Observable<any> {
    const api = 'api/artist';
    return this.http.get(this.url + api);
  }

}

