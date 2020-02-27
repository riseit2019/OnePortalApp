import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { MdmActivityMasterService } from 'app/entities/mdm-activity-master/mdm-activity-master.service';
import { IMdmActivityMaster, MdmActivityMaster } from 'app/shared/model/mdm-activity-master.model';

describe('Service Tests', () => {
  describe('MdmActivityMaster Service', () => {
    let injector: TestBed;
    let service: MdmActivityMasterService;
    let httpMock: HttpTestingController;
    let elemDefault: IMdmActivityMaster;
    let expectedResult: IMdmActivityMaster | IMdmActivityMaster[] | boolean | null;
    let currentDate: moment.Moment;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(MdmActivityMasterService);
      httpMock = injector.get(HttpTestingController);
      currentDate = moment();

      elemDefault = new MdmActivityMaster(
        0,
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        currentDate,
        currentDate
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

      it('should create a MdmActivityMaster', () => {
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

        service.create(new MdmActivityMaster()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a MdmActivityMaster', () => {
        const returnedFromService = Object.assign(
          {
            syspk: 1,
            activityCode: 'BBBBBB',
            activityName: 'BBBBBB',
            activityDesc: 'BBBBBB',
            activityLevelId: 1,
            activityLevelDesc: 'BBBBBB',
            organizationName: 'BBBBBB',
            activityStatus: 'BBBBBB',
            createdBy: 'BBBBBB',
            updatedBy: 'BBBBBB',
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

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of MdmActivityMaster', () => {
        const returnedFromService = Object.assign(
          {
            syspk: 1,
            activityCode: 'BBBBBB',
            activityName: 'BBBBBB',
            activityDesc: 'BBBBBB',
            activityLevelId: 1,
            activityLevelDesc: 'BBBBBB',
            organizationName: 'BBBBBB',
            activityStatus: 'BBBBBB',
            createdBy: 'BBBBBB',
            updatedBy: 'BBBBBB',
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

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a MdmActivityMaster', () => {
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
