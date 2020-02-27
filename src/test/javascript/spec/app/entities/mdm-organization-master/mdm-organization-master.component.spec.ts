import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmOrganizationMasterComponent } from 'app/entities/mdm-organization-master/mdm-organization-master.component';
import { MdmOrganizationMasterService } from 'app/entities/mdm-organization-master/mdm-organization-master.service';
import { MdmOrganizationMaster } from 'app/shared/model/mdm-organization-master.model';

describe('Component Tests', () => {
  describe('MdmOrganizationMaster Management Component', () => {
    let comp: MdmOrganizationMasterComponent;
    let fixture: ComponentFixture<MdmOrganizationMasterComponent>;
    let service: MdmOrganizationMasterService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmOrganizationMasterComponent]
      })
        .overrideTemplate(MdmOrganizationMasterComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(MdmOrganizationMasterComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(MdmOrganizationMasterService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new MdmOrganizationMaster(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.mdmOrganizationMasters && comp.mdmOrganizationMasters[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
