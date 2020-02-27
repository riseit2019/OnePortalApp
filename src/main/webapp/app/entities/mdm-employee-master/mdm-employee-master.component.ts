import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IMdmEmployeeMaster } from 'app/shared/model/mdm-employee-master.model';
import { MdmEmployeeMasterService } from './mdm-employee-master.service';
import { MdmEmployeeMasterDeleteDialogComponent } from './mdm-employee-master-delete-dialog.component';

@Component({
  selector: 'jhi-mdm-employee-master',
  templateUrl: './mdm-employee-master.component.html'
})
export class MdmEmployeeMasterComponent implements OnInit, OnDestroy {
  mdmEmployeeMasters?: IMdmEmployeeMaster[];
  eventSubscriber?: Subscription;

  constructor(
    protected mdmEmployeeMasterService: MdmEmployeeMasterService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.mdmEmployeeMasterService
      .query()
      .subscribe((res: HttpResponse<IMdmEmployeeMaster[]>) => (this.mdmEmployeeMasters = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInMdmEmployeeMasters();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IMdmEmployeeMaster): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInMdmEmployeeMasters(): void {
    this.eventSubscriber = this.eventManager.subscribe('mdmEmployeeMasterListModification', () => this.loadAll());
  }

  delete(mdmEmployeeMaster: IMdmEmployeeMaster): void {
    const modalRef = this.modalService.open(MdmEmployeeMasterDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.mdmEmployeeMaster = mdmEmployeeMaster;
  }
}
