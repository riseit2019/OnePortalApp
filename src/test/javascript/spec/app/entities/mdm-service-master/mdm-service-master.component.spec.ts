import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmServiceMasterComponent } from 'app/entities/mdm-service-master/mdm-service-master.component';
import { MdmServiceMasterService } from 'app/entities/mdm-service-master/mdm-service-master.service';
import { MdmServiceMaster } from 'app/shared/model/mdm-service-master.model';

describe('Component Tests', () => {
  describe('MdmServiceMaster Management Component', () => {
    let comp: MdmServiceMasterComponent;
    let fixture: ComponentFixture<MdmServiceMasterComponent>;
    let service: MdmServiceMasterService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmServiceMasterComponent]
      })
        .overrideTemplate(MdmServiceMasterComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(MdmServiceMasterComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(MdmServiceMasterService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new MdmServiceMaster(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.mdmServiceMasters && comp.mdmServiceMasters[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
