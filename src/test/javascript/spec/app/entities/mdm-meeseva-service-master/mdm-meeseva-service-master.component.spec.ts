import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmMeesevaServiceMasterComponent } from 'app/entities/mdm-meeseva-service-master/mdm-meeseva-service-master.component';
import { MdmMeesevaServiceMasterService } from 'app/entities/mdm-meeseva-service-master/mdm-meeseva-service-master.service';
import { MdmMeesevaServiceMaster } from 'app/shared/model/mdm-meeseva-service-master.model';

describe('Component Tests', () => {
  describe('MdmMeesevaServiceMaster Management Component', () => {
    let comp: MdmMeesevaServiceMasterComponent;
    let fixture: ComponentFixture<MdmMeesevaServiceMasterComponent>;
    let service: MdmMeesevaServiceMasterService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmMeesevaServiceMasterComponent]
      })
        .overrideTemplate(MdmMeesevaServiceMasterComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(MdmMeesevaServiceMasterComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(MdmMeesevaServiceMasterService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new MdmMeesevaServiceMaster(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.mdmMeesevaServiceMasters && comp.mdmMeesevaServiceMasters[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
