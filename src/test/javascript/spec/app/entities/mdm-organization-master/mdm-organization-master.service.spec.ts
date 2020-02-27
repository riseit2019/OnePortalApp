import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import * as moment from 'moment';
import { DATE_FORMAT, DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { MdmOrganizationMasterService } from 'app/entities/mdm-organization-master/mdm-organization-master.service';
import { IMdmOrganizationMaster, MdmOrganizationMaster } from 'app/shared/model/mdm-organization-master.model';

describe('Service Tests', () => {
  describe('MdmOrganizationMaster Service', () => {
    let injector: TestBed;
    let service: MdmOrganizationMasterService;
    let httpMock: HttpTestingController;
    let elemDefault: IMdmOrganizationMaster;
    let expectedResult: IMdmOrganizationMaster | IMdmOrganizationMaster[] | boolean | null;
    let currentDate: moment.Moment;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(MdmOrganizationMasterService);
      httpMock = injector.get(HttpTestingController);
      currentDate = moment();

      elemDefault = new MdmOrganizationMaster(
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        false,
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        currentDate,
        currentDate,
        currentDate,
        currentDate,
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
            updateTime: currentDate.format(DATE_TIME_FORMAT),
            startDate: currentDate.format(DATE_FORMAT),
            endDate: currentDate.format(DATE_FORMAT)
          },
          elemDefault
        );

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a MdmOrganizationMaster', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            recordInsertTime: currentDate.format(DATE_TIME_FORMAT),
            createTime: currentDate.format(DATE_TIME_FORMAT),
            updateTime: currentDate.format(DATE_TIME_FORMAT),
            startDate: currentDate.format(DATE_FORMAT),
            endDate: currentDate.format(DATE_FORMAT)
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            recordInsertTime: currentDate,
            createTime: currentDate,
            updateTime: currentDate,
            startDate: currentDate,
            endDate: currentDate
          },
          returnedFromService
        );

        service.create(new MdmOrganizationMaster()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a MdmOrganizationMaster', () => {
        const returnedFromService = Object.assign(
          {
            organizationCode: 'BBBBBB',
            organizationShortName: 'BBBBBB',
            organizationName: 'BBBBBB',
            organizationType: 'BBBBBB',
            organizationDesc: 'BBBBBB',
            sectorCode: 'BBBBBB',
            parentOrgCode: 'BBBBBB',
            organizationActiveFlag: true,
            createdBy: 'BBBBBB',
            updatedBy: 'BBBBBB',
            recordInsertTime: currentDate.format(DATE_TIME_FORMAT),
            createTime: currentDate.format(DATE_TIME_FORMAT),
            updateTime: currentDate.format(DATE_TIME_FORMAT),
            startDate: currentDate.format(DATE_FORMAT),
            endDate: currentDate.format(DATE_FORMAT),
            organizationTypeDesc: 'BBBBBB',
            jurisdictionType: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            recordInsertTime: currentDate,
            createTime: currentDate,
            updateTime: currentDate,
            startDate: currentDate,
            endDate: currentDate
          },
          returnedFromService
        );

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of MdmOrganizationMaster', () => {
        const returnedFromService = Object.assign(
          {
            organizationCode: 'BBBBBB',
            organizationShortName: 'BBBBBB',
            organizationName: 'BBBBBB',
            organizationType: 'BBBBBB',
            organizationDesc: 'BBBBBB',
            sectorCode: 'BBBBBB',
            parentOrgCode: 'BBBBBB',
            organizationActiveFlag: true,
            createdBy: 'BBBBBB',
            updatedBy: 'BBBBBB',
            recordInsertTime: currentDate.format(DATE_TIME_FORMAT),
            createTime: currentDate.format(DATE_TIME_FORMAT),
            updateTime: currentDate.format(DATE_TIME_FORMAT),
            startDate: currentDate.format(DATE_FORMAT),
            endDate: currentDate.format(DATE_FORMAT),
            organizationTypeDesc: 'BBBBBB',
            jurisdictionType: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            recordInsertTime: currentDate,
            createTime: currentDate,
            updateTime: currentDate,
            startDate: currentDate,
            endDate: currentDate
          },
          returnedFromService
        );

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a MdmOrganizationMaster', () => {
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
