import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IMdmEmpRoleMaster } from 'app/shared/model/mdm-emp-role-master.model';

type EntityResponseType = HttpResponse<IMdmEmpRoleMaster>;
type EntityArrayResponseType = HttpResponse<IMdmEmpRoleMaster[]>;

@Injectable({ providedIn: 'root' })
export class MdmEmpRoleMasterService {
  public resourceUrl = SERVER_API_URL + 'api/mdm-emp-role-masters';

  constructor(protected http: HttpClient) {}

  create(mdmEmpRoleMaster: IMdmEmpRoleMaster): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(mdmEmpRoleMaster);
    return this.http
      .post<IMdmEmpRoleMaster>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(mdmEmpRoleMaster: IMdmEmpRoleMaster): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(mdmEmpRoleMaster);
    return this.http
      .put<IMdmEmpRoleMaster>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IMdmEmpRoleMaster>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IMdmEmpRoleMaster[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(mdmEmpRoleMaster: IMdmEmpRoleMaster): IMdmEmpRoleMaster {
    const copy: IMdmEmpRoleMaster = Object.assign({}, mdmEmpRoleMaster, {
      recordInsertTime:
        mdmEmpRoleMaster.recordInsertTime && mdmEmpRoleMaster.recordInsertTime.isValid()
          ? mdmEmpRoleMaster.recordInsertTime.toJSON()
          : undefined,
      createTime: mdmEmpRoleMaster.createTime && mdmEmpRoleMaster.createTime.isValid() ? mdmEmpRoleMaster.createTime.toJSON() : undefined,
      updateTime: mdmEmpRoleMaster.updateTime && mdmEmpRoleMaster.updateTime.isValid() ? mdmEmpRoleMaster.updateTime.toJSON() : undefined
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
      res.body.forEach((mdmEmpRoleMaster: IMdmEmpRoleMaster) => {
        mdmEmpRoleMaster.recordInsertTime = mdmEmpRoleMaster.recordInsertTime ? moment(mdmEmpRoleMaster.recordInsertTime) : undefined;
        mdmEmpRoleMaster.createTime = mdmEmpRoleMaster.createTime ? moment(mdmEmpRoleMaster.createTime) : undefined;
        mdmEmpRoleMaster.updateTime = mdmEmpRoleMaster.updateTime ? moment(mdmEmpRoleMaster.updateTime) : undefined;
      });
    }
    return res;
  }
}
