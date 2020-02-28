import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IMdmServiceMaster } from 'app/shared/model/mdm-service-master.model';
import { MdmServiceMasterService } from './mdm-service-master.service';

@Component({
  templateUrl: './mdm-service-master-delete-dialog.component.html'
})
export class MdmServiceMasterDeleteDialogComponent {
  mdmServiceMaster?: IMdmServiceMaster;

  constructor(
    protected mdmServiceMasterService: MdmServiceMasterService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.mdmServiceMasterService.delete(id).subscribe(() => {
      this.eventManager.broadcast('mdmServiceMasterListModification');
      this.activeModal.close();
    });
  }
}
