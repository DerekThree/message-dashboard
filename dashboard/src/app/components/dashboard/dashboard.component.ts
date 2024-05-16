import { Component, OnInit } from '@angular/core';
import { Item } from 'src/app/Item';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit {
  pickedItem: Item = {
    name: {
      title: 'empty',
      first: '',
      last: '',
    },
    phone: '',
    picture: {
      large: '',
      medium: '',
      thumbnail: '',
    },
    message: '',
    location: {
      street: {
        number: 0,
        name: '',
      },
      city: '',
      state: '',
      postcode: 0,
      country: '',
    },
    email: '',
  };

  constructor() {}

  ngOnInit(): void {}

  itemPicked(item: Item) {
    this.pickedItem = item;
  }
}
