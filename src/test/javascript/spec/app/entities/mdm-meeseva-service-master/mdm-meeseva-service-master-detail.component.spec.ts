import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmMeesevaServiceMasterDetailComponent } from 'app/entities/mdm-meeseva-service-master/mdm-meeseva-service-master-detail.component';
import { MdmMeesevaServiceMaster } from 'app/shared/model/mdm-meeseva-service-master.model';

describe('Component Tests', () => {
  describe('MdmMeesevaServiceMaster Management Detail Component', () => {
    let comp: MdmMeesevaServiceMasterDetailComponent;
    let fixture: ComponentFixture<MdmMeesevaServiceMasterDetailComponent>;
    const route = ({ data: of({ mdmMeesevaServiceMaster: new MdmMeesevaServiceMaster(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmMeesevaServiceMasterDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(MdmMeesevaServiceMasterDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(MdmMeesevaServiceMasterDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load mdmMeesevaServiceMaster on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.mdmMeesevaServiceMaster).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
