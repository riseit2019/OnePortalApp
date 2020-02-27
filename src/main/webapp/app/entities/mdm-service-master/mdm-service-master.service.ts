import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IMdmServiceMaster } from 'app/shared/model/mdm-service-master.model';

type EntityResponseType = HttpResponse<IMdmServiceMaster>;
type EntityArrayResponseType = HttpResponse<IMdmServiceMaster[]>;

@Injectable({ providedIn: 'root' })
export class MdmServiceMasterService {
  public resourceUrl = SERVER_API_URL + 'api/mdm-service-masters';

  constructor(protected http: HttpClient) {}

  create(mdmServiceMaster: IMdmServiceMaster): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(mdmServiceMaster);
    return this.http
      .post<IMdmServiceMaster>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(mdmServiceMaster: IMdmServiceMaster): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(mdmServiceMaster);
    return this.http
      .put<IMdmServiceMaster>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IMdmServiceMaster>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IMdmServiceMaster[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(mdmServiceMaster: IMdmServiceMaster): IMdmServiceMaster {
    const copy: IMdmServiceMaster = Object.assign({}, mdmServiceMaster, {
      servicePeriodStartDate:
        mdmServiceMaster.servicePeriodStartDate && mdmServiceMaster.servicePeriodStartDate.isValid()
          ? mdmServiceMaster.servicePeriodStartDate.toJSON()
          : undefined,
      servicePeriodEndDate:
        mdmServiceMaster.servicePeriodEndDate && mdmServiceMaster.servicePeriodEndDate.isValid()
          ? mdmServiceMaster.servicePeriodEndDate.toJSON()
          : undefined,
      recordInsertTime:
        mdmServiceMaster.recordInsertTime && mdmServiceMaster.recordInsertTime.isValid()
          ? mdmServiceMaster.recordInsertTime.toJSON()
          : undefined,
      createTime: mdmServiceMaster.createTime && mdmServiceMaster.createTime.isValid() ? mdmServiceMaster.createTime.toJSON() : undefined,
      updateTime: mdmServiceMaster.updateTime && mdmServiceMaster.updateTime.isValid() ? mdmServiceMaster.updateTime.toJSON() : undefined
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.servicePeriodStartDate = res.body.servicePeriodStartDate ? moment(res.body.servicePeriodStartDate) : undefined;
      res.body.servicePeriodEndDate = res.body.servicePeriodEndDate ? moment(res.body.servicePeriodEndDate) : undefined;
      res.body.recordInsertTime = res.body.recordInsertTime ? moment(res.body.recordInsertTime) : undefined;
      res.body.createTime = res.body.createTime ? moment(res.body.createTime) : undefined;
      res.body.updateTime = res.body.updateTime ? moment(res.body.updateTime) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((mdmServiceMaster: IMdmServiceMaster) => {
        mdmServiceMaster.servicePeriodStartDate = mdmServiceMaster.servicePeriodStartDate
          ? moment(mdmServiceMaster.servicePeriodStartDate)
          : undefined;
        mdmServiceMaster.servicePeriodEndDate = mdmServiceMaster.servicePeriodEndDate
          ? moment(mdmServiceMaster.servicePeriodEndDate)
          : undefined;
        mdmServiceMaster.recordInsertTime = mdmServiceMaster.recordInsertTime ? moment(mdmServiceMaster.recordInsertTime) : undefined;
        mdmServiceMaster.createTime = mdmServiceMaster.createTime ? moment(mdmServiceMaster.createTime) : undefined;
        mdmServiceMaster.updateTime = mdmServiceMaster.updateTime ? moment(mdmServiceMaster.updateTime) : undefined;
      });
    }
    return res;
  }
}
