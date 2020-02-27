import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IMdmActivityMaster } from 'app/shared/model/mdm-activity-master.model';

type EntityResponseType = HttpResponse<IMdmActivityMaster>;
type EntityArrayResponseType = HttpResponse<IMdmActivityMaster[]>;

@Injectable({ providedIn: 'root' })
export class MdmActivityMasterService {
  public resourceUrl = SERVER_API_URL + 'api/mdm-activity-masters';

  constructor(protected http: HttpClient) {}

  create(mdmActivityMaster: IMdmActivityMaster): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(mdmActivityMaster);
    return this.http
      .post<IMdmActivityMaster>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(mdmActivityMaster: IMdmActivityMaster): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(mdmActivityMaster);
    return this.http
      .put<IMdmActivityMaster>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IMdmActivityMaster>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IMdmActivityMaster[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(mdmActivityMaster: IMdmActivityMaster): IMdmActivityMaster {
    const copy: IMdmActivityMaster = Object.assign({}, mdmActivityMaster, {
      recordInsertTime:
        mdmActivityMaster.recordInsertTime && mdmActivityMaster.recordInsertTime.isValid()
          ? mdmActivityMaster.recordInsertTime.toJSON()
          : undefined,
      createTime:
        mdmActivityMaster.createTime && mdmActivityMaster.createTime.isValid() ? mdmActivityMaster.createTime.toJSON() : undefined,
      updateTime: mdmActivityMaster.updateTime && mdmActivityMaster.updateTime.isValid() ? mdmActivityMaster.updateTime.toJSON() : undefined
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
      res.body.forEach((mdmActivityMaster: IMdmActivityMaster) => {
        mdmActivityMaster.recordInsertTime = mdmActivityMaster.recordInsertTime ? moment(mdmActivityMaster.recordInsertTime) : undefined;
        mdmActivityMaster.createTime = mdmActivityMaster.createTime ? moment(mdmActivityMaster.createTime) : undefined;
        mdmActivityMaster.updateTime = mdmActivityMaster.updateTime ? moment(mdmActivityMaster.updateTime) : undefined;
      });
    }
    return res;
  }
}
