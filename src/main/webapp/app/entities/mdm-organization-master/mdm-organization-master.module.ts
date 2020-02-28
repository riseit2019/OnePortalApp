import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OnePortalAppSharedModule } from 'app/shared/shared.module';
import { MdmOrganizationMasterComponent } from './mdm-organization-master.component';
import { MdmOrganizationMasterDetailComponent } from './mdm-organization-master-detail.component';
import { MdmOrganizationMasterUpdateComponent } from './mdm-organization-master-update.component';
import { MdmOrganizationMasterDeleteDialogComponent } from './mdm-organization-master-delete-dialog.component';
import { mdmOrganizationMasterRoute } from './mdm-organization-master.route';

@NgModule({
  imports: [OnePortalAppSharedModule, RouterModule.forChild(mdmOrganizationMasterRoute)],
  declarations: [
    MdmOrganizationMasterComponent,
    MdmOrganizationMasterDetailComponent,
    MdmOrganizationMasterUpdateComponent,
    MdmOrganizationMasterDeleteDialogComponent
  ],
  entryComponents: [MdmOrganizationMasterDeleteDialogComponent]
})
export class OnePortalAppMdmOrganizationMasterModule {}
