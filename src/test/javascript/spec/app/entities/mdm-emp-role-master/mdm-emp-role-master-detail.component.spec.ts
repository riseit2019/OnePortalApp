import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmEmpRoleMasterDetailComponent } from 'app/entities/mdm-emp-role-master/mdm-emp-role-master-detail.component';
import { MdmEmpRoleMaster } from 'app/shared/model/mdm-emp-role-master.model';

describe('Component Tests', () => {
  describe('MdmEmpRoleMaster Management Detail Component', () => {
    let comp: MdmEmpRoleMasterDetailComponent;
    let fixture: ComponentFixture<MdmEmpRoleMasterDetailComponent>;
    const route = ({ data: of({ mdmEmpRoleMaster: new MdmEmpRoleMaster(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmEmpRoleMasterDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(MdmEmpRoleMasterDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(MdmEmpRoleMasterDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load mdmEmpRoleMaster on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.mdmEmpRoleMaster).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
