import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IMdmCitizenData } from 'app/shared/model/mdm-citizen-data.model';

@Component({
  selector: 'jhi-mdm-citizen-data-detail',
  templateUrl: './mdm-citizen-data-detail.component.html'
})
export class MdmCitizenDataDetailComponent implements OnInit {
  mdmCitizenData: IMdmCitizenData | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ mdmCitizenData }) => (this.mdmCitizenData = mdmCitizenData));
  }

  previousState(): void {
    window.history.back();
  }
}
