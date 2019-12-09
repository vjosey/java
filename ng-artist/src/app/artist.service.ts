import { Injectable } from '@angular/core';
import { Artist } from './models/artist';

@Injectable({
  providedIn: 'root'
})
export class ArtistService {
  artists: Artist[] = [{
    artistId: 1, name: 'The Dan Band'
  },
  {
    artistId: 2, name: 'Metallica'
  },
  {
    artistId: 3, name: '21 Savage'
  }];
  constructor() { }

  add(artist: Artist): void {
    this.artists.push(artist);
  }

  getArtists(): Artist[] {
    return this.artists;
  }
}
