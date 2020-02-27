import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IMdmRoleActivityMaster } from 'app/shared/model/mdm-role-activity-master.model';
import { MdmRoleActivityMasterService } from './mdm-role-activity-master.service';

@Component({
  templateUrl: './mdm-role-activity-master-delete-dialog.component.html'
})
export class MdmRoleActivityMasterDeleteDialogComponent {
  mdmRoleActivityMaster?: IMdmRoleActivityMaster;

  constructor(
    protected mdmRoleActivityMasterService: MdmRoleActivityMasterService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.mdmRoleActivityMasterService.delete(id).subscribe(() => {
      this.eventManager.broadcast('mdmRoleActivityMasterListModification');
      this.activeModal.close();
    });
  }
}
