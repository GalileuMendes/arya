import { Injectable } from "@angular/core";
import { environment } from "../../environments/environment";
import { HttpClient } from "@angular/common/http";

const BASE_URL = environment.apiUrl;

@Injectable({
  providedIn: "root"
})
export class TagService {
  constructor(private http: HttpClient) {}

  async getAll() {
    return await this.http.get<any[]>(`${BASE_URL}/tagrfid`).toPromise();
  }

  async add(tagrfid: any) {
    return await this.http.post(`${BASE_URL}/tagrfid`, tagrfid).toPromise();
  }
}
