import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmRoleActivityMasterComponent } from 'app/entities/mdm-role-activity-master/mdm-role-activity-master.component';
import { MdmRoleActivityMasterService } from 'app/entities/mdm-role-activity-master/mdm-role-activity-master.service';
import { MdmRoleActivityMaster } from 'app/shared/model/mdm-role-activity-master.model';

describe('Component Tests', () => {
  describe('MdmRoleActivityMaster Management Component', () => {
    let comp: MdmRoleActivityMasterComponent;
    let fixture: ComponentFixture<MdmRoleActivityMasterComponent>;
    let service: MdmRoleActivityMasterService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmRoleActivityMasterComponent]
      })
        .overrideTemplate(MdmRoleActivityMasterComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(MdmRoleActivityMasterComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(MdmRoleActivityMasterService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new MdmRoleActivityMaster(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.mdmRoleActivityMasters && comp.mdmRoleActivityMasters[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
