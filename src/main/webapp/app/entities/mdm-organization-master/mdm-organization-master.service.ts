import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IMdmOrganizationMaster } from 'app/shared/model/mdm-organization-master.model';

type EntityResponseType = HttpResponse<IMdmOrganizationMaster>;
type EntityArrayResponseType = HttpResponse<IMdmOrganizationMaster[]>;

@Injectable({ providedIn: 'root' })
export class MdmOrganizationMasterService {
  public resourceUrl = SERVER_API_URL + 'api/mdm-organization-masters';

  constructor(protected http: HttpClient) {}

  create(mdmOrganizationMaster: IMdmOrganizationMaster): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(mdmOrganizationMaster);
    return this.http
      .post<IMdmOrganizationMaster>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(mdmOrganizationMaster: IMdmOrganizationMaster): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(mdmOrganizationMaster);
    return this.http
      .put<IMdmOrganizationMaster>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IMdmOrganizationMaster>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IMdmOrganizationMaster[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(mdmOrganizationMaster: IMdmOrganizationMaster): IMdmOrganizationMaster {
    const copy: IMdmOrganizationMaster = Object.assign({}, mdmOrganizationMaster, {
      recordInsertTime:
        mdmOrganizationMaster.recordInsertTime && mdmOrganizationMaster.recordInsertTime.isValid()
          ? mdmOrganizationMaster.recordInsertTime.toJSON()
          : undefined,
      createTime:
        mdmOrganizationMaster.createTime && mdmOrganizationMaster.createTime.isValid()
          ? mdmOrganizationMaster.createTime.toJSON()
          : undefined,
      updateTime:
        mdmOrganizationMaster.updateTime && mdmOrganizationMaster.updateTime.isValid()
          ? mdmOrganizationMaster.updateTime.toJSON()
          : undefined,
      startDate:
        mdmOrganizationMaster.startDate && mdmOrganizationMaster.startDate.isValid()
          ? mdmOrganizationMaster.startDate.format(DATE_FORMAT)
          : undefined,
      endDate:
        mdmOrganizationMaster.endDate && mdmOrganizationMaster.endDate.isValid()
          ? mdmOrganizationMaster.endDate.format(DATE_FORMAT)
          : undefined
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.recordInsertTime = res.body.recordInsertTime ? moment(res.body.recordInsertTime) : undefined;
      res.body.createTime = res.body.createTime ? moment(res.body.createTime) : undefined;
      res.body.updateTime = res.body.updateTime ? moment(res.body.updateTime) : undefined;
      res.body.startDate = res.body.startDate ? moment(res.body.startDate) : undefined;
      res.body.endDate = res.body.endDate ? moment(res.body.endDate) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((mdmOrganizationMaster: IMdmOrganizationMaster) => {
        mdmOrganizationMaster.recordInsertTime = mdmOrganizationMaster.recordInsertTime
          ? moment(mdmOrganizationMaster.recordInsertTime)
          : undefined;
        mdmOrganizationMaster.createTime = mdmOrganizationMaster.createTime ? moment(mdmOrganizationMaster.createTime) : undefined;
        mdmOrganizationMaster.updateTime = mdmOrganizationMaster.updateTime ? moment(mdmOrganizationMaster.updateTime) : undefined;
        mdmOrganizationMaster.startDate = mdmOrganizationMaster.startDate ? moment(mdmOrganizationMaster.startDate) : undefined;
        mdmOrganizationMaster.endDate = mdmOrganizationMaster.endDate ? moment(mdmOrganizationMaster.endDate) : undefined;
      });
    }
    return res;
  }
}
