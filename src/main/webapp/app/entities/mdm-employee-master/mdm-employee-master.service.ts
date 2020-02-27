import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IMdmEmployeeMaster } from 'app/shared/model/mdm-employee-master.model';

type EntityResponseType = HttpResponse<IMdmEmployeeMaster>;
type EntityArrayResponseType = HttpResponse<IMdmEmployeeMaster[]>;

@Injectable({ providedIn: 'root' })
export class MdmEmployeeMasterService {
  public resourceUrl = SERVER_API_URL + 'api/mdm-employee-masters';

  constructor(protected http: HttpClient) {}

  create(mdmEmployeeMaster: IMdmEmployeeMaster): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(mdmEmployeeMaster);
    return this.http
      .post<IMdmEmployeeMaster>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(mdmEmployeeMaster: IMdmEmployeeMaster): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(mdmEmployeeMaster);
    return this.http
      .put<IMdmEmployeeMaster>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IMdmEmployeeMaster>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IMdmEmployeeMaster[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(mdmEmployeeMaster: IMdmEmployeeMaster): IMdmEmployeeMaster {
    const copy: IMdmEmployeeMaster = Object.assign({}, mdmEmployeeMaster, {
      recordInsertTime:
        mdmEmployeeMaster.recordInsertTime && mdmEmployeeMaster.recordInsertTime.isValid()
          ? mdmEmployeeMaster.recordInsertTime.toJSON()
          : undefined,
      createTime:
        mdmEmployeeMaster.createTime && mdmEmployeeMaster.createTime.isValid() ? mdmEmployeeMaster.createTime.toJSON() : undefined,
      updateTime: mdmEmployeeMaster.updateTime && mdmEmployeeMaster.updateTime.isValid() ? mdmEmployeeMaster.updateTime.toJSON() : undefined
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.recordInsertTime = res.body.recordInsertTime ? moment(res.body.recordInsertTime) : undefined;
      res.body.createTime = res.body.createTime ? moment(res.body.createTime) : undefined;
      res.body.updateTime = res.body.updateTime ? moment(res.body.updateTime) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((mdmEmployeeMaster: IMdmEmployeeMaster) => {
        mdmEmployeeMaster.recordInsertTime = mdmEmployeeMaster.recordInsertTime ? moment(mdmEmployeeMaster.recordInsertTime) : undefined;
        mdmEmployeeMaster.createTime = mdmEmployeeMaster.createTime ? moment(mdmEmployeeMaster.createTime) : undefined;
        mdmEmployeeMaster.updateTime = mdmEmployeeMaster.updateTime ? moment(mdmEmployeeMaster.updateTime) : undefined;
      });
    }
    return res;
  }
}
