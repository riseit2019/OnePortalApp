import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IMdmServiceMaster } from 'app/shared/model/mdm-service-master.model';

@Component({
  selector: 'jhi-mdm-service-master-detail',
  templateUrl: './mdm-service-master-detail.component.html'
})
export class MdmServiceMasterDetailComponent implements OnInit {
  mdmServiceMaster: IMdmServiceMaster | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ mdmServiceMaster }) => (this.mdmServiceMaster = mdmServiceMaster));
  }

  previousState(): void {
    window.history.back();
  }
}
