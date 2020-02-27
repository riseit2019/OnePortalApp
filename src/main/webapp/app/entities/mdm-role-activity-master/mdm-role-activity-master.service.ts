import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IMdmRoleActivityMaster } from 'app/shared/model/mdm-role-activity-master.model';

type EntityResponseType = HttpResponse<IMdmRoleActivityMaster>;
type EntityArrayResponseType = HttpResponse<IMdmRoleActivityMaster[]>;

@Injectable({ providedIn: 'root' })
export class MdmRoleActivityMasterService {
  public resourceUrl = SERVER_API_URL + 'api/mdm-role-activity-masters';

  constructor(protected http: HttpClient) {}

  create(mdmRoleActivityMaster: IMdmRoleActivityMaster): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(mdmRoleActivityMaster);
    return this.http
      .post<IMdmRoleActivityMaster>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(mdmRoleActivityMaster: IMdmRoleActivityMaster): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(mdmRoleActivityMaster);
    return this.http
      .put<IMdmRoleActivityMaster>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IMdmRoleActivityMaster>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IMdmRoleActivityMaster[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(mdmRoleActivityMaster: IMdmRoleActivityMaster): IMdmRoleActivityMaster {
    const copy: IMdmRoleActivityMaster = Object.assign({}, mdmRoleActivityMaster, {
      recordInsertTime:
        mdmRoleActivityMaster.recordInsertTime && mdmRoleActivityMaster.recordInsertTime.isValid()
          ? mdmRoleActivityMaster.recordInsertTime.toJSON()
          : undefined,
      createTime:
        mdmRoleActivityMaster.createTime && mdmRoleActivityMaster.createTime.isValid()
          ? mdmRoleActivityMaster.createTime.toJSON()
          : undefined,
      updateTime:
        mdmRoleActivityMaster.updateTime && mdmRoleActivityMaster.updateTime.isValid()
          ? mdmRoleActivityMaster.updateTime.toJSON()
          : undefined
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
      res.body.forEach((mdmRoleActivityMaster: IMdmRoleActivityMaster) => {
        mdmRoleActivityMaster.recordInsertTime = mdmRoleActivityMaster.recordInsertTime
          ? moment(mdmRoleActivityMaster.recordInsertTime)
          : undefined;
        mdmRoleActivityMaster.createTime = mdmRoleActivityMaster.createTime ? moment(mdmRoleActivityMaster.createTime) : undefined;
        mdmRoleActivityMaster.updateTime = mdmRoleActivityMaster.updateTime ? moment(mdmRoleActivityMaster.updateTime) : undefined;
      });
    }
    return res;
  }
}
