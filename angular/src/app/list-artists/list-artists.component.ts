import { Component, OnInit } from '@angular/core';
import { ArtistService } from '../artist.service';
import { Artist } from '../models/artist';

@Component({
  selector: 'app-list-artists',
  templateUrl: './list-artists.component.html',
  styleUrls: ['./list-artists.component.css']
})
export class ListArtistsComponent implements OnInit {
  artists: Artist[] = [];
  constructor(private artistService: ArtistService) {
    console.log('Constructor - ListArtistsComponent');
   }
  ngOnInit() {
    console.log('ngOnInit - ListArtistsComponent');
    // this.artists = this.artistService.list();
    this.artistService.list().subscribe(
      temp => {
        console.log(temp);
        this.artists = temp;
      }
    );
  }
}
