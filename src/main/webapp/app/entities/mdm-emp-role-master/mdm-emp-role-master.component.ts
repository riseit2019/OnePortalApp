import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IMdmEmpRoleMaster } from 'app/shared/model/mdm-emp-role-master.model';
import { MdmEmpRoleMasterService } from './mdm-emp-role-master.service';
import { MdmEmpRoleMasterDeleteDialogComponent } from './mdm-emp-role-master-delete-dialog.component';

@Component({
  selector: 'jhi-mdm-emp-role-master',
  templateUrl: './mdm-emp-role-master.component.html'
})
export class MdmEmpRoleMasterComponent implements OnInit, OnDestroy {
  mdmEmpRoleMasters?: IMdmEmpRoleMaster[];
  eventSubscriber?: Subscription;

  constructor(
    protected mdmEmpRoleMasterService: MdmEmpRoleMasterService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.mdmEmpRoleMasterService.query().subscribe((res: HttpResponse<IMdmEmpRoleMaster[]>) => (this.mdmEmpRoleMasters = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInMdmEmpRoleMasters();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IMdmEmpRoleMaster): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInMdmEmpRoleMasters(): void {
    this.eventSubscriber = this.eventManager.subscribe('mdmEmpRoleMasterListModification', () => this.loadAll());
  }

  delete(mdmEmpRoleMaster: IMdmEmpRoleMaster): void {
    const modalRef = this.modalService.open(MdmEmpRoleMasterDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.mdmEmpRoleMaster = mdmEmpRoleMaster;
  }
}
