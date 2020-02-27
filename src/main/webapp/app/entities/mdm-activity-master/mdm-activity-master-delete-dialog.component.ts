import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IMdmActivityMaster } from 'app/shared/model/mdm-activity-master.model';
import { MdmActivityMasterService } from './mdm-activity-master.service';

@Component({
  templateUrl: './mdm-activity-master-delete-dialog.component.html'
})
export class MdmActivityMasterDeleteDialogComponent {
  mdmActivityMaster?: IMdmActivityMaster;

  constructor(
    protected mdmActivityMasterService: MdmActivityMasterService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.mdmActivityMasterService.delete(id).subscribe(() => {
      this.eventManager.broadcast('mdmActivityMasterListModification');
      this.activeModal.close();
    });
  }
}
