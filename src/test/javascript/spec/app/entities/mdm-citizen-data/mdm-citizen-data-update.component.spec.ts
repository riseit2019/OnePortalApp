import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { OnePortalAppTestModule } from '../../../test.module';
import { MdmCitizenDataUpdateComponent } from 'app/entities/mdm-citizen-data/mdm-citizen-data-update.component';
import { MdmCitizenDataService } from 'app/entities/mdm-citizen-data/mdm-citizen-data.service';
import { MdmCitizenData } from 'app/shared/model/mdm-citizen-data.model';

describe('Component Tests', () => {
  describe('MdmCitizenData Management Update Component', () => {
    let comp: MdmCitizenDataUpdateComponent;
    let fixture: ComponentFixture<MdmCitizenDataUpdateComponent>;
    let service: MdmCitizenDataService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmCitizenDataUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(MdmCitizenDataUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(MdmCitizenDataUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(MdmCitizenDataService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new MdmCitizenData(123);
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
        const entity = new MdmCitizenData();
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
