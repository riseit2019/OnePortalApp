import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmRoleMasterComponent } from 'app/entities/mdm-role-master/mdm-role-master.component';
import { MdmRoleMasterService } from 'app/entities/mdm-role-master/mdm-role-master.service';
import { MdmRoleMaster } from 'app/shared/model/mdm-role-master.model';

describe('Component Tests', () => {
  describe('MdmRoleMaster Management Component', () => {
    let comp: MdmRoleMasterComponent;
    let fixture: ComponentFixture<MdmRoleMasterComponent>;
    let service: MdmRoleMasterService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmRoleMasterComponent]
      })
        .overrideTemplate(MdmRoleMasterComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(MdmRoleMasterComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(MdmRoleMasterService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new MdmRoleMaster(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.mdmRoleMasters && comp.mdmRoleMasters[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
