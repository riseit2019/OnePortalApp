import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OnePortalAppSharedModule } from 'app/shared/shared.module';
import { MdmRoleMasterComponent } from './mdm-role-master.component';
import { MdmRoleMasterDetailComponent } from './mdm-role-master-detail.component';
import { MdmRoleMasterUpdateComponent } from './mdm-role-master-update.component';
import { MdmRoleMasterDeleteDialogComponent } from './mdm-role-master-delete-dialog.component';
import { mdmRoleMasterRoute } from './mdm-role-master.route';

@NgModule({
  imports: [OnePortalAppSharedModule, RouterModule.forChild(mdmRoleMasterRoute)],
  declarations: [MdmRoleMasterComponent, MdmRoleMasterDetailComponent, MdmRoleMasterUpdateComponent, MdmRoleMasterDeleteDialogComponent],
  entryComponents: [MdmRoleMasterDeleteDialogComponent]
})
export class OnePortalAppMdmRoleMasterModule {}
