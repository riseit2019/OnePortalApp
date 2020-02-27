import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IMdmEmpRoleMaster } from 'app/shared/model/mdm-emp-role-master.model';

@Component({
  selector: 'jhi-mdm-emp-role-master-detail',
  templateUrl: './mdm-emp-role-master-detail.component.html'
})
export class MdmEmpRoleMasterDetailComponent implements OnInit {
  mdmEmpRoleMaster: IMdmEmpRoleMaster | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ mdmEmpRoleMaster }) => (this.mdmEmpRoleMaster = mdmEmpRoleMaster));
  }

  previousState(): void {
    window.history.back();
  }
}
