import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { OnePortalAppTestModule } from '../../../test.module';
import { MockEventManager } from '../../../helpers/mock-event-manager.service';
import { MockActiveModal } from '../../../helpers/mock-active-modal.service';
import { MdmEmployeeMasterDeleteDialogComponent } from 'app/entities/mdm-employee-master/mdm-employee-master-delete-dialog.component';
import { MdmEmployeeMasterService } from 'app/entities/mdm-employee-master/mdm-employee-master.service';

describe('Component Tests', () => {
  describe('MdmEmployeeMaster Management Delete Component', () => {
    let comp: MdmEmployeeMasterDeleteDialogComponent;
    let fixture: ComponentFixture<MdmEmployeeMasterDeleteDialogComponent>;
    let service: MdmEmployeeMasterService;
    let mockEventManager: MockEventManager;
    let mockActiveModal: MockActiveModal;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmEmployeeMasterDeleteDialogComponent]
      })
        .overrideTemplate(MdmEmployeeMasterDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(MdmEmployeeMasterDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(MdmEmployeeMasterService);
      mockEventManager = TestBed.get(JhiEventManager);
      mockActiveModal = TestBed.get(NgbActiveModal);
    });

    describe('confirmDelete', () => {
      it('Should call delete service on confirmDelete', inject(
        [],
        fakeAsync(() => {
          // GIVEN
          spyOn(service, 'delete').and.returnValue(of({}));

          // WHEN
          comp.confirmDelete(123);
          tick();

          // THEN
          expect(service.delete).toHaveBeenCalledWith(123);
          expect(mockActiveModal.closeSpy).toHaveBeenCalled();
          expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
        })
      ));

      it('Should not call delete service on clear', () => {
        // GIVEN
        spyOn(service, 'delete');

        // WHEN
        comp.cancel();

        // THEN
        expect(service.delete).not.toHaveBeenCalled();
        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
      });
    });
  });
});
