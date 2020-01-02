import { Injectable } from "@angular/core";
import { environment } from "../../environments/environment";
import { HttpClient } from "@angular/common/http";

const BASE_URL = environment.apiUrl;

@Injectable({
  providedIn: "root"
})
export class LocationLogService {
  constructor(private http: HttpClient) {}

  async getAll(initialDate, finalDate, deviceId?) {
    let params = `?startDate=${initialDate}&endDate=${finalDate}`;
    if (deviceId) params += `&deviceId=${deviceId}`;
    console.log(params);
    return await this.http
      .get<any[]>(`${BASE_URL}/location${params}`)
      .toPromise();
  }
}
