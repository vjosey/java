import { Component, OnInit } from '@angular/core';
import { Artist } from '../models/artist';
import { ArtistService } from '../artist.service';

@Component({
  selector: 'app-list-artist',
  templateUrl: './list-artist.component.html',
  styleUrls: ['./list-artist.component.css']
})
export class ListArtistComponent implements OnInit {
  listOfArtists: Artist[] = [];
  constructor(private service: ArtistService) { }

  ngOnInit() {
    this.service.list().subscribe(response => {
      this.listOfArtists = response;
    });
  }

}
