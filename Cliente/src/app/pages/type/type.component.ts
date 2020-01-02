import { Component, OnInit } from "@angular/core";
import { TypeService } from "src/app/services/type.service";
import { ClrLoadingState } from "@clr/angular";

@Component({
  selector: "app-type",
  templateUrl: "./type.component.html",
  styleUrls: ["./type.component.css"]
})
export class TypeComponent implements OnInit {
  types: any[] = [];
  formType: any = {};

  submitBtnState: ClrLoadingState = ClrLoadingState.DEFAULT;

  constructor(private typeService: TypeService) {}

  ngOnInit() {
    this.getAllTypes();
  }

  async getAllTypes() {
    this.types = await this.typeService.getAll();
  }

  async addType() {
    this.submitBtnState = ClrLoadingState.LOADING;

    try {
      let response = await this.typeService.add(this.formType);
      console.log(response);
      this.submitBtnState = ClrLoadingState.SUCCESS;
      this.getAllTypes();
      this.formType = {};
    } catch (err) {
      console.log(err);
      this.submitBtnState = ClrLoadingState.ERROR;
    }
  }
}
