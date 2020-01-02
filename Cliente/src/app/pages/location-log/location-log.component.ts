import { Component, OnInit } from "@angular/core";
import { DeviceService } from "src/app/services/device.service";
import { ClrLoadingState } from "@clr/angular";
import { LocationLogService } from "src/app/services/location-log.service";

@Component({
  selector: "app-location-log",
  templateUrl: "./location-log.component.html",
  styleUrls: ["./location-log.component.css"]
})
export class LocationLogComponent implements OnInit {
  devices: any[] = [];
  locationLog: any[] = [];
  deviceId: any;
  initialDate: any;
  initialTime: any;
  finalDate: any;
  finalTime: any;

  submitBtnState: ClrLoadingState = ClrLoadingState.DEFAULT;

  constructor(
    private deviceService: DeviceService,
    private locationLogService: LocationLogService
  ) {}

  ngOnInit() {
    this.getAllDevices();
  }

  async getAllDevices() {
    this.devices = await this.deviceService.getAll();
  }

  async submitSearch() {
    this.submitBtnState = ClrLoadingState.LOADING;
    let [day, month, year] = this.initialDate.split("/");
    let formatedInitialDate = `${year}-${month}-${day}T${this.initialTime}`;
    [day, month, year] = this.finalDate.split("/");
    let formatedFinalDate = `${year}-${month}-${day}T${this.finalTime}`;
    console.log(this.deviceId, formatedInitialDate, formatedFinalDate);

    try {
      let response = await this.locationLogService.getAll(
        formatedInitialDate,
        formatedFinalDate,
        this.deviceId
      );
      console.log(response);
      this.locationLog = response;
      this.submitBtnState = ClrLoadingState.SUCCESS;
    } catch (err) {
      console.log(err);
      this.submitBtnState = ClrLoadingState.ERROR;
    }
  }
}
