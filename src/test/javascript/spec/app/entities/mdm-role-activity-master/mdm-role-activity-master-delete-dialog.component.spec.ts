import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { OnePortalAppTestModule } from '../../../test.module';
import { MockEventManager } from '../../../helpers/mock-event-manager.service';
import { MockActiveModal } from '../../../helpers/mock-active-modal.service';
import { MdmRoleActivityMasterDeleteDialogComponent } from 'app/entities/mdm-role-activity-master/mdm-role-activity-master-delete-dialog.component';
import { MdmRoleActivityMasterService } from 'app/entities/mdm-role-activity-master/mdm-role-activity-master.service';

describe('Component Tests', () => {
  describe('MdmRoleActivityMaster Management Delete Component', () => {
    let comp: MdmRoleActivityMasterDeleteDialogComponent;
    let fixture: ComponentFixture<MdmRoleActivityMasterDeleteDialogComponent>;
    let service: MdmRoleActivityMasterService;
    let mockEventManager: MockEventManager;
    let mockActiveModal: MockActiveModal;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OnePortalAppTestModule],
        declarations: [MdmRoleActivityMasterDeleteDialogComponent]
      })
        .overrideTemplate(MdmRoleActivityMasterDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(MdmRoleActivityMasterDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(MdmRoleActivityMasterService);
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
