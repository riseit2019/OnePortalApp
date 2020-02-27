import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OnePortalAppSharedModule } from 'app/shared/shared.module';
import { MdmCitizenDataComponent } from './mdm-citizen-data.component';
import { MdmCitizenDataDetailComponent } from './mdm-citizen-data-detail.component';
import { MdmCitizenDataUpdateComponent } from './mdm-citizen-data-update.component';
import { MdmCitizenDataDeleteDialogComponent } from './mdm-citizen-data-delete-dialog.component';
import { mdmCitizenDataRoute } from './mdm-citizen-data.route';

@NgModule({
  imports: [OnePortalAppSharedModule, RouterModule.forChild(mdmCitizenDataRoute)],
  declarations: [
    MdmCitizenDataComponent,
    MdmCitizenDataDetailComponent,
    MdmCitizenDataUpdateComponent,
    MdmCitizenDataDeleteDialogComponent
  ],
  entryComponents: [MdmCitizenDataDeleteDialogComponent]
})
export class OnePortalAppMdmCitizenDataModule {}
