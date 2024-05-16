import { Component, Input, OnInit } from '@angular/core';
import { Item } from 'src/app/Item';

@Component({
  selector: 'app-info-card',
  templateUrl: './info-card.component.html',
  styleUrls: ['./info-card.component.css'],
})
export class InfoCardComponent implements OnInit {
  @Input()
  item!: Item;

  constructor() {}

  ngOnInit(): void {}
}
