import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmMeesevaServiceMasterUpdateComponent } from 'app/entities/mdm-meeseva-service-master/mdm-meeseva-service-master-update.component';
import { MdmMeesevaServiceMasterService } from 'app/entities/mdm-meeseva-service-master/mdm-meeseva-service-master.service';
import { MdmMeesevaServiceMaster } from 'app/shared/model/mdm-meeseva-service-master.model';

describe('Component Tests', () => {
  describe('MdmMeesevaServiceMaster Management Update Component', () => {
    let comp: MdmMeesevaServiceMasterUpdateComponent;
    let fixture: ComponentFixture<MdmMeesevaServiceMasterUpdateComponent>;
    let service: MdmMeesevaServiceMasterService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmMeesevaServiceMasterUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(MdmMeesevaServiceMasterUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(MdmMeesevaServiceMasterUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(MdmMeesevaServiceMasterService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new MdmMeesevaServiceMaster(123);
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
        const entity = new MdmMeesevaServiceMaster();
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
