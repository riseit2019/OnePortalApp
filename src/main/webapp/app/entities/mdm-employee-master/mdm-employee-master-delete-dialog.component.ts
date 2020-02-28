import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IMdmEmployeeMaster } from 'app/shared/model/mdm-employee-master.model';
import { MdmEmployeeMasterService } from './mdm-employee-master.service';

@Component({
  templateUrl: './mdm-employee-master-delete-dialog.component.html'
})
export class MdmEmployeeMasterDeleteDialogComponent {
  mdmEmployeeMaster?: IMdmEmployeeMaster;

  constructor(
    protected mdmEmployeeMasterService: MdmEmployeeMasterService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.mdmEmployeeMasterService.delete(id).subscribe(() => {
      this.eventManager.broadcast('mdmEmployeeMasterListModification');
      this.activeModal.close();
    });
  }
}
