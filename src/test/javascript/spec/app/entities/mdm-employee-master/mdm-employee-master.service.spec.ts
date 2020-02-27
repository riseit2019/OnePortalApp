import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { MdmEmployeeMasterService } from 'app/entities/mdm-employee-master/mdm-employee-master.service';
import { IMdmEmployeeMaster, MdmEmployeeMaster } from 'app/shared/model/mdm-employee-master.model';

describe('Service Tests', () => {
  describe('MdmEmployeeMaster Service', () => {
    let injector: TestBed;
    let service: MdmEmployeeMasterService;
    let httpMock: HttpTestingController;
    let elemDefault: IMdmEmployeeMaster;
    let expectedResult: IMdmEmployeeMaster | IMdmEmployeeMaster[] | boolean | null;
    let currentDate: moment.Moment;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(MdmEmployeeMasterService);
      httpMock = injector.get(HttpTestingController);
      currentDate = moment();

      elemDefault = new MdmEmployeeMaster(
        0,
        0,
        'AAAAAAA',
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
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        currentDate,
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA',
        0
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

      it('should create a MdmEmployeeMaster', () => {
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

        service.create(new MdmEmployeeMaster()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a MdmEmployeeMaster', () => {
        const returnedFromService = Object.assign(
          {
            syspk: 1,
            employeeCode: 'BBBBBB',
            tempRefId: 1,
            employeeId: 1,
            employeeName: 'BBBBBB',
            entityName: 'BBBBBB',
            organizationName: 'BBBBBB',
            designationId: 'BBBBBB',
            designationName: 'BBBBBB',
            postName: 'BBBBBB',
            organizationUnitName: 'BBBBBB',
            parentOrganizationUnit: 'BBBBBB',
            mobileNumber: 1,
            emailId: 'BBBBBB',
            addressType: 'BBBBBB',
            address1: 'BBBBBB',
            address2: 'BBBBBB',
            cityName: 'BBBBBB',
            postOffice: 'BBBBBB',
            isPrimary: 'BBBBBB',
            isOuHead: 'BBBBBB',
            districtCode: 'BBBBBB',
            districtName: 'BBBBBB',
            mandalCode: 'BBBBBB',
            mandalName: 'BBBBBB',
            villageCode: 'BBBBBB',
            villageName: 'BBBBBB',
            panchayatCode: 'BBBBBB',
            panchayatName: 'BBBBBB',
            constituencyCode: 1,
            constituencyName: 'BBBBBB',
            createdBy: 'BBBBBB',
            updatedBy: 'BBBBBB',
            recordInsertTime: currentDate.format(DATE_TIME_FORMAT),
            createTime: currentDate.format(DATE_TIME_FORMAT),
            updateTime: currentDate.format(DATE_TIME_FORMAT),
            employeeType: 'BBBBBB',
            managerEmployeeCode: 'BBBBBB',
            employeeActiveStatus: 'BBBBBB',
            personId1: 'BBBBBB',
            aadhaarRefId: 1,
            volunteerSecretariatId: 'BBBBBB',
            volunteerSecretariatFlag: 'BBBBBB',
            aadhaarNumber: 1
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

      it('should return a list of MdmEmployeeMaster', () => {
        const returnedFromService = Object.assign(
          {
            syspk: 1,
            employeeCode: 'BBBBBB',
            tempRefId: 1,
            employeeId: 1,
            employeeName: 'BBBBBB',
            entityName: 'BBBBBB',
            organizationName: 'BBBBBB',
            designationId: 'BBBBBB',
            designationName: 'BBBBBB',
            postName: 'BBBBBB',
            organizationUnitName: 'BBBBBB',
            parentOrganizationUnit: 'BBBBBB',
            mobileNumber: 1,
            emailId: 'BBBBBB',
            addressType: 'BBBBBB',
            address1: 'BBBBBB',
            address2: 'BBBBBB',
            cityName: 'BBBBBB',
            postOffice: 'BBBBBB',
            isPrimary: 'BBBBBB',
            isOuHead: 'BBBBBB',
            districtCode: 'BBBBBB',
            districtName: 'BBBBBB',
            mandalCode: 'BBBBBB',
            mandalName: 'BBBBBB',
            villageCode: 'BBBBBB',
            villageName: 'BBBBBB',
            panchayatCode: 'BBBBBB',
            panchayatName: 'BBBBBB',
            constituencyCode: 1,
            constituencyName: 'BBBBBB',
            createdBy: 'BBBBBB',
            updatedBy: 'BBBBBB',
            recordInsertTime: currentDate.format(DATE_TIME_FORMAT),
            createTime: currentDate.format(DATE_TIME_FORMAT),
            updateTime: currentDate.format(DATE_TIME_FORMAT),
            employeeType: 'BBBBBB',
            managerEmployeeCode: 'BBBBBB',
            employeeActiveStatus: 'BBBBBB',
            personId1: 'BBBBBB',
            aadhaarRefId: 1,
            volunteerSecretariatId: 'BBBBBB',
            volunteerSecretariatFlag: 'BBBBBB',
            aadhaarNumber: 1
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

      it('should delete a MdmEmployeeMaster', () => {
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
