import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IMdmServiceMaster } from 'app/shared/model/mdm-service-master.model';
import { MdmServiceMasterService } from './mdm-service-master.service';
import { MdmServiceMasterDeleteDialogComponent } from './mdm-service-master-delete-dialog.component';

@Component({
  selector: 'jhi-mdm-service-master',
  templateUrl: './mdm-service-master.component.html'
})
export class MdmServiceMasterComponent implements OnInit, OnDestroy {
  mdmServiceMasters?: IMdmServiceMaster[];
  eventSubscriber?: Subscription;

  constructor(
    protected mdmServiceMasterService: MdmServiceMasterService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.mdmServiceMasterService.query().subscribe((res: HttpResponse<IMdmServiceMaster[]>) => (this.mdmServiceMasters = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInMdmServiceMasters();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IMdmServiceMaster): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInMdmServiceMasters(): void {
    this.eventSubscriber = this.eventManager.subscribe('mdmServiceMasterListModification', () => this.loadAll());
  }

  delete(mdmServiceMaster: IMdmServiceMaster): void {
    const modalRef = this.modalService.open(MdmServiceMasterDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.mdmServiceMaster = mdmServiceMaster;
  }
}
