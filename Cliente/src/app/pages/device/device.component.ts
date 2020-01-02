import { Component, OnInit } from "@angular/core";
import { DeviceService } from "src/app/services/device.service";
import { ClrLoadingState } from "@clr/angular";

@Component({
  selector: "app-device",
  templateUrl: "./device.component.html",
  styleUrls: ["./device.component.css"]
})
export class DeviceComponent implements OnInit {
  devices: any[] = [];
  formDevice: any = {};

  submitBtnState: ClrLoadingState = ClrLoadingState.DEFAULT;

  constructor(private deviceService: DeviceService) {}

  ngOnInit() {
    this.getAllDevices();
  }

  async getAllDevices() {
    this.devices = await this.deviceService.getAll();
  }

  async addDevice() {
    this.submitBtnState = ClrLoadingState.LOADING;

    try {
      let response = await this.deviceService.add(this.formDevice);
      console.log(response);
      this.submitBtnState = ClrLoadingState.SUCCESS;
      this.getAllDevices();
      this.formDevice = {};
    } catch (err) {
      console.log(err);
      this.submitBtnState = ClrLoadingState.ERROR;
    }
  }
}
