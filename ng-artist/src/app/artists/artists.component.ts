import { Component, OnInit } from '@angular/core';
import { Artist } from '../models/artist';
import { ArtistService } from '../artist.service';

@Component({
  selector: 'app-artists',
  templateUrl: './artists.component.html',
  styleUrls: ['./artists.component.css']
})
export class ArtistsComponent implements OnInit {
  // see line 5 in HTML for usage
  artists: Artist[];
  // dependency injection: YO ANGULAR, gimme an artistService plz. Angular is in control. loosely coupled
  constructor(private artistService: ArtistService) { }
  ngOnInit() {
    // init ().. // this.artists = new ArtistService().getArtists();
    this.artists = this.artistService.getArtists();
  }

}
