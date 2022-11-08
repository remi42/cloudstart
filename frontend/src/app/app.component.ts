import { Component } from '@angular/core';
import { FetcherService } from './fetcher.service';
import { Todo } from './todo';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Requests';

  getIn1: string = "";
  getOut1: string | null = null;

  postIn1: string = "";
  postIn2: string = "";
  postIn3: string = "";
  postIn4: string = "";

  getAllOut1: string | null = null;

  deleteIn1: string = "";

  putIn1: string = "";
  putIn2: string = "";
  putIn3: string = "";
  putIn4: string = "";

  constructor(private fetcher: FetcherService) {}

  getRequest() {
    this.fetcher.get(this.getIn1).subscribe((result:any) => {
      this.getOut1 = result;
    })
    this.getIn1 = "";
  }

  postRequest() {
    let todo: Todo = {
      id: this.postIn1,
      name: this.postIn2,
      content: this.postIn3,
      done: this.postIn4,
    }
    this.fetcher.post(todo).subscribe((result:any) => {})

    this.postIn1 = "";
    this.postIn2 = "";
    this.postIn3 = "";
    this.postIn4 = "";
  }

  getAllRequest() {
    this.fetcher.getAll().subscribe((result:any) => {
      this.getAllOut1 = result;
    })
  }

  deleteRequest() {
    this.fetcher.delete(this.deleteIn1).subscribe((result:any) => {})
    this.deleteIn1 = "";
  }

  putRequest() {
    let todo: Todo = {
      id: this.putIn1,
      name: this.putIn2,
      content: this.putIn3,
      done: this.putIn4,
    }
    this.fetcher.post(todo).subscribe((result:any) => {})

    this.putIn1 = "";
    this.putIn2 = "";
    this.putIn3 = "";
    this.putIn4 = "";
  }
}
