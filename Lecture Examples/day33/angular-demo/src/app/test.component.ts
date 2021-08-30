import { Component } from "@angular/core";

// 'export' allows class to be used outside of file
// '@Component' makes class a componenet
@Component({
    selector: 'app-test', //goes in <app-test> of html file
    template: '<h1>Test Component</h1>',
    styles: []
})
export class TestComponent {

}