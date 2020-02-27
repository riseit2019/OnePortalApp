import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IMdmOrganizationMaster } from 'app/shared/model/mdm-organization-master.model';
import { MdmOrganizationMasterService } from './mdm-organization-master.service';
import { MdmOrganizationMasterDeleteDialogComponent } from './mdm-organization-master-delete-dialog.component';

@Component({
  selector: 'jhi-mdm-organization-master',
  templateUrl: './mdm-organization-master.component.html'
})
export class MdmOrganizationMasterComponent implements OnInit, OnDestroy {
  mdmOrganizationMasters?: IMdmOrganizationMaster[];
  eventSubscriber?: Subscription;

  constructor(
    protected mdmOrganizationMasterService: MdmOrganizationMasterService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.mdmOrganizationMasterService
      .query()
      .subscribe((res: HttpResponse<IMdmOrganizationMaster[]>) => (this.mdmOrganizationMasters = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInMdmOrganizationMasters();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IMdmOrganizationMaster): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInMdmOrganizationMasters(): void {
    this.eventSubscriber = this.eventManager.subscribe('mdmOrganizationMasterListModification', () => this.loadAll());
  }

  delete(mdmOrganizationMaster: IMdmOrganizationMaster): void {
    const modalRef = this.modalService.open(MdmOrganizationMasterDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.mdmOrganizationMaster = mdmOrganizationMaster;
  }
}
