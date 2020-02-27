import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IMdmActivityMaster } from 'app/shared/model/mdm-activity-master.model';
import { MdmActivityMasterService } from './mdm-activity-master.service';
import { MdmActivityMasterDeleteDialogComponent } from './mdm-activity-master-delete-dialog.component';

@Component({
  selector: 'jhi-mdm-activity-master',
  templateUrl: './mdm-activity-master.component.html'
})
export class MdmActivityMasterComponent implements OnInit, OnDestroy {
  mdmActivityMasters?: IMdmActivityMaster[];
  eventSubscriber?: Subscription;

  constructor(
    protected mdmActivityMasterService: MdmActivityMasterService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.mdmActivityMasterService
      .query()
      .subscribe((res: HttpResponse<IMdmActivityMaster[]>) => (this.mdmActivityMasters = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInMdmActivityMasters();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IMdmActivityMaster): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInMdmActivityMasters(): void {
    this.eventSubscriber = this.eventManager.subscribe('mdmActivityMasterListModification', () => this.loadAll());
  }

  delete(mdmActivityMaster: IMdmActivityMaster): void {
    const modalRef = this.modalService.open(MdmActivityMasterDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.mdmActivityMaster = mdmActivityMaster;
  }
}
