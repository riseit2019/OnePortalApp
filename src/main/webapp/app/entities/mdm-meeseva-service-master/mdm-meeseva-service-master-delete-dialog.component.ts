import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IMdmMeesevaServiceMaster } from 'app/shared/model/mdm-meeseva-service-master.model';
import { MdmMeesevaServiceMasterService } from './mdm-meeseva-service-master.service';

@Component({
  templateUrl: './mdm-meeseva-service-master-delete-dialog.component.html'
})
export class MdmMeesevaServiceMasterDeleteDialogComponent {
  mdmMeesevaServiceMaster?: IMdmMeesevaServiceMaster;

  constructor(
    protected mdmMeesevaServiceMasterService: MdmMeesevaServiceMasterService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.mdmMeesevaServiceMasterService.delete(id).subscribe(() => {
      this.eventManager.broadcast('mdmMeesevaServiceMasterListModification');
      this.activeModal.close();
    });
  }
}
