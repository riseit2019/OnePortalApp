import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import * as moment from 'moment';
import { DATE_FORMAT, DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { MdmCitizenDataService } from 'app/entities/mdm-citizen-data/mdm-citizen-data.service';
import { IMdmCitizenData, MdmCitizenData } from 'app/shared/model/mdm-citizen-data.model';

describe('Service Tests', () => {
  describe('MdmCitizenData Service', () => {
    let injector: TestBed;
    let service: MdmCitizenDataService;
    let httpMock: HttpTestingController;
    let elemDefault: IMdmCitizenData;
    let expectedResult: IMdmCitizenData | IMdmCitizenData[] | boolean | null;
    let currentDate: moment.Moment;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(MdmCitizenDataService);
      httpMock = injector.get(HttpTestingController);
      currentDate = moment();

      elemDefault = new MdmCitizenData(
        0,
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA',
        0,
        currentDate,
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
        0,
        'AAAAAAA',
        0,
        'AAAAAAA',
        0,
        'AAAAAAA',
        0,
        'AAAAAAA',
        0,
        'AAAAAAA',
        0,
        'AAAAAAA',
        0,
        'AAAAAAA',
        0,
        'AAAAAAA',
        0,
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        currentDate,
        currentDate,
        'AAAAAAA',
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA'
      );
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign(
          {
            dateOfBirth: currentDate.format(DATE_FORMAT),
            recordInsertTime: currentDate.format(DATE_TIME_FORMAT),
            createTime: currentDate.format(DATE_TIME_FORMAT),
            updateTime: currentDate.format(DATE_TIME_FORMAT),
            aadhaarVerifiedDate: currentDate.format(DATE_TIME_FORMAT)
          },
          elemDefault
        );

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a MdmCitizenData', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            dateOfBirth: currentDate.format(DATE_FORMAT),
            recordInsertTime: currentDate.format(DATE_TIME_FORMAT),
            createTime: currentDate.format(DATE_TIME_FORMAT),
            updateTime: currentDate.format(DATE_TIME_FORMAT),
            aadhaarVerifiedDate: currentDate.format(DATE_TIME_FORMAT)
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            dateOfBirth: currentDate,
            recordInsertTime: currentDate,
            createTime: currentDate,
            updateTime: currentDate,
            aadhaarVerifiedDate: currentDate
          },
          returnedFromService
        );

        service.create(new MdmCitizenData()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a MdmCitizenData', () => {
        const returnedFromService = Object.assign(
          {
            personId: 'BBBBBB',
            tempRefId: 1,
            name: 'BBBBBB',
            emailId: 'BBBBBB',
            mobileNumber: 1,
            dateOfBirth: currentDate.format(DATE_FORMAT),
            genderId: 1,
            gender: 'BBBBBB',
            houseNumberAdh: 'BBBBBB',
            streetAdh: 'BBBBBB',
            villageAdh: 'BBBBBB',
            districtNameAh: 'BBBBBB',
            subDistrictNameAdh: 'BBBBBB',
            postOfficeAdh: 'BBBBBB',
            stateNameAdh: 'BBBBBB',
            pinCodeAdh: 'BBBBBB',
            districtCodePss: 1,
            districtNamePss: 'BBBBBB',
            districtCode: 'BBBBBB',
            mandalCode: 'BBBBBB',
            villageCode: 'BBBBBB',
            districtName: 'BBBBBB',
            mandalName: 'BBBBBB',
            villageName: 'BBBBBB',
            houseHoldId: 'BBBBBB',
            relationshipWithHoh: 'BBBBBB',
            buildingNamePss: 'BBBBBB',
            houseNameWardNoDivPss: 'BBBBBB',
            areaWardColonyStreetPss: 'BBBBBB',
            villageTownPss: 'BBBBBB',
            pinCodePss: 'BBBBBB',
            religionId: 1,
            religion: 'BBBBBB',
            casteId: 1,
            caste: 'BBBBBB',
            subCasteId: 1,
            subCaste: 'BBBBBB',
            motherTongueId: 1,
            motherTongue: 'BBBBBB',
            householdOwnershipId: 1,
            householdOwnership: 'BBBBBB',
            educationId: 1,
            education: 'BBBBBB',
            occupationId: 1,
            occupation: 'BBBBBB',
            occupationCategoryId: 1,
            occupationCategory: 'BBBBBB',
            martialStatusId: 1,
            martialStatus: 'BBBBBB',
            physicalhandicappedTypeId: 1,
            physicalhandicappedStatus: 'BBBBBB',
            physicalhandicappedPercentage: 1,
            votersCardNo: 'BBBBBB',
            kissanCardAvailable: 'BBBBBB',
            annualIncome: 'BBBBBB',
            rationId: 'BBBBBB',
            createdBy: 'BBBBBB',
            updatedBy: 'BBBBBB',
            recordInsertTime: currentDate.format(DATE_TIME_FORMAT),
            createTime: currentDate.format(DATE_TIME_FORMAT),
            updateTime: currentDate.format(DATE_TIME_FORMAT),
            aadhaarVerified: 'BBBBBB',
            aadhaarVerifiedDate: currentDate.format(DATE_TIME_FORMAT),
            emailVerified: 'BBBBBB',
            phoneNoVerified: 'BBBBBB',
            citizenActiveStatus: 'BBBBBB',
            sourceOfRegistrationId: 1,
            sourceOfRegistration: 'BBBBBB',
            ssoId: 'BBBBBB',
            operatorId: 'BBBBBB',
            aadhaarRefId: 1,
            careOfAdh: 'BBBBBB',
            assistedModeOperatorId: 'BBBBBB',
            uidReferenceKeyAponline: 1,
            uidToken: 'BBBBBB',
            volunteerSecretariatEmailId: 'BBBBBB',
            volunteerSecretariatMobile: 1,
            volunteerSecretariatId: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            dateOfBirth: currentDate,
            recordInsertTime: currentDate,
            createTime: currentDate,
            updateTime: currentDate,
            aadhaarVerifiedDate: currentDate
          },
          returnedFromService
        );

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of MdmCitizenData', () => {
        const returnedFromService = Object.assign(
          {
            personId: 'BBBBBB',
            tempRefId: 1,
            name: 'BBBBBB',
            emailId: 'BBBBBB',
            mobileNumber: 1,
            dateOfBirth: currentDate.format(DATE_FORMAT),
            genderId: 1,
            gender: 'BBBBBB',
            houseNumberAdh: 'BBBBBB',
            streetAdh: 'BBBBBB',
            villageAdh: 'BBBBBB',
            districtNameAh: 'BBBBBB',
            subDistrictNameAdh: 'BBBBBB',
            postOfficeAdh: 'BBBBBB',
            stateNameAdh: 'BBBBBB',
            pinCodeAdh: 'BBBBBB',
            districtCodePss: 1,
            districtNamePss: 'BBBBBB',
            districtCode: 'BBBBBB',
            mandalCode: 'BBBBBB',
            villageCode: 'BBBBBB',
            districtName: 'BBBBBB',
            mandalName: 'BBBBBB',
            villageName: 'BBBBBB',
            houseHoldId: 'BBBBBB',
            relationshipWithHoh: 'BBBBBB',
            buildingNamePss: 'BBBBBB',
            houseNameWardNoDivPss: 'BBBBBB',
            areaWardColonyStreetPss: 'BBBBBB',
            villageTownPss: 'BBBBBB',
            pinCodePss: 'BBBBBB',
            religionId: 1,
            religion: 'BBBBBB',
            casteId: 1,
            caste: 'BBBBBB',
            subCasteId: 1,
            subCaste: 'BBBBBB',
            motherTongueId: 1,
            motherTongue: 'BBBBBB',
            householdOwnershipId: 1,
            householdOwnership: 'BBBBBB',
            educationId: 1,
            education: 'BBBBBB',
            occupationId: 1,
            occupation: 'BBBBBB',
            occupationCategoryId: 1,
            occupationCategory: 'BBBBBB',
            martialStatusId: 1,
            martialStatus: 'BBBBBB',
            physicalhandicappedTypeId: 1,
            physicalhandicappedStatus: 'BBBBBB',
            physicalhandicappedPercentage: 1,
            votersCardNo: 'BBBBBB',
            kissanCardAvailable: 'BBBBBB',
            annualIncome: 'BBBBBB',
            rationId: 'BBBBBB',
            createdBy: 'BBBBBB',
            updatedBy: 'BBBBBB',
            recordInsertTime: currentDate.format(DATE_TIME_FORMAT),
            createTime: currentDate.format(DATE_TIME_FORMAT),
            updateTime: currentDate.format(DATE_TIME_FORMAT),
            aadhaarVerified: 'BBBBBB',
            aadhaarVerifiedDate: currentDate.format(DATE_TIME_FORMAT),
            emailVerified: 'BBBBBB',
            phoneNoVerified: 'BBBBBB',
            citizenActiveStatus: 'BBBBBB',
            sourceOfRegistrationId: 1,
            sourceOfRegistration: 'BBBBBB',
            ssoId: 'BBBBBB',
            operatorId: 'BBBBBB',
            aadhaarRefId: 1,
            careOfAdh: 'BBBBBB',
            assistedModeOperatorId: 'BBBBBB',
            uidReferenceKeyAponline: 1,
            uidToken: 'BBBBBB',
            volunteerSecretariatEmailId: 'BBBBBB',
            volunteerSecretariatMobile: 1,
            volunteerSecretariatId: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            dateOfBirth: currentDate,
            recordInsertTime: currentDate,
            createTime: currentDate,
            updateTime: currentDate,
            aadhaarVerifiedDate: currentDate
          },
          returnedFromService
        );

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a MdmCitizenData', () => {
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
