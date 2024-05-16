import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { Item } from '../../Item';

@Component({
  selector: 'app-list-item',
  templateUrl: './list-item.component.html',
  styleUrls: ['./list-item.component.css'],
})
export class ListItemComponent implements OnInit {
  @Input()
  item!: Item;
  @Output()
  shadowClass = 'non-pressed';

  constructor() {}

  ngOnInit(): void {}

  onMouseDown(): void {
    this.shadowClass = 'pressed';
  }

  onMouseOut(): void {
    this.shadowClass = 'non-pressed';
  }
}
