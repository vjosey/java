import { Component, OnInit } from '@angular/core';
import { Artist } from '../models/artist';
import { ArtistService } from '../artist.service';

@Component({
  selector: 'app-new-artist',
  templateUrl: './new-artist.component.html',
  styleUrls: ['./new-artist.component.css']
})
export class NewArtistComponent implements OnInit {
  artistObj: Artist = new Artist(); // holds the form input, initialize to empty
  // function(param: data-type): return-type { }
  add(): void {
    this.artistService.add(this.artistObj);
    this.artistObj = new Artist();
  }
  constructor(private artistService: ArtistService) { }
  ngOnInit() {}
}
