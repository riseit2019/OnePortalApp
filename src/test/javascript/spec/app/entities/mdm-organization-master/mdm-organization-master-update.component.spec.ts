import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmOrganizationMasterUpdateComponent } from 'app/entities/mdm-organization-master/mdm-organization-master-update.component';
import { MdmOrganizationMasterService } from 'app/entities/mdm-organization-master/mdm-organization-master.service';
import { MdmOrganizationMaster } from 'app/shared/model/mdm-organization-master.model';

describe('Component Tests', () => {
  describe('MdmOrganizationMaster Management Update Component', () => {
    let comp: MdmOrganizationMasterUpdateComponent;
    let fixture: ComponentFixture<MdmOrganizationMasterUpdateComponent>;
    let service: MdmOrganizationMasterService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmOrganizationMasterUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(MdmOrganizationMasterUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(MdmOrganizationMasterUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(MdmOrganizationMasterService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new MdmOrganizationMaster(123);
        spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.update).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));

      it('Should call create service on save for new entity', fakeAsync(() => {
        // GIVEN
        const entity = new MdmOrganizationMaster();
        spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.create).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));
    });
  });
});
