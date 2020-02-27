import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IMdmCitizenData } from 'app/shared/model/mdm-citizen-data.model';

type EntityResponseType = HttpResponse<IMdmCitizenData>;
type EntityArrayResponseType = HttpResponse<IMdmCitizenData[]>;

@Injectable({ providedIn: 'root' })
export class MdmCitizenDataService {
  public resourceUrl = SERVER_API_URL + 'api/mdm-citizen-data';

  constructor(protected http: HttpClient) {}

  create(mdmCitizenData: IMdmCitizenData): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(mdmCitizenData);
    return this.http
      .post<IMdmCitizenData>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(mdmCitizenData: IMdmCitizenData): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(mdmCitizenData);
    return this.http
      .put<IMdmCitizenData>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IMdmCitizenData>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IMdmCitizenData[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(mdmCitizenData: IMdmCitizenData): IMdmCitizenData {
    const copy: IMdmCitizenData = Object.assign({}, mdmCitizenData, {
      dateOfBirth:
        mdmCitizenData.dateOfBirth && mdmCitizenData.dateOfBirth.isValid() ? mdmCitizenData.dateOfBirth.format(DATE_FORMAT) : undefined,
      recordInsertTime:
        mdmCitizenData.recordInsertTime && mdmCitizenData.recordInsertTime.isValid() ? mdmCitizenData.recordInsertTime.toJSON() : undefined,
      createTime: mdmCitizenData.createTime && mdmCitizenData.createTime.isValid() ? mdmCitizenData.createTime.toJSON() : undefined,
      updateTime: mdmCitizenData.updateTime && mdmCitizenData.updateTime.isValid() ? mdmCitizenData.updateTime.toJSON() : undefined,
      aadhaarVerifiedDate:
        mdmCitizenData.aadhaarVerifiedDate && mdmCitizenData.aadhaarVerifiedDate.isValid()
          ? mdmCitizenData.aadhaarVerifiedDate.toJSON()
          : undefined
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.dateOfBirth = res.body.dateOfBirth ? moment(res.body.dateOfBirth) : undefined;
      res.body.recordInsertTime = res.body.recordInsertTime ? moment(res.body.recordInsertTime) : undefined;
      res.body.createTime = res.body.createTime ? moment(res.body.createTime) : undefined;
      res.body.updateTime = res.body.updateTime ? moment(res.body.updateTime) : undefined;
      res.body.aadhaarVerifiedDate = res.body.aadhaarVerifiedDate ? moment(res.body.aadhaarVerifiedDate) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((mdmCitizenData: IMdmCitizenData) => {
        mdmCitizenData.dateOfBirth = mdmCitizenData.dateOfBirth ? moment(mdmCitizenData.dateOfBirth) : undefined;
        mdmCitizenData.recordInsertTime = mdmCitizenData.recordInsertTime ? moment(mdmCitizenData.recordInsertTime) : undefined;
        mdmCitizenData.createTime = mdmCitizenData.createTime ? moment(mdmCitizenData.createTime) : undefined;
        mdmCitizenData.updateTime = mdmCitizenData.updateTime ? moment(mdmCitizenData.updateTime) : undefined;
        mdmCitizenData.aadhaarVerifiedDate = mdmCitizenData.aadhaarVerifiedDate ? moment(mdmCitizenData.aadhaarVerifiedDate) : undefined;
      });
    }
    return res;
  }
}
