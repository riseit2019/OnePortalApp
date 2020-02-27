import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OnePortalAppSharedModule } from 'app/shared/shared.module';
import { MdmActivityMasterComponent } from './mdm-activity-master.component';
import { MdmActivityMasterDetailComponent } from './mdm-activity-master-detail.component';
import { MdmActivityMasterUpdateComponent } from './mdm-activity-master-update.component';
import { MdmActivityMasterDeleteDialogComponent } from './mdm-activity-master-delete-dialog.component';
import { mdmActivityMasterRoute } from './mdm-activity-master.route';

@NgModule({
  imports: [OnePortalAppSharedModule, RouterModule.forChild(mdmActivityMasterRoute)],
  declarations: [
    MdmActivityMasterComponent,
    MdmActivityMasterDetailComponent,
    MdmActivityMasterUpdateComponent,
    MdmActivityMasterDeleteDialogComponent
  ],
  entryComponents: [MdmActivityMasterDeleteDialogComponent]
})
export class OnePortalAppMdmActivityMasterModule {}
