import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { HelloComponent } from './hello/hello.component';
import { ArtistsComponent } from './artists/artists.component';
import { FormsModule } from '@angular/forms';
import { NewArtistComponent } from './new-artist/new-artist.component';

@NgModule({
  declarations: [
    HelloComponent,
    ArtistsComponent,
    NewArtistComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [HelloComponent] // root cmpt (app cmpt)
})
export class AppModule { }
