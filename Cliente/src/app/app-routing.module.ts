import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { LocationLogComponent } from "./pages/location-log/location-log.component";
import { DeviceComponent } from "./pages/device/device.component";
import { ObjectComponent } from "./pages/object/object.component";
import { SectorComponent } from "./pages/sector/sector.component";
import { TagComponent } from "./pages/tag/tag.component";
import { TypeComponent } from "./pages/type/type.component";
import { EpcComponent } from "./pages/epc/epc.component";

const routes: Routes = [
  { path: "", component: LocationLogComponent },
  { path: "devices", component: DeviceComponent },
  { path: "objects", component: ObjectComponent },
  { path: "sectors", component: SectorComponent },
  { path: "tags", component: TagComponent },
  { path: "types", component: TypeComponent },
  { path: "epc", component: EpcComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
