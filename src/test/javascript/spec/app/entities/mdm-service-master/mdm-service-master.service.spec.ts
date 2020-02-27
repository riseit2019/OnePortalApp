import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { MdmServiceMasterService } from 'app/entities/mdm-service-master/mdm-service-master.service';
import { IMdmServiceMaster, MdmServiceMaster } from 'app/shared/model/mdm-service-master.model';

describe('Service Tests', () => {
  describe('MdmServiceMaster Service', () => {
    let injector: TestBed;
    let service: MdmServiceMasterService;
    let httpMock: HttpTestingController;
    let elemDefault: IMdmServiceMaster;
    let expectedResult: IMdmServiceMaster | IMdmServiceMaster[] | boolean | null;
    let currentDate: moment.Moment;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(MdmServiceMasterService);
      httpMock = injector.get(HttpTestingController);
      currentDate = moment();

      elemDefault = new MdmServiceMaster(
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA',
        0,
        'AAAAAAA',
        0,
        'AAAAAAA',
        0,
        0,
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        currentDate,
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        0,
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
        'AAAAAAA',
        0,
        'AAAAAAA',
        0,
        'AAAAAAA',
        0,
        'AAAAAAA',
        0,
        'AAAAAAA'
      );
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign(
          {
            servicePeriodStartDate: currentDate.format(DATE_TIME_FORMAT),
            servicePeriodEndDate: currentDate.format(DATE_TIME_FORMAT),
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

      it('should create a MdmServiceMaster', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            servicePeriodStartDate: currentDate.format(DATE_TIME_FORMAT),
            servicePeriodEndDate: currentDate.format(DATE_TIME_FORMAT),
            recordInsertTime: currentDate.format(DATE_TIME_FORMAT),
            createTime: currentDate.format(DATE_TIME_FORMAT),
            updateTime: currentDate.format(DATE_TIME_FORMAT)
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            servicePeriodStartDate: currentDate,
            servicePeriodEndDate: currentDate,
            recordInsertTime: currentDate,
            createTime: currentDate,
            updateTime: currentDate
          },
          returnedFromService
        );

        service.create(new MdmServiceMaster()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a MdmServiceMaster', () => {
        const returnedFromService = Object.assign(
          {
            serviceCode: 'BBBBBB',
            organizationName: 'BBBBBB',
            serviceShortName: 'BBBBBB',
            serviceName: 'BBBBBB',
            serviceDesc: 'BBBBBB',
            parentServiceCode: 'BBBBBB',
            servicePeriodStartDate: currentDate.format(DATE_TIME_FORMAT),
            servicePeriodEndDate: currentDate.format(DATE_TIME_FORMAT),
            serviceCategory: 'BBBBBB',
            serviceLink: 'BBBBBB',
            serviceClass: 'BBBBBB',
            serviceIntegrationType: 'BBBBBB',
            serviceType: 'BBBBBB',
            lookupRoleId: 1,
            lookupRole: 'BBBBBB',
            lookupSectorId: 1,
            lookupSector: 'BBBBBB',
            lookupLifeeventId: 1,
            lookupLifeevent: 'BBBBBB',
            slaGoal: 1,
            serviceActiveFlag: 1,
            createdBy: 'BBBBBB',
            updatedBy: 'BBBBBB',
            recordInsertTime: currentDate.format(DATE_TIME_FORMAT),
            createTime: currentDate.format(DATE_TIME_FORMAT),
            updateTime: currentDate.format(DATE_TIME_FORMAT),
            sectionDisplayName: 'BBBBBB',
            sectionDisplayIcon: 'BBBBBB',
            rulesetName: 'BBBBBB',
            servicePriority: 1,
            serviceChannelAccess: 'BBBBBB',
            serviceAccess: 'BBBBBB',
            assistedmodeekycReq: 'BBBBBB',
            assistedOthAdrReq: 'BBBBBB',
            slaDeadline: 1,
            paymentChannelId: 1,
            paymentReturnClass: 'BBBBBB',
            paymentReturnRuleset: 'BBBBBB',
            paymentReturnurl: 'BBBBBB',
            helpLink: 'BBBBBB',
            intermediateScreen: 'BBBBBB',
            aadhaarRequired: 'BBBBBB',
            meesevaServiceId: 1,
            meesevaServiceName: 'BBBBBB',
            pmtFeeAmtTotal: 1,
            pmtFeeAmtOthers1: 1,
            pmtFeeAmtOthers1Desc: 'BBBBBB',
            pmtFeeAmtOthers2: 1,
            pmtFeeAmtOthers2Desc: 'BBBBBB',
            pmtFeeAmtOthers3: 1,
            pmtFeeAmtOthers3Desc: 'BBBBBB',
            pmtFeeAmtOthers4: 1,
            pmtFeeAmtOthers4Desc: 'BBBBBB',
            pmtFeeAmtOthers5: 1,
            pmtFeeAmtOthers5Desc: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            servicePeriodStartDate: currentDate,
            servicePeriodEndDate: currentDate,
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

      it('should return a list of MdmServiceMaster', () => {
        const returnedFromService = Object.assign(
          {
            serviceCode: 'BBBBBB',
            organizationName: 'BBBBBB',
            serviceShortName: 'BBBBBB',
            serviceName: 'BBBBBB',
            serviceDesc: 'BBBBBB',
            parentServiceCode: 'BBBBBB',
            servicePeriodStartDate: currentDate.format(DATE_TIME_FORMAT),
            servicePeriodEndDate: currentDate.format(DATE_TIME_FORMAT),
            serviceCategory: 'BBBBBB',
            serviceLink: 'BBBBBB',
            serviceClass: 'BBBBBB',
            serviceIntegrationType: 'BBBBBB',
            serviceType: 'BBBBBB',
            lookupRoleId: 1,
            lookupRole: 'BBBBBB',
            lookupSectorId: 1,
            lookupSector: 'BBBBBB',
            lookupLifeeventId: 1,
            lookupLifeevent: 'BBBBBB',
            slaGoal: 1,
            serviceActiveFlag: 1,
            createdBy: 'BBBBBB',
            updatedBy: 'BBBBBB',
            recordInsertTime: currentDate.format(DATE_TIME_FORMAT),
            createTime: currentDate.format(DATE_TIME_FORMAT),
            updateTime: currentDate.format(DATE_TIME_FORMAT),
            sectionDisplayName: 'BBBBBB',
            sectionDisplayIcon: 'BBBBBB',
            rulesetName: 'BBBBBB',
            servicePriority: 1,
            serviceChannelAccess: 'BBBBBB',
            serviceAccess: 'BBBBBB',
            assistedmodeekycReq: 'BBBBBB',
            assistedOthAdrReq: 'BBBBBB',
            slaDeadline: 1,
            paymentChannelId: 1,
            paymentReturnClass: 'BBBBBB',
            paymentReturnRuleset: 'BBBBBB',
            paymentReturnurl: 'BBBBBB',
            helpLink: 'BBBBBB',
            intermediateScreen: 'BBBBBB',
            aadhaarRequired: 'BBBBBB',
            meesevaServiceId: 1,
            meesevaServiceName: 'BBBBBB',
            pmtFeeAmtTotal: 1,
            pmtFeeAmtOthers1: 1,
            pmtFeeAmtOthers1Desc: 'BBBBBB',
            pmtFeeAmtOthers2: 1,
            pmtFeeAmtOthers2Desc: 'BBBBBB',
            pmtFeeAmtOthers3: 1,
            pmtFeeAmtOthers3Desc: 'BBBBBB',
            pmtFeeAmtOthers4: 1,
            pmtFeeAmtOthers4Desc: 'BBBBBB',
            pmtFeeAmtOthers5: 1,
            pmtFeeAmtOthers5Desc: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            servicePeriodStartDate: currentDate,
            servicePeriodEndDate: currentDate,
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

      it('should delete a MdmServiceMaster', () => {
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
