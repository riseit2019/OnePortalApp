import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmRoleActivityMasterDetailComponent } from 'app/entities/mdm-role-activity-master/mdm-role-activity-master-detail.component';
import { MdmRoleActivityMaster } from 'app/shared/model/mdm-role-activity-master.model';

describe('Component Tests', () => {
  describe('MdmRoleActivityMaster Management Detail Component', () => {
    let comp: MdmRoleActivityMasterDetailComponent;
    let fixture: ComponentFixture<MdmRoleActivityMasterDetailComponent>;
    const route = ({ data: of({ mdmRoleActivityMaster: new MdmRoleActivityMaster(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmRoleActivityMasterDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(MdmRoleActivityMasterDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(MdmRoleActivityMasterDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load mdmRoleActivityMaster on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.mdmRoleActivityMaster).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
