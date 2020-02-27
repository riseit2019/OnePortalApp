import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { MdmRoleMasterService } from 'app/entities/mdm-role-master/mdm-role-master.service';
import { IMdmRoleMaster, MdmRoleMaster } from 'app/shared/model/mdm-role-master.model';

describe('Service Tests', () => {
  describe('MdmRoleMaster Service', () => {
    let injector: TestBed;
    let service: MdmRoleMasterService;
    let httpMock: HttpTestingController;
    let elemDefault: IMdmRoleMaster;
    let expectedResult: IMdmRoleMaster | IMdmRoleMaster[] | boolean | null;
    let currentDate: moment.Moment;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(MdmRoleMasterService);
      httpMock = injector.get(HttpTestingController);
      currentDate = moment();

      elemDefault = new MdmRoleMaster(
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        currentDate,
        currentDate,
        0,
        'AAAAAAA',
        'AAAAAAA'
      );
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign(
          {
            recordInsertTime: currentDate.format(DATE_TIME_FORMAT),
            createTime: currentDate.format(DATE_TIME_FORMAT),
            updateTime: currentDate.format(DATE_TIME_FORMAT)
          },
          elemDefault
        );

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a MdmRoleMaster', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            recordInsertTime: currentDate.format(DATE_TIME_FORMAT),
            createTime: currentDate.format(DATE_TIME_FORMAT),
            updateTime: currentDate.format(DATE_TIME_FORMAT)
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            recordInsertTime: currentDate,
            createTime: currentDate,
            updateTime: currentDate
          },
          returnedFromService
        );

        service.create(new MdmRoleMaster()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a MdmRoleMaster', () => {
        const returnedFromService = Object.assign(
          {
            roleCode: 'BBBBBB',
            roleName: 'BBBBBB',
            roleDesc: 'BBBBBB',
            organizationName: 'BBBBBB',
            serviceCode: 'BBBBBB',
            serviceName: 'BBBBBB',
            locationCode: 'BBBBBB',
            locationName: 'BBBBBB',
            roleStatus: 'BBBBBB',
            createdBy: 'BBBBBB',
            updatedBy: 'BBBBBB',
            recordInsertTime: currentDate.format(DATE_TIME_FORMAT),
            createTime: currentDate.format(DATE_TIME_FORMAT),
            updateTime: currentDate.format(DATE_TIME_FORMAT),
            roleLevelId: 1,
            roleLevelDesc: 'BBBBBB',
            volunteerSecretariat: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            recordInsertTime: currentDate,
            createTime: currentDate,
            updateTime: currentDate
          },
          returnedFromService
        );

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of MdmRoleMaster', () => {
        const returnedFromService = Object.assign(
          {
            roleCode: 'BBBBBB',
            roleName: 'BBBBBB',
            roleDesc: 'BBBBBB',
            organizationName: 'BBBBBB',
            serviceCode: 'BBBBBB',
            serviceName: 'BBBBBB',
            locationCode: 'BBBBBB',
            locationName: 'BBBBBB',
            roleStatus: 'BBBBBB',
            createdBy: 'BBBBBB',
            updatedBy: 'BBBBBB',
            recordInsertTime: currentDate.format(DATE_TIME_FORMAT),
            createTime: currentDate.format(DATE_TIME_FORMAT),
            updateTime: currentDate.format(DATE_TIME_FORMAT),
            roleLevelId: 1,
            roleLevelDesc: 'BBBBBB',
            volunteerSecretariat: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            recordInsertTime: currentDate,
            createTime: currentDate,
            updateTime: currentDate
          },
          returnedFromService
        );

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a MdmRoleMaster', () => {
        service.delete(123).subscribe(resp => (expectedResult = resp.ok));

        const req = httpMock.expectOne({ method: 'DELETE' });
        req.flush({ status: 200 });
        expect(expectedResult);
      });
    });

    afterEach(() => {
      httpMock.verify();
    });
  });
});
