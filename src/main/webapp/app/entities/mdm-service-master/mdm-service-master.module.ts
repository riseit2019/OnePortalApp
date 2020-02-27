import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OnePortalAppSharedModule } from 'app/shared/shared.module';
import { MdmServiceMasterComponent } from './mdm-service-master.component';
import { MdmServiceMasterDetailComponent } from './mdm-service-master-detail.component';
import { MdmServiceMasterUpdateComponent } from './mdm-service-master-update.component';
import { MdmServiceMasterDeleteDialogComponent } from './mdm-service-master-delete-dialog.component';
import { mdmServiceMasterRoute } from './mdm-service-master.route';

@NgModule({
  imports: [OnePortalAppSharedModule, RouterModule.forChild(mdmServiceMasterRoute)],
  declarations: [
    MdmServiceMasterComponent,
    MdmServiceMasterDetailComponent,
    MdmServiceMasterUpdateComponent,
    MdmServiceMasterDeleteDialogComponent
  ],
  entryComponents: [MdmServiceMasterDeleteDialogComponent]
})
export class OnePortalAppMdmServiceMasterModule {}
