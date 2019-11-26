import { Injectable } from '@angular/core';
import { Artist } from './models/artist';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ArtistService {
  artists: Artist[] = [];
  constructor(private http: HttpClient) { }
  url = 'http://localhost:8080/chinook/api/artist';

  add(artist: Artist): void {
    this.artists.push(artist);
  }

  list(): Observable<any> {
    // http.get returns Observable<Artist>
    return this.http.get(this.url);
    // return this.artists;
  }

}
