import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IMdmRoleMaster } from 'app/shared/model/mdm-role-master.model';

@Component({
  selector: 'jhi-mdm-role-master-detail',
  templateUrl: './mdm-role-master-detail.component.html'
})
export class MdmRoleMasterDetailComponent implements OnInit {
  mdmRoleMaster: IMdmRoleMaster | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ mdmRoleMaster }) => (this.mdmRoleMaster = mdmRoleMaster));
  }

  previousState(): void {
    window.history.back();
  }
}
