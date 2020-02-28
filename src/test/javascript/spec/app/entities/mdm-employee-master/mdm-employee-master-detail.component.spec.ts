import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmEmployeeMasterDetailComponent } from 'app/entities/mdm-employee-master/mdm-employee-master-detail.component';
import { MdmEmployeeMaster } from 'app/shared/model/mdm-employee-master.model';

describe('Component Tests', () => {
  describe('MdmEmployeeMaster Management Detail Component', () => {
    let comp: MdmEmployeeMasterDetailComponent;
    let fixture: ComponentFixture<MdmEmployeeMasterDetailComponent>;
    const route = ({ data: of({ mdmEmployeeMaster: new MdmEmployeeMaster(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmEmployeeMasterDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(MdmEmployeeMasterDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(MdmEmployeeMasterDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load mdmEmployeeMaster on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.mdmEmployeeMaster).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
