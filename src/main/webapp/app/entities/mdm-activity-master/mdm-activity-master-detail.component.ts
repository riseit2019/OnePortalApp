import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IMdmActivityMaster } from 'app/shared/model/mdm-activity-master.model';

@Component({
  selector: 'jhi-mdm-activity-master-detail',
  templateUrl: './mdm-activity-master-detail.component.html'
})
export class MdmActivityMasterDetailComponent implements OnInit {
  mdmActivityMaster: IMdmActivityMaster | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ mdmActivityMaster }) => (this.mdmActivityMaster = mdmActivityMaster));
  }

  previousState(): void {
    window.history.back();
  }
}
