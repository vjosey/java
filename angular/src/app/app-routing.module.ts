import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NewArtistComponent } from './new-artist/new-artist.component';
import { ListArtistsComponent } from './list-artists/list-artists.component';

const routes: Routes = [{
  path: 'newArtist', component: NewArtistComponent
}, {
  path: 'listArtists', component: ListArtistsComponent
}, {
  path: '', redirectTo: '/listArtists',
    pathMatch: 'full'
}];

// RouterModule.forRoot(routes)
// configures the RouterModule
// export the config to Angular
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
