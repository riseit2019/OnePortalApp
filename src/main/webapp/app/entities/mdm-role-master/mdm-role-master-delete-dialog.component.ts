import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IMdmRoleMaster } from 'app/shared/model/mdm-role-master.model';
import { MdmRoleMasterService } from './mdm-role-master.service';

@Component({
  templateUrl: './mdm-role-master-delete-dialog.component.html'
})
export class MdmRoleMasterDeleteDialogComponent {
  mdmRoleMaster?: IMdmRoleMaster;

  constructor(
    protected mdmRoleMasterService: MdmRoleMasterService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.mdmRoleMasterService.delete(id).subscribe(() => {
      this.eventManager.broadcast('mdmRoleMasterListModification');
      this.activeModal.close();
    });
  }
}
