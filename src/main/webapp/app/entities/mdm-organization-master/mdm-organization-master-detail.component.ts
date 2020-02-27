import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IMdmOrganizationMaster } from 'app/shared/model/mdm-organization-master.model';

@Component({
  selector: 'jhi-mdm-organization-master-detail',
  templateUrl: './mdm-organization-master-detail.component.html'
})
export class MdmOrganizationMasterDetailComponent implements OnInit {
  mdmOrganizationMaster: IMdmOrganizationMaster | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ mdmOrganizationMaster }) => (this.mdmOrganizationMaster = mdmOrganizationMaster));
  }

  previousState(): void {
    window.history.back();
  }
}
