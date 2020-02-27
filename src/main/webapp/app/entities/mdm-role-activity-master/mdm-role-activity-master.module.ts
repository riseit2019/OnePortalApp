import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OnePortalAppSharedModule } from 'app/shared/shared.module';
import { MdmRoleActivityMasterComponent } from './mdm-role-activity-master.component';
import { MdmRoleActivityMasterDetailComponent } from './mdm-role-activity-master-detail.component';
import { MdmRoleActivityMasterUpdateComponent } from './mdm-role-activity-master-update.component';
import { MdmRoleActivityMasterDeleteDialogComponent } from './mdm-role-activity-master-delete-dialog.component';
import { mdmRoleActivityMasterRoute } from './mdm-role-activity-master.route';

@NgModule({
  imports: [OnePortalAppSharedModule, RouterModule.forChild(mdmRoleActivityMasterRoute)],
  declarations: [
    MdmRoleActivityMasterComponent,
    MdmRoleActivityMasterDetailComponent,
    MdmRoleActivityMasterUpdateComponent,
    MdmRoleActivityMasterDeleteDialogComponent
  ],
  entryComponents: [MdmRoleActivityMasterDeleteDialogComponent]
})
export class OnePortalAppMdmRoleActivityMasterModule {}
