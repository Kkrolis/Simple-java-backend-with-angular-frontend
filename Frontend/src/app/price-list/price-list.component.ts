import { Component, OnInit } from '@angular/core';
import { PriceList } from '../api/models';
import { PriceListControllerService } from '../api/services';

@Component({
  selector: 'app-price-list',
  templateUrl: './price-list.component.html',
  styleUrls: ['./price-list.component.css']
})
export class PriceListComponent implements OnInit {

  public priceLists: PriceList[] = [];
  public priceList: PriceList = {};
  public selectedItem: PriceList = this.priceList;

  constructor(private priceListApi: PriceListControllerService) { }

  ngOnInit(): void {
    this.priceListApi.getPriceList().subscribe(
      value => {
        setTimeout(()  => this.priceLists.push(...value), 500);
      },
      error => console.error(JSON.stringify(error)),
      () => console.log('done')
    );
  }

  addPriceList(datePriceIsValidFrom: string, roomPriceHolidays: number, roomPriceWorkDays: number, roomType: string) {
    this.priceList.datePriceIsValidFrom = datePriceIsValidFrom;
    this.priceList.roomPriceHolidays = roomPriceHolidays;
    this.priceList.roomPriceWorkDays = roomPriceWorkDays;
    this.priceList.roomType = roomType;
    
    return new Promise((resolve, reject) => {
      this.priceListApi.addPrice(this.priceList).subscribe((response: any) => {
        resolve(response);
      });
    });
  }

  updatePriceList(datePriceIsValidFrom: string, roomPriceHolidays: number, roomPriceWorkDays: number, roomType: string) {
    this.priceList.id = this.selectedItem.id;
    this.priceList.datePriceIsValidFrom = datePriceIsValidFrom;
    this.priceList.roomPriceHolidays = roomPriceHolidays;
    this.priceList.roomPriceWorkDays = roomPriceWorkDays;
    this.priceList.roomType = roomType;

    return new Promise((resolve, reject) => {
      this.priceListApi.updatePriceList(this.priceList).subscribe((response: any) => {
        resolve(response);
      });
    });
  }

  deletePriceList(priceId: number) {
    return new Promise((resolve, reject) => {
      this.priceListApi.delPrice(priceId).subscribe((response: any) => {
        resolve(response);
      });
    });
  }

  selectItem(item) {
    if (this.selectedItem == null) {
      this.selectedItem = this.priceLists[0];
    }

    this.selectedItem = item;
  }
}
