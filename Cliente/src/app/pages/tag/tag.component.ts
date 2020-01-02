import { Component, OnInit } from "@angular/core";
import { TagService } from "src/app/services/tag.service";
import { ClrLoadingState } from "@clr/angular";

@Component({
  selector: "app-tag",
  templateUrl: "./tag.component.html",
  styleUrls: ["./tag.component.css"]
})
export class TagComponent implements OnInit {
  tags: any[] = [];
  formTag: any = {};

  submitBtnState: ClrLoadingState = ClrLoadingState.DEFAULT;

  constructor(private tagService: TagService) {}

  ngOnInit() {
    this.getAllTags();
  }

  async getAllTags() {
    this.tags = await this.tagService.getAll();
  }

  async addTag() {
    this.submitBtnState = ClrLoadingState.LOADING;

    try {
      let response = await this.tagService.add(this.formTag);
      console.log(response);
      this.submitBtnState = ClrLoadingState.SUCCESS;
      this.getAllTags();
      this.formTag = {};
    } catch (err) {
      console.log(err);
      this.submitBtnState = ClrLoadingState.ERROR;
    }
  }
}
