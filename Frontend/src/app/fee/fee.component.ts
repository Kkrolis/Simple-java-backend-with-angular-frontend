import { Component, OnInit } from '@angular/core';
import { FeeControllerService } from '../api/services';
import { Fee } from '../api/models';

@Component({
  selector: 'app-fee',
  templateUrl: './fee.component.html',
  styleUrls: ['./fee.component.css']
})
export class FeeComponent implements OnInit {

  public fees: Fee[] = [];
  public fee: Fee = {};
  public selectedItem: Fee = this.fee;

  constructor(private feeapi: FeeControllerService) { }

  ngOnInit(): void {
    // pulls fee data from database to fees array 
    this.feeapi.getFees().subscribe(
      value => {
        setTimeout(() => this.fees.push(...value), 500);
      },
      error => console.error(JSON.stringify(error)),
      () => console.log('done')
    );
  }

  // adds fee to database
  addfee(arivalDate: string, departureDate: string, fee: number, firstName: string, lastName: string){
    this.fee.firstName = firstName;
    this.fee.lastName = lastName;
    this.fee.arivalDate = arivalDate;
    this.fee.departureDate = departureDate;
    this.fee.fee = fee;
  
    return new Promise((resolve, reject) => {
      this.feeapi.addFee(this.fee).subscribe((response: any) => {
        resolve(response);
      });
    });
  }

  // updates selected fee
  updateFee(arivalDate: string, departureDate: string, fee: number, firstName: string, lastName: string){
    this.fee.id = this.selectedItem.id;
    this.fee.firstName = firstName;
    this.fee.lastName = lastName;
    this.fee.arivalDate = arivalDate;
    this.fee.departureDate = departureDate;
    this.fee.fee = fee;

    return new Promise((resolve, reject) => {
      this.feeapi.updateFee(this.fee).subscribe((response: any) => {
        resolve(response);
      });
    });
  }

  // deletes selected fee
  deleteFee(feeid: number) {
    return new Promise((resolve, reject) => {
      this.feeapi.delFee(feeid).subscribe((response: any) => {
        resolve(response);
      });
    });
  }

  selectItem(item) {
    if (this.selectedItem == null) {
      this.selectedItem = this.fees[0];
    }
    this.selectedItem = item;
  }

}
