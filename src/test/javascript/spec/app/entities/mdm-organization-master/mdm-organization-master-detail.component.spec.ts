import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmOrganizationMasterDetailComponent } from 'app/entities/mdm-organization-master/mdm-organization-master-detail.component';
import { MdmOrganizationMaster } from 'app/shared/model/mdm-organization-master.model';

describe('Component Tests', () => {
  describe('MdmOrganizationMaster Management Detail Component', () => {
    let comp: MdmOrganizationMasterDetailComponent;
    let fixture: ComponentFixture<MdmOrganizationMasterDetailComponent>;
    const route = ({ data: of({ mdmOrganizationMaster: new MdmOrganizationMaster(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmOrganizationMasterDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(MdmOrganizationMasterDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(MdmOrganizationMasterDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load mdmOrganizationMaster on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.mdmOrganizationMaster).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
