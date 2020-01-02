import { Component, OnInit } from "@angular/core";
import { SectorService } from "src/app/services/sector.service";
import { ClrLoadingState } from "@clr/angular";

@Component({
  selector: "app-sector",
  templateUrl: "./sector.component.html",
  styleUrls: ["./sector.component.css"]
})
export class SectorComponent implements OnInit {
  sectors: any[] = [];
  formSector: any = {};

  submitBtnState: ClrLoadingState = ClrLoadingState.DEFAULT;

  constructor(private sectorService: SectorService) {}

  ngOnInit() {
    this.getAllSectors();
  }

  async getAllSectors() {
    this.sectors = await this.sectorService.getAll();
  }

  async addSector() {
    this.submitBtnState = ClrLoadingState.LOADING;

    try {
      let response = await this.sectorService.add(this.formSector);
      console.log(response);
      this.submitBtnState = ClrLoadingState.SUCCESS;
      this.getAllSectors();
      this.formSector = {};
    } catch (err) {
      console.log(err);
      this.submitBtnState = ClrLoadingState.ERROR;
    }
  }
}
