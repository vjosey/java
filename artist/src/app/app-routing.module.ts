import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddArtistComponent } from './add-artist/add-artist.component';
import { ListArtistComponent } from './list-artist/list-artist.component';

const routes: Routes = [{
  path: 'add-artist', component: AddArtistComponent
}, {
  path: 'list-artist', component: ListArtistComponent
}, {
  path: '', redirectTo: '/list-artist',
  pathMatch: 'full'
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
