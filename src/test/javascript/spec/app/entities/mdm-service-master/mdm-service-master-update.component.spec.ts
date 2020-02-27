import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmServiceMasterUpdateComponent } from 'app/entities/mdm-service-master/mdm-service-master-update.component';
import { MdmServiceMasterService } from 'app/entities/mdm-service-master/mdm-service-master.service';
import { MdmServiceMaster } from 'app/shared/model/mdm-service-master.model';

describe('Component Tests', () => {
  describe('MdmServiceMaster Management Update Component', () => {
    let comp: MdmServiceMasterUpdateComponent;
    let fixture: ComponentFixture<MdmServiceMasterUpdateComponent>;
    let service: MdmServiceMasterService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmServiceMasterUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(MdmServiceMasterUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(MdmServiceMasterUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(MdmServiceMasterService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new MdmServiceMaster(123);
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
        const entity = new MdmServiceMaster();
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
