import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IMdmMeesevaServiceMaster } from 'app/shared/model/mdm-meeseva-service-master.model';
import { MdmMeesevaServiceMasterService } from './mdm-meeseva-service-master.service';
import { MdmMeesevaServiceMasterDeleteDialogComponent } from './mdm-meeseva-service-master-delete-dialog.component';

@Component({
  selector: 'jhi-mdm-meeseva-service-master',
  templateUrl: './mdm-meeseva-service-master.component.html'
})
export class MdmMeesevaServiceMasterComponent implements OnInit, OnDestroy {
  mdmMeesevaServiceMasters?: IMdmMeesevaServiceMaster[];
  eventSubscriber?: Subscription;

  constructor(
    protected mdmMeesevaServiceMasterService: MdmMeesevaServiceMasterService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.mdmMeesevaServiceMasterService
      .query()
      .subscribe((res: HttpResponse<IMdmMeesevaServiceMaster[]>) => (this.mdmMeesevaServiceMasters = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInMdmMeesevaServiceMasters();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IMdmMeesevaServiceMaster): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInMdmMeesevaServiceMasters(): void {
    this.eventSubscriber = this.eventManager.subscribe('mdmMeesevaServiceMasterListModification', () => this.loadAll());
  }

  delete(mdmMeesevaServiceMaster: IMdmMeesevaServiceMaster): void {
    const modalRef = this.modalService.open(MdmMeesevaServiceMasterDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.mdmMeesevaServiceMaster = mdmMeesevaServiceMaster;
  }
}
