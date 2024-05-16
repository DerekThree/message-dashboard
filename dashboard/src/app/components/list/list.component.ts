import {
  Component,
  EventEmitter,
  HostListener,
  Input,
  OnInit,
  Output,
} from '@angular/core';
import { Item } from '../../Item';
import { ItemService } from '../../services/item.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
})
export class ListComponent implements OnInit {
  @Input()
  title!: string;
  @Output() itemPicked = new EventEmitter<Item>();
  length!: number;
  minBufferSize!: number;
  maxBufferSize!: number;

  items: Item[] = [];

  constructor(private itemService: ItemService) {}

  ngOnInit(): void {
    this.onResize();
    this.addItems(this.maxBufferSize);
  }

  @HostListener('window:resize', ['$event'])
  onResize() {
    const topMargin = 160;
    const itemHeight = 115;
    const minItems = 2;
    this.length = Math.floor((window.innerHeight - topMargin) / itemHeight);
    if (this.length < minItems) this.length = minItems;
    this.minBufferSize = this.length * 2;
    this.maxBufferSize = this.length * 3;
  }

  onClick(item: Item): void {
    this.itemPicked.emit(item);
    this.items = this.items.filter((elem) => elem !== item);
    if (this.items.length < this.minBufferSize)
      this.addItems(this.maxBufferSize - this.items.length);
  }

  addItems(howMany: number) {
    this.itemService.getItems(howMany).subscribe((items) => {
      console.log(items);
      this.items = this.items.concat(items);
    });
  }

  getItems(): Item[] {
    return this.items.length < this.length
      ? this.items
      : this.items.slice(0, this.length);
  }
}
