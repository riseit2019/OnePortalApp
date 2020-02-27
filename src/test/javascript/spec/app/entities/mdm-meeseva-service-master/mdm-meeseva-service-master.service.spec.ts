import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { MdmMeesevaServiceMasterService } from 'app/entities/mdm-meeseva-service-master/mdm-meeseva-service-master.service';
import { IMdmMeesevaServiceMaster, MdmMeesevaServiceMaster } from 'app/shared/model/mdm-meeseva-service-master.model';

describe('Service Tests', () => {
  describe('MdmMeesevaServiceMaster Service', () => {
    let injector: TestBed;
    let service: MdmMeesevaServiceMasterService;
    let httpMock: HttpTestingController;
    let elemDefault: IMdmMeesevaServiceMaster;
    let expectedResult: IMdmMeesevaServiceMaster | IMdmMeesevaServiceMaster[] | boolean | null;
    let currentDate: moment.Moment;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(MdmMeesevaServiceMasterService);
      httpMock = injector.get(HttpTestingController);
      currentDate = moment();

      elemDefault = new MdmMeesevaServiceMaster(
        0,
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
        0,
        'AAAAAAA',
        0,
        0,
        0,
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        currentDate,
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
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
            launchDate: currentDate.format(DATE_TIME_FORMAT),
            citizenPortalLaunchDate: currentDate.format(DATE_TIME_FORMAT),
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

      it('should create a MdmMeesevaServiceMaster', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            launchDate: currentDate.format(DATE_TIME_FORMAT),
            citizenPortalLaunchDate: currentDate.format(DATE_TIME_FORMAT),
            recordInsertTime: currentDate.format(DATE_TIME_FORMAT),
            createTime: currentDate.format(DATE_TIME_FORMAT),
            updateTime: currentDate.format(DATE_TIME_FORMAT)
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            launchDate: currentDate,
            citizenPortalLaunchDate: currentDate,
            recordInsertTime: currentDate,
            createTime: currentDate,
            updateTime: currentDate
          },
          returnedFromService
        );

        service.create(new MdmMeesevaServiceMaster()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a MdmMeesevaServiceMaster', () => {
        const returnedFromService = Object.assign(
          {
            meesevaServiceId: 1,
            meesevaServiceName: 'BBBBBB',
            isCharged: 'BBBBBB',
            organizationEntityTypeCode: 'BBBBBB',
            applicationTable: 'BBBBBB',
            applicationObject: 'BBBBBB',
            customerDefaultFlag: 'BBBBBB',
            channelDefaultFlag: 'BBBBBB',
            serviceUrl: 'BBBBBB',
            backOfficeUrl: 'BBBBBB',
            packageId: 1,
            meesevaServiceActiveFlag: 'BBBBBB',
            meesevaServiceGroupId: 1,
            meesevaServiceSubGroupId: 1,
            meesevaServiceTypeId: 1,
            meesevaServiceSubTypeId: 1,
            departmentCode: 'BBBBBB',
            efmsDepartmentCode: 'BBBBBB',
            isOnline: 'BBBBBB',
            agencyType: 1,
            launchDate: currentDate.format(DATE_TIME_FORMAT),
            isMobile: 'BBBBBB',
            innerSubId: 1,
            digilockerEnabled: 'BBBBBB',
            isRegular: 'BBBBBB',
            isSeasonal: 'BBBBBB',
            citizenPortalLaunchDate: currentDate.format(DATE_TIME_FORMAT),
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
            launchDate: currentDate,
            citizenPortalLaunchDate: currentDate,
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

      it('should return a list of MdmMeesevaServiceMaster', () => {
        const returnedFromService = Object.assign(
          {
            meesevaServiceId: 1,
            meesevaServiceName: 'BBBBBB',
            isCharged: 'BBBBBB',
            organizationEntityTypeCode: 'BBBBBB',
            applicationTable: 'BBBBBB',
            applicationObject: 'BBBBBB',
            customerDefaultFlag: 'BBBBBB',
            channelDefaultFlag: 'BBBBBB',
            serviceUrl: 'BBBBBB',
            backOfficeUrl: 'BBBBBB',
            packageId: 1,
            meesevaServiceActiveFlag: 'BBBBBB',
            meesevaServiceGroupId: 1,
            meesevaServiceSubGroupId: 1,
            meesevaServiceTypeId: 1,
            meesevaServiceSubTypeId: 1,
            departmentCode: 'BBBBBB',
            efmsDepartmentCode: 'BBBBBB',
            isOnline: 'BBBBBB',
            agencyType: 1,
            launchDate: currentDate.format(DATE_TIME_FORMAT),
            isMobile: 'BBBBBB',
            innerSubId: 1,
            digilockerEnabled: 'BBBBBB',
            isRegular: 'BBBBBB',
            isSeasonal: 'BBBBBB',
            citizenPortalLaunchDate: currentDate.format(DATE_TIME_FORMAT),
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
            launchDate: currentDate,
            citizenPortalLaunchDate: currentDate,
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

      it('should delete a MdmMeesevaServiceMaster', () => {
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
