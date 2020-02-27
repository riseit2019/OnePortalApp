import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IMdmRoleMaster } from 'app/shared/model/mdm-role-master.model';

type EntityResponseType = HttpResponse<IMdmRoleMaster>;
type EntityArrayResponseType = HttpResponse<IMdmRoleMaster[]>;

@Injectable({ providedIn: 'root' })
export class MdmRoleMasterService {
  public resourceUrl = SERVER_API_URL + 'api/mdm-role-masters';

  constructor(protected http: HttpClient) {}

  create(mdmRoleMaster: IMdmRoleMaster): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(mdmRoleMaster);
    return this.http
      .post<IMdmRoleMaster>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(mdmRoleMaster: IMdmRoleMaster): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(mdmRoleMaster);
    return this.http
      .put<IMdmRoleMaster>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IMdmRoleMaster>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IMdmRoleMaster[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(mdmRoleMaster: IMdmRoleMaster): IMdmRoleMaster {
    const copy: IMdmRoleMaster = Object.assign({}, mdmRoleMaster, {
      recordInsertTime:
        mdmRoleMaster.recordInsertTime && mdmRoleMaster.recordInsertTime.isValid() ? mdmRoleMaster.recordInsertTime.toJSON() : undefined,
      createTime: mdmRoleMaster.createTime && mdmRoleMaster.createTime.isValid() ? mdmRoleMaster.createTime.toJSON() : undefined,
      updateTime: mdmRoleMaster.updateTime && mdmRoleMaster.updateTime.isValid() ? mdmRoleMaster.updateTime.toJSON() : undefined
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
      res.body.forEach((mdmRoleMaster: IMdmRoleMaster) => {
        mdmRoleMaster.recordInsertTime = mdmRoleMaster.recordInsertTime ? moment(mdmRoleMaster.recordInsertTime) : undefined;
        mdmRoleMaster.createTime = mdmRoleMaster.createTime ? moment(mdmRoleMaster.createTime) : undefined;
        mdmRoleMaster.updateTime = mdmRoleMaster.updateTime ? moment(mdmRoleMaster.updateTime) : undefined;
      });
    }
    return res;
  }
}
