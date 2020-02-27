import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OnePortalAppSharedModule } from 'app/shared/shared.module';
import { MdmEmpRoleMasterComponent } from './mdm-emp-role-master.component';
import { MdmEmpRoleMasterDetailComponent } from './mdm-emp-role-master-detail.component';
import { MdmEmpRoleMasterUpdateComponent } from './mdm-emp-role-master-update.component';
import { MdmEmpRoleMasterDeleteDialogComponent } from './mdm-emp-role-master-delete-dialog.component';
import { mdmEmpRoleMasterRoute } from './mdm-emp-role-master.route';

@NgModule({
  imports: [OnePortalAppSharedModule, RouterModule.forChild(mdmEmpRoleMasterRoute)],
  declarations: [
    MdmEmpRoleMasterComponent,
    MdmEmpRoleMasterDetailComponent,
    MdmEmpRoleMasterUpdateComponent,
    MdmEmpRoleMasterDeleteDialogComponent
  ],
  entryComponents: [MdmEmpRoleMasterDeleteDialogComponent]
})
export class OnePortalAppMdmEmpRoleMasterModule {}
