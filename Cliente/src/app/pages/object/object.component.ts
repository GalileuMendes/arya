import { Component, OnInit } from "@angular/core";
import { ObjectService } from "src/app/services/object.service";
import { ClrLoadingState } from "@clr/angular";

@Component({
  selector: "app-object",
  templateUrl: "./object.component.html",
  styleUrls: ["./object.component.css"]
})
export class ObjectComponent implements OnInit {
  objects: any[] = [];
  formObject: any = {};

  submitBtnState: ClrLoadingState = ClrLoadingState.DEFAULT;

  constructor(private objectService: ObjectService) {}

  ngOnInit() {
    this.getAllObjects();
  }

  async getAllObjects() {
    this.objects = await this.objectService.getAll();
  }

  async addObject() {
    this.submitBtnState = ClrLoadingState.LOADING;

    try {
      let response = await this.objectService.add(this.formObject);
      console.log(response);
      this.submitBtnState = ClrLoadingState.SUCCESS;
      this.getAllObjects();
      this.formObject = {};
    } catch (err) {
      console.log(err);
      this.submitBtnState = ClrLoadingState.ERROR;
    }
  }
}
