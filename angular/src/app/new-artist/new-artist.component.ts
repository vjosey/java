import { Component, OnInit } from '@angular/core';
import { ArtistService } from '../artist.service';
import { Artist } from '../models/artist';

@Component({
  selector: 'app-new-artist',
  templateUrl: './new-artist.component.html',
  styleUrls: ['./new-artist.component.css']
})
export class NewArtistComponent implements OnInit {
  temp: Artist = new Artist();
  addArtist(): void {
    this.artistService.add(this.temp);
    this.temp = new Artist();
  }
  constructor(private artistService: ArtistService) { }
  ngOnInit() {}
}
