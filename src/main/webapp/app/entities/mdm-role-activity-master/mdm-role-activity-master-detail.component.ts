import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IMdmRoleActivityMaster } from 'app/shared/model/mdm-role-activity-master.model';

@Component({
  selector: 'jhi-mdm-role-activity-master-detail',
  templateUrl: './mdm-role-activity-master-detail.component.html'
})
export class MdmRoleActivityMasterDetailComponent implements OnInit {
  mdmRoleActivityMaster: IMdmRoleActivityMaster | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ mdmRoleActivityMaster }) => (this.mdmRoleActivityMaster = mdmRoleActivityMaster));
  }

  previousState(): void {
    window.history.back();
  }
}
