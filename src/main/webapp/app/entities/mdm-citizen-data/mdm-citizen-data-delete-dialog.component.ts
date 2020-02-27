import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IMdmCitizenData } from 'app/shared/model/mdm-citizen-data.model';
import { MdmCitizenDataService } from './mdm-citizen-data.service';

@Component({
  templateUrl: './mdm-citizen-data-delete-dialog.component.html'
})
export class MdmCitizenDataDeleteDialogComponent {
  mdmCitizenData?: IMdmCitizenData;

  constructor(
    protected mdmCitizenDataService: MdmCitizenDataService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.mdmCitizenDataService.delete(id).subscribe(() => {
      this.eventManager.broadcast('mdmCitizenDataListModification');
      this.activeModal.close();
    });
  }
}
