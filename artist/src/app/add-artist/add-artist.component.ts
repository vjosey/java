import { Component, OnInit } from '@angular/core';
import { ArtistService } from '../artist.service';
import { Artist } from '../models/artist';
import { catchError } from 'rxjs/operators'; // 400, 500
import { Observable, ObservableInput } from 'rxjs';

@Component({
  selector: 'app-add-artist',
  templateUrl: './add-artist.component.html',
  styleUrls: ['./add-artist.component.css']
})
export class AddArtistComponent implements OnInit {
  temp: Artist = new Artist();
  error: string;

  constructor(private service: ArtistService) { }
  ngOnInit() {}

  add(): void {
    this.service.add(this.temp).pipe(
      catchError((err, caught) => {
        console.log(err);
        this.error = err.message; // server error message
        return [];
      })
    ).subscribe(
      response => {
        console.log(response);
        this.temp = new Artist();
      }
    );
  }
}
