import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OnePortalAppSharedModule } from 'app/shared/shared.module';
import { MdmEmployeeMasterComponent } from './mdm-employee-master.component';
import { MdmEmployeeMasterDetailComponent } from './mdm-employee-master-detail.component';
import { MdmEmployeeMasterUpdateComponent } from './mdm-employee-master-update.component';
import { MdmEmployeeMasterDeleteDialogComponent } from './mdm-employee-master-delete-dialog.component';
import { mdmEmployeeMasterRoute } from './mdm-employee-master.route';

@NgModule({
  imports: [OnePortalAppSharedModule, RouterModule.forChild(mdmEmployeeMasterRoute)],
  declarations: [
    MdmEmployeeMasterComponent,
    MdmEmployeeMasterDetailComponent,
    MdmEmployeeMasterUpdateComponent,
    MdmEmployeeMasterDeleteDialogComponent
  ],
  entryComponents: [MdmEmployeeMasterDeleteDialogComponent]
})
export class OnePortalAppMdmEmployeeMasterModule {}
