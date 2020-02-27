import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmEmployeeMasterComponent } from 'app/entities/mdm-employee-master/mdm-employee-master.component';
import { MdmEmployeeMasterService } from 'app/entities/mdm-employee-master/mdm-employee-master.service';
import { MdmEmployeeMaster } from 'app/shared/model/mdm-employee-master.model';

describe('Component Tests', () => {
  describe('MdmEmployeeMaster Management Component', () => {
    let comp: MdmEmployeeMasterComponent;
    let fixture: ComponentFixture<MdmEmployeeMasterComponent>;
    let service: MdmEmployeeMasterService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmEmployeeMasterComponent]
      })
        .overrideTemplate(MdmEmployeeMasterComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(MdmEmployeeMasterComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(MdmEmployeeMasterService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new MdmEmployeeMaster(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.mdmEmployeeMasters && comp.mdmEmployeeMasters[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
