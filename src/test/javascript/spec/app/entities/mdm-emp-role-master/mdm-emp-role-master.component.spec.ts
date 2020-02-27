import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmEmpRoleMasterComponent } from 'app/entities/mdm-emp-role-master/mdm-emp-role-master.component';
import { MdmEmpRoleMasterService } from 'app/entities/mdm-emp-role-master/mdm-emp-role-master.service';
import { MdmEmpRoleMaster } from 'app/shared/model/mdm-emp-role-master.model';

describe('Component Tests', () => {
  describe('MdmEmpRoleMaster Management Component', () => {
    let comp: MdmEmpRoleMasterComponent;
    let fixture: ComponentFixture<MdmEmpRoleMasterComponent>;
    let service: MdmEmpRoleMasterService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmEmpRoleMasterComponent]
      })
        .overrideTemplate(MdmEmpRoleMasterComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(MdmEmpRoleMasterComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(MdmEmpRoleMasterService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new MdmEmpRoleMaster(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.mdmEmpRoleMasters && comp.mdmEmpRoleMasters[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
