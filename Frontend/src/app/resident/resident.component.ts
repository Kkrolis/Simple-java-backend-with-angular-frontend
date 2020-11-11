import { Component, OnInit } from '@angular/core';
import { Resident } from '../api/models';
import { ResidentControllerService } from '../api/services';

@Component({
  selector: 'app-resident',
  templateUrl: './resident.component.html',
  styleUrls: ['./resident.component.css']
})
export class ResidentComponent implements OnInit {

  residents: Resident[] = [];
  public resident: Resident = {};
  public selectedItem: Resident = this.resident;

  constructor(private residentapi: ResidentControllerService) { }

  ngOnInit(): void {
    // pulls resident data from database to residents array 
    this.residentapi.getResidents().subscribe(
      value => {
        setTimeout(() => this.residents.push(...value), 500);
      },
      error => console.error(JSON.stringify(error)),
      () => console.log('done')
      );
  }

  addResident(firstName: string, lastName: string, roomtype: string, arivalDate: string, stayduration: number) {
    this.resident.firstName = firstName;
    this.resident.lastName = lastName;
    this.resident.roomType = roomtype;
    this.resident.arivalDate = arivalDate;
    this.resident.stayDurration = stayduration;

    return new Promise((resolve, reject) => {
      this.residentapi.addResident(this.resident).subscribe((response: any) => {
        resolve(response);
      });
    });
  }

  updateResident(firstName: string, lastName: string, roomtype: string, arivalDate: string, stayduration: number) {
    this.resident.id = this.selectedItem.id;
    this.resident.firstName = firstName;
    this.resident.lastName = lastName;
    this.resident.roomType = roomtype;
    this.resident.arivalDate = arivalDate;
    this.resident.stayDurration = stayduration;

    return new Promise((resolve, reject) => {
      this.residentapi.updateResident(this.resident).subscribe((response: any) => {
        resolve(response);
      });
    });
  }

  deleteResident(residentId: number) {
    return new Promise((resolve, reject) => {
      this.residentapi.delResident(residentId).subscribe((response: any) => {
        resolve(response);
      });
    });
  }

  selectItem(item) {
    if (this.selectedItem == null) {
      this.selectedItem = this.residents[0];
    }
    this.selectedItem = item;
  }

}
