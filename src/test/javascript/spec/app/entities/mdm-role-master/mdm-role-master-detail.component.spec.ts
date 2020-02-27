import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmRoleMasterDetailComponent } from 'app/entities/mdm-role-master/mdm-role-master-detail.component';
import { MdmRoleMaster } from 'app/shared/model/mdm-role-master.model';

describe('Component Tests', () => {
  describe('MdmRoleMaster Management Detail Component', () => {
    let comp: MdmRoleMasterDetailComponent;
    let fixture: ComponentFixture<MdmRoleMasterDetailComponent>;
    const route = ({ data: of({ mdmRoleMaster: new MdmRoleMaster(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmRoleMasterDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(MdmRoleMasterDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(MdmRoleMasterDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load mdmRoleMaster on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.mdmRoleMaster).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
