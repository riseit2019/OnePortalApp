import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmRoleMasterUpdateComponent } from 'app/entities/mdm-role-master/mdm-role-master-update.component';
import { MdmRoleMasterService } from 'app/entities/mdm-role-master/mdm-role-master.service';
import { MdmRoleMaster } from 'app/shared/model/mdm-role-master.model';

describe('Component Tests', () => {
  describe('MdmRoleMaster Management Update Component', () => {
    let comp: MdmRoleMasterUpdateComponent;
    let fixture: ComponentFixture<MdmRoleMasterUpdateComponent>;
    let service: MdmRoleMasterService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmRoleMasterUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(MdmRoleMasterUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(MdmRoleMasterUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(MdmRoleMasterService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new MdmRoleMaster(123);
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
        const entity = new MdmRoleMaster();
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
