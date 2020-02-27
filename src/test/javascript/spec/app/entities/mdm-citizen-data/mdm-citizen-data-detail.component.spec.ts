import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmCitizenDataDetailComponent } from 'app/entities/mdm-citizen-data/mdm-citizen-data-detail.component';
import { MdmCitizenData } from 'app/shared/model/mdm-citizen-data.model';

describe('Component Tests', () => {
  describe('MdmCitizenData Management Detail Component', () => {
    let comp: MdmCitizenDataDetailComponent;
    let fixture: ComponentFixture<MdmCitizenDataDetailComponent>;
    const route = ({ data: of({ mdmCitizenData: new MdmCitizenData(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmCitizenDataDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(MdmCitizenDataDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(MdmCitizenDataDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load mdmCitizenData on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.mdmCitizenData).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
