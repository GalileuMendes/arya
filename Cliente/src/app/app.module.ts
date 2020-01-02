import { BrowserModule } from "@angular/platform-browser";
import { NgModule, LOCALE_ID } from "@angular/core";
import { HttpClientModule } from "@angular/common/http";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { ClarityModule } from "@clr/angular";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { FormsModule } from "@angular/forms";
import { LocationLogComponent } from "./pages/location-log/location-log.component";
import { registerLocaleData } from "@angular/common";
import localePt from "@angular/common/locales/pt";
import { DeviceComponent } from './pages/device/device.component';
import { ObjectComponent } from './pages/object/object.component';
import { SectorComponent } from './pages/sector/sector.component';
import { TagComponent } from './pages/tag/tag.component';
import { TypeComponent } from './pages/type/type.component';
import { EpcComponent } from './pages/epc/epc.component';

registerLocaleData(localePt);

@NgModule({
  declarations: [AppComponent, LocationLogComponent, DeviceComponent, ObjectComponent, SectorComponent, TagComponent, TypeComponent, EpcComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ClarityModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [{ provide: LOCALE_ID, useValue: "pt" }],
  bootstrap: [AppComponent]
})
export class AppModule {}
