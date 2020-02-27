import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmActivityMasterDetailComponent } from 'app/entities/mdm-activity-master/mdm-activity-master-detail.component';
import { MdmActivityMaster } from 'app/shared/model/mdm-activity-master.model';

describe('Component Tests', () => {
  describe('MdmActivityMaster Management Detail Component', () => {
    let comp: MdmActivityMasterDetailComponent;
    let fixture: ComponentFixture<MdmActivityMasterDetailComponent>;
    const route = ({ data: of({ mdmActivityMaster: new MdmActivityMaster(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmActivityMasterDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(MdmActivityMasterDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(MdmActivityMasterDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load mdmActivityMaster on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.mdmActivityMaster).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
