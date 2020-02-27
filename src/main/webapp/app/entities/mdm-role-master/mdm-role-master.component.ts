import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IMdmRoleMaster } from 'app/shared/model/mdm-role-master.model';
import { MdmRoleMasterService } from './mdm-role-master.service';
import { MdmRoleMasterDeleteDialogComponent } from './mdm-role-master-delete-dialog.component';

@Component({
  selector: 'jhi-mdm-role-master',
  templateUrl: './mdm-role-master.component.html'
})
export class MdmRoleMasterComponent implements OnInit, OnDestroy {
  mdmRoleMasters?: IMdmRoleMaster[];
  eventSubscriber?: Subscription;

  constructor(
    protected mdmRoleMasterService: MdmRoleMasterService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.mdmRoleMasterService.query().subscribe((res: HttpResponse<IMdmRoleMaster[]>) => (this.mdmRoleMasters = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInMdmRoleMasters();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IMdmRoleMaster): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInMdmRoleMasters(): void {
    this.eventSubscriber = this.eventManager.subscribe('mdmRoleMasterListModification', () => this.loadAll());
  }

  delete(mdmRoleMaster: IMdmRoleMaster): void {
    const modalRef = this.modalService.open(MdmRoleMasterDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.mdmRoleMaster = mdmRoleMaster;
  }
}
