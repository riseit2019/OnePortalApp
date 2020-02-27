import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmActivityMasterUpdateComponent } from 'app/entities/mdm-activity-master/mdm-activity-master-update.component';
import { MdmActivityMasterService } from 'app/entities/mdm-activity-master/mdm-activity-master.service';
import { MdmActivityMaster } from 'app/shared/model/mdm-activity-master.model';

describe('Component Tests', () => {
  describe('MdmActivityMaster Management Update Component', () => {
    let comp: MdmActivityMasterUpdateComponent;
    let fixture: ComponentFixture<MdmActivityMasterUpdateComponent>;
    let service: MdmActivityMasterService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmActivityMasterUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(MdmActivityMasterUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(MdmActivityMasterUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(MdmActivityMasterService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new MdmActivityMaster(123);
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
        const entity = new MdmActivityMaster();
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
