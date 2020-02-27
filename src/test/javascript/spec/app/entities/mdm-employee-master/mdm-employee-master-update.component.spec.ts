import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmEmployeeMasterUpdateComponent } from 'app/entities/mdm-employee-master/mdm-employee-master-update.component';
import { MdmEmployeeMasterService } from 'app/entities/mdm-employee-master/mdm-employee-master.service';
import { MdmEmployeeMaster } from 'app/shared/model/mdm-employee-master.model';

describe('Component Tests', () => {
  describe('MdmEmployeeMaster Management Update Component', () => {
    let comp: MdmEmployeeMasterUpdateComponent;
    let fixture: ComponentFixture<MdmEmployeeMasterUpdateComponent>;
    let service: MdmEmployeeMasterService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmEmployeeMasterUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(MdmEmployeeMasterUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(MdmEmployeeMasterUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(MdmEmployeeMasterService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new MdmEmployeeMaster(123);
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
        const entity = new MdmEmployeeMaster();
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
