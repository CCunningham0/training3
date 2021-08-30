import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-test-component-generated',
  templateUrl: './test-component-generated.component.html',
  styleUrls: ['./test-component-generated.component.css']
})
export class TestComponentGeneratedComponent implements OnInit {
  public display = false;
  
  constructor() { }

  ngOnInit(): void {
  }
}
