import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IMdmMeesevaServiceMaster } from 'app/shared/model/mdm-meeseva-service-master.model';

@Component({
  selector: 'jhi-mdm-meeseva-service-master-detail',
  templateUrl: './mdm-meeseva-service-master-detail.component.html'
})
export class MdmMeesevaServiceMasterDetailComponent implements OnInit {
  mdmMeesevaServiceMaster: IMdmMeesevaServiceMaster | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ mdmMeesevaServiceMaster }) => (this.mdmMeesevaServiceMaster = mdmMeesevaServiceMaster));
  }

  previousState(): void {
    window.history.back();
  }
}
