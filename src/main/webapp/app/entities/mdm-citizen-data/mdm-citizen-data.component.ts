import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IMdmCitizenData } from 'app/shared/model/mdm-citizen-data.model';
import { MdmCitizenDataService } from './mdm-citizen-data.service';
import { MdmCitizenDataDeleteDialogComponent } from './mdm-citizen-data-delete-dialog.component';

@Component({
  selector: 'jhi-mdm-citizen-data',
  templateUrl: './mdm-citizen-data.component.html'
})
export class MdmCitizenDataComponent implements OnInit, OnDestroy {
  mdmCitizenData?: IMdmCitizenData[];
  eventSubscriber?: Subscription;

  constructor(
    protected mdmCitizenDataService: MdmCitizenDataService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.mdmCitizenDataService.query().subscribe((res: HttpResponse<IMdmCitizenData[]>) => (this.mdmCitizenData = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInMdmCitizenData();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IMdmCitizenData): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInMdmCitizenData(): void {
    this.eventSubscriber = this.eventManager.subscribe('mdmCitizenDataListModification', () => this.loadAll());
  }

  delete(mdmCitizenData: IMdmCitizenData): void {
    const modalRef = this.modalService.open(MdmCitizenDataDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.mdmCitizenData = mdmCitizenData;
  }
}
