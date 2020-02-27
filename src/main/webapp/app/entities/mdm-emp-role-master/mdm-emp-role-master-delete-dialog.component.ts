import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IMdmEmpRoleMaster } from 'app/shared/model/mdm-emp-role-master.model';
import { MdmEmpRoleMasterService } from './mdm-emp-role-master.service';

@Component({
  templateUrl: './mdm-emp-role-master-delete-dialog.component.html'
})
export class MdmEmpRoleMasterDeleteDialogComponent {
  mdmEmpRoleMaster?: IMdmEmpRoleMaster;

  constructor(
    protected mdmEmpRoleMasterService: MdmEmpRoleMasterService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.mdmEmpRoleMasterService.delete(id).subscribe(() => {
      this.eventManager.broadcast('mdmEmpRoleMasterListModification');
      this.activeModal.close();
    });
  }
}
