import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IMdmMeesevaServiceMaster } from 'app/shared/model/mdm-meeseva-service-master.model';

type EntityResponseType = HttpResponse<IMdmMeesevaServiceMaster>;
type EntityArrayResponseType = HttpResponse<IMdmMeesevaServiceMaster[]>;

@Injectable({ providedIn: 'root' })
export class MdmMeesevaServiceMasterService {
  public resourceUrl = SERVER_API_URL + 'api/mdm-meeseva-service-masters';

  constructor(protected http: HttpClient) {}

  create(mdmMeesevaServiceMaster: IMdmMeesevaServiceMaster): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(mdmMeesevaServiceMaster);
    return this.http
      .post<IMdmMeesevaServiceMaster>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(mdmMeesevaServiceMaster: IMdmMeesevaServiceMaster): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(mdmMeesevaServiceMaster);
    return this.http
      .put<IMdmMeesevaServiceMaster>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IMdmMeesevaServiceMaster>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IMdmMeesevaServiceMaster[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(mdmMeesevaServiceMaster: IMdmMeesevaServiceMaster): IMdmMeesevaServiceMaster {
    const copy: IMdmMeesevaServiceMaster = Object.assign({}, mdmMeesevaServiceMaster, {
      launchDate:
        mdmMeesevaServiceMaster.launchDate && mdmMeesevaServiceMaster.launchDate.isValid()
          ? mdmMeesevaServiceMaster.launchDate.toJSON()
          : undefined,
      citizenPortalLaunchDate:
        mdmMeesevaServiceMaster.citizenPortalLaunchDate && mdmMeesevaServiceMaster.citizenPortalLaunchDate.isValid()
          ? mdmMeesevaServiceMaster.citizenPortalLaunchDate.toJSON()
          : undefined,
      recordInsertTime:
        mdmMeesevaServiceMaster.recordInsertTime && mdmMeesevaServiceMaster.recordInsertTime.isValid()
          ? mdmMeesevaServiceMaster.recordInsertTime.toJSON()
          : undefined,
      createTime:
        mdmMeesevaServiceMaster.createTime && mdmMeesevaServiceMaster.createTime.isValid()
          ? mdmMeesevaServiceMaster.createTime.toJSON()
          : undefined,
      updateTime:
        mdmMeesevaServiceMaster.updateTime && mdmMeesevaServiceMaster.updateTime.isValid()
          ? mdmMeesevaServiceMaster.updateTime.toJSON()
          : undefined
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.launchDate = res.body.launchDate ? moment(res.body.launchDate) : undefined;
      res.body.citizenPortalLaunchDate = res.body.citizenPortalLaunchDate ? moment(res.body.citizenPortalLaunchDate) : undefined;
      res.body.recordInsertTime = res.body.recordInsertTime ? moment(res.body.recordInsertTime) : undefined;
      res.body.createTime = res.body.createTime ? moment(res.body.createTime) : undefined;
      res.body.updateTime = res.body.updateTime ? moment(res.body.updateTime) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((mdmMeesevaServiceMaster: IMdmMeesevaServiceMaster) => {
        mdmMeesevaServiceMaster.launchDate = mdmMeesevaServiceMaster.launchDate ? moment(mdmMeesevaServiceMaster.launchDate) : undefined;
        mdmMeesevaServiceMaster.citizenPortalLaunchDate = mdmMeesevaServiceMaster.citizenPortalLaunchDate
          ? moment(mdmMeesevaServiceMaster.citizenPortalLaunchDate)
          : undefined;
        mdmMeesevaServiceMaster.recordInsertTime = mdmMeesevaServiceMaster.recordInsertTime
          ? moment(mdmMeesevaServiceMaster.recordInsertTime)
          : undefined;
        mdmMeesevaServiceMaster.createTime = mdmMeesevaServiceMaster.createTime ? moment(mdmMeesevaServiceMaster.createTime) : undefined;
        mdmMeesevaServiceMaster.updateTime = mdmMeesevaServiceMaster.updateTime ? moment(mdmMeesevaServiceMaster.updateTime) : undefined;
      });
    }
    return res;
  }
}
