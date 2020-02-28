import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmActivityMasterComponent } from 'app/entities/mdm-activity-master/mdm-activity-master.component';
import { MdmActivityMasterService } from 'app/entities/mdm-activity-master/mdm-activity-master.service';
import { MdmActivityMaster } from 'app/shared/model/mdm-activity-master.model';

describe('Component Tests', () => {
  describe('MdmActivityMaster Management Component', () => {
    let comp: MdmActivityMasterComponent;
    let fixture: ComponentFixture<MdmActivityMasterComponent>;
    let service: MdmActivityMasterService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmActivityMasterComponent]
      })
        .overrideTemplate(MdmActivityMasterComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(MdmActivityMasterComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(MdmActivityMasterService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new MdmActivityMaster(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.mdmActivityMasters && comp.mdmActivityMasters[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
