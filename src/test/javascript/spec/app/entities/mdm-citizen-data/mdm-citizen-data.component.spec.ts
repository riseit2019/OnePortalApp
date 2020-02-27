import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmCitizenDataComponent } from 'app/entities/mdm-citizen-data/mdm-citizen-data.component';
import { MdmCitizenDataService } from 'app/entities/mdm-citizen-data/mdm-citizen-data.service';
import { MdmCitizenData } from 'app/shared/model/mdm-citizen-data.model';

describe('Component Tests', () => {
  describe('MdmCitizenData Management Component', () => {
    let comp: MdmCitizenDataComponent;
    let fixture: ComponentFixture<MdmCitizenDataComponent>;
    let service: MdmCitizenDataService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmCitizenDataComponent]
      })
        .overrideTemplate(MdmCitizenDataComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(MdmCitizenDataComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(MdmCitizenDataService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new MdmCitizenData(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.mdmCitizenData && comp.mdmCitizenData[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
