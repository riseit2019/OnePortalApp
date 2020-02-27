import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IMdmEmployeeMaster } from 'app/shared/model/mdm-employee-master.model';

@Component({
  selector: 'jhi-mdm-employee-master-detail',
  templateUrl: './mdm-employee-master-detail.component.html'
})
export class MdmEmployeeMasterDetailComponent implements OnInit {
  mdmEmployeeMaster: IMdmEmployeeMaster | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ mdmEmployeeMaster }) => (this.mdmEmployeeMaster = mdmEmployeeMaster));
  }

  previousState(): void {
    window.history.back();
  }
}
