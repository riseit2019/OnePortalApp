import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { MdmEmpRoleMasterService } from 'app/entities/mdm-emp-role-master/mdm-emp-role-master.service';
import { IMdmEmpRoleMaster, MdmEmpRoleMaster } from 'app/shared/model/mdm-emp-role-master.model';

describe('Service Tests', () => {
  describe('MdmEmpRoleMaster Service', () => {
    let injector: TestBed;
    let service: MdmEmpRoleMasterService;
    let httpMock: HttpTestingController;
    let elemDefault: IMdmEmpRoleMaster;
    let expectedResult: IMdmEmpRoleMaster | IMdmEmpRoleMaster[] | boolean | null;
    let currentDate: moment.Moment;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(MdmEmpRoleMasterService);
      httpMock = injector.get(HttpTestingController);
      currentDate = moment();

      elemDefault = new MdmEmpRoleMaster(
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
        0,
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        currentDate,
        currentDate,
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

      it('should create a MdmEmpRoleMaster', () => {
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

        service.create(new MdmEmpRoleMaster()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a MdmEmpRoleMaster', () => {
        const returnedFromService = Object.assign(
          {
            employeeCode: 'BBBBBB',
            employeeName: 'BBBBBB',
            roleCode: 'BBBBBB',
            roleName: 'BBBBBB',
            officeCode: 'BBBBBB',
            officeName: 'BBBBBB',
            personId: 'BBBBBB',
            organizationCode: 'BBBBBB',
            organizationName: 'BBBBBB',
            stateCode: 'BBBBBB',
            stateName: 'BBBBBB',
            districtCode: 'BBBBBB',
            districtName: 'BBBBBB',
            mandalCode: 'BBBBBB',
            mandalName: 'BBBBBB',
            villageCode: 'BBBBBB',
            villageName: 'BBBBBB',
            circleName: 'BBBBBB',
            divisionName: 'BBBBBB',
            subDivisionName: 'BBBBBB',
            sectionName: 'BBBBBB',
            activeStatusFlag: 1,
            createdBy: 'BBBBBB',
            updatedBy: 'BBBBBB',
            recordInsertTime: currentDate.format(DATE_TIME_FORMAT),
            createTime: currentDate.format(DATE_TIME_FORMAT),
            updateTime: currentDate.format(DATE_TIME_FORMAT),
            volunteerSecretariatRole: 'BBBBBB'
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

      it('should return a list of MdmEmpRoleMaster', () => {
        const returnedFromService = Object.assign(
          {
            employeeCode: 'BBBBBB',
            employeeName: 'BBBBBB',
            roleCode: 'BBBBBB',
            roleName: 'BBBBBB',
            officeCode: 'BBBBBB',
            officeName: 'BBBBBB',
            personId: 'BBBBBB',
            organizationCode: 'BBBBBB',
            organizationName: 'BBBBBB',
            stateCode: 'BBBBBB',
            stateName: 'BBBBBB',
            districtCode: 'BBBBBB',
            districtName: 'BBBBBB',
            mandalCode: 'BBBBBB',
            mandalName: 'BBBBBB',
            villageCode: 'BBBBBB',
            villageName: 'BBBBBB',
            circleName: 'BBBBBB',
            divisionName: 'BBBBBB',
            subDivisionName: 'BBBBBB',
            sectionName: 'BBBBBB',
            activeStatusFlag: 1,
            createdBy: 'BBBBBB',
            updatedBy: 'BBBBBB',
            recordInsertTime: currentDate.format(DATE_TIME_FORMAT),
            createTime: currentDate.format(DATE_TIME_FORMAT),
            updateTime: currentDate.format(DATE_TIME_FORMAT),
            volunteerSecretariatRole: 'BBBBBB'
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

      it('should delete a MdmEmpRoleMaster', () => {
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
