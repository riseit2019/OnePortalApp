import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmRoleActivityMasterUpdateComponent } from 'app/entities/mdm-role-activity-master/mdm-role-activity-master-update.component';
import { MdmRoleActivityMasterService } from 'app/entities/mdm-role-activity-master/mdm-role-activity-master.service';
import { MdmRoleActivityMaster } from 'app/shared/model/mdm-role-activity-master.model';

describe('Component Tests', () => {
  describe('MdmRoleActivityMaster Management Update Component', () => {
    let comp: MdmRoleActivityMasterUpdateComponent;
    let fixture: ComponentFixture<MdmRoleActivityMasterUpdateComponent>;
    let service: MdmRoleActivityMasterService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmRoleActivityMasterUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(MdmRoleActivityMasterUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(MdmRoleActivityMasterUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(MdmRoleActivityMasterService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new MdmRoleActivityMaster(123);
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
        const entity = new MdmRoleActivityMaster();
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
