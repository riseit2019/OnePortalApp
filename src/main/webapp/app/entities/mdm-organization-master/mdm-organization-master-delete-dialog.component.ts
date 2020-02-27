import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IMdmOrganizationMaster } from 'app/shared/model/mdm-organization-master.model';
import { MdmOrganizationMasterService } from './mdm-organization-master.service';

@Component({
  templateUrl: './mdm-organization-master-delete-dialog.component.html'
})
export class MdmOrganizationMasterDeleteDialogComponent {
  mdmOrganizationMaster?: IMdmOrganizationMaster;

  constructor(
    protected mdmOrganizationMasterService: MdmOrganizationMasterService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.mdmOrganizationMasterService.delete(id).subscribe(() => {
      this.eventManager.broadcast('mdmOrganizationMasterListModification');
      this.activeModal.close();
    });
  }
}
