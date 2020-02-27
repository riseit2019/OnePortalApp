import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmServiceMasterDetailComponent } from 'app/entities/mdm-service-master/mdm-service-master-detail.component';
import { MdmServiceMaster } from 'app/shared/model/mdm-service-master.model';

describe('Component Tests', () => {
  describe('MdmServiceMaster Management Detail Component', () => {
    let comp: MdmServiceMasterDetailComponent;
    let fixture: ComponentFixture<MdmServiceMasterDetailComponent>;
    const route = ({ data: of({ mdmServiceMaster: new MdmServiceMaster(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmServiceMasterDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(MdmServiceMasterDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(MdmServiceMasterDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load mdmServiceMaster on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.mdmServiceMaster).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
