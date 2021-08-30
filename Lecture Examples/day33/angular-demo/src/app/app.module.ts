import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
// import test component
import { TestComponent } from './test.component';
import { TestComponentGeneratedComponent } from './test-component-generated/test-component-generated.component';

@NgModule({
  declarations: [
    AppComponent,
    TestComponent,
    TestComponentGeneratedComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
