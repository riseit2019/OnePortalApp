import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IMdmRoleActivityMaster } from 'app/shared/model/mdm-role-activity-master.model';
import { MdmRoleActivityMasterService } from './mdm-role-activity-master.service';
import { MdmRoleActivityMasterDeleteDialogComponent } from './mdm-role-activity-master-delete-dialog.component';

@Component({
  selector: 'jhi-mdm-role-activity-master',
  templateUrl: './mdm-role-activity-master.component.html'
})
export class MdmRoleActivityMasterComponent implements OnInit, OnDestroy {
  mdmRoleActivityMasters?: IMdmRoleActivityMaster[];
  eventSubscriber?: Subscription;

  constructor(
    protected mdmRoleActivityMasterService: MdmRoleActivityMasterService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.mdmRoleActivityMasterService
      .query()
      .subscribe((res: HttpResponse<IMdmRoleActivityMaster[]>) => (this.mdmRoleActivityMasters = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInMdmRoleActivityMasters();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IMdmRoleActivityMaster): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInMdmRoleActivityMasters(): void {
    this.eventSubscriber = this.eventManager.subscribe('mdmRoleActivityMasterListModification', () => this.loadAll());
  }

  delete(mdmRoleActivityMaster: IMdmRoleActivityMaster): void {
    const modalRef = this.modalService.open(MdmRoleActivityMasterDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.mdmRoleActivityMaster = mdmRoleActivityMaster;
  }
}
