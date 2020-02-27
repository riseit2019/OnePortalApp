import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { OnePortalAppTestModule } from '../../../test.module';
import { MockEventManager } from '../../../helpers/mock-event-manager.service';
import { MockActiveModal } from '../../../helpers/mock-active-modal.service';
import { MdmEmpRoleMasterDeleteDialogComponent } from 'app/entities/mdm-emp-role-master/mdm-emp-role-master-delete-dialog.component';
import { MdmEmpRoleMasterService } from 'app/entities/mdm-emp-role-master/mdm-emp-role-master.service';

describe('Component Tests', () => {
  describe('MdmEmpRoleMaster Management Delete Component', () => {
    let comp: MdmEmpRoleMasterDeleteDialogComponent;
    let fixture: ComponentFixture<MdmEmpRoleMasterDeleteDialogComponent>;
    let service: MdmEmpRoleMasterService;
    let mockEventManager: MockEventManager;
    let mockActiveModal: MockActiveModal;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmEmpRoleMasterDeleteDialogComponent]
      })
        .overrideTemplate(MdmEmpRoleMasterDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(MdmEmpRoleMasterDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(MdmEmpRoleMasterService);
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
