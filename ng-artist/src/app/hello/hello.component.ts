import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hello', // when I use <app-hello>
  templateUrl: './hello.component.html', // render this
  styleUrls: ['./hello.component.css']
})
export class HelloComponent implements OnInit {

  // define what TYPE
  hello = 'Hello World';
  x: number;

  constructor() { }

  ngOnInit() {
  }

}
