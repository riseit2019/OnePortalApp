import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmEmpRoleMasterUpdateComponent } from 'app/entities/mdm-emp-role-master/mdm-emp-role-master-update.component';
import { MdmEmpRoleMasterService } from 'app/entities/mdm-emp-role-master/mdm-emp-role-master.service';
import { MdmEmpRoleMaster } from 'app/shared/model/mdm-emp-role-master.model';

describe('Component Tests', () => {
  describe('MdmEmpRoleMaster Management Update Component', () => {
    let comp: MdmEmpRoleMasterUpdateComponent;
    let fixture: ComponentFixture<MdmEmpRoleMasterUpdateComponent>;
    let service: MdmEmpRoleMasterService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmEmpRoleMasterUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(MdmEmpRoleMasterUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(MdmEmpRoleMasterUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(MdmEmpRoleMasterService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new MdmEmpRoleMaster(123);
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
        const entity = new MdmEmpRoleMaster();
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
