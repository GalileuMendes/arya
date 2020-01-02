import { Component, OnInit } from "@angular/core";
import { EpcService } from "src/app/services/epc.service";
import { ClrLoadingState } from "@clr/angular";
import { TypeService } from "src/app/services/type.service";
import { SectorService } from "src/app/services/sector.service";
import { ObjectService } from "src/app/services/object.service";
import { TagService } from "src/app/services/tag.service";

@Component({
  selector: "app-epc",
  templateUrl: "./epc.component.html",
  styleUrls: ["./epc.component.css"]
})
export class EpcComponent implements OnInit {
  epcs: any[] = [];
  types: any[] = [];
  sectors: any[] = [];
  objects: any[] = [];
  tags: any[] = [];
  epc: any = {};

  submitBtnState: ClrLoadingState = ClrLoadingState.DEFAULT;

  constructor(
    private epcService: EpcService,
    private typeService: TypeService,
    private sectorService: SectorService,
    private objectService: ObjectService,
    private tagService: TagService
  ) {}

  ngOnInit() {
    this.getAllEpcs();
    this.loadSelects();
  }

  async getAllEpcs() {
    this.epcs = await this.epcService.getAll();
  }

  async loadSelects() {
    this.types = await this.typeService.getAll();
    this.sectors = await this.sectorService.getAll();
    this.objects = await this.objectService.getAll();
    this.tags = await this.tagService.getAll();
  }

  async addEpc() {
    this.submitBtnState = ClrLoadingState.LOADING;

    try {
      let response = await this.epcService.add(this.epc);
      console.log(response);
      this.submitBtnState = ClrLoadingState.SUCCESS;
      this.getAllEpcs();
      this.epc = {};
    } catch (err) {
      console.log(err);
      this.submitBtnState = ClrLoadingState.ERROR;
    }
  }
}
