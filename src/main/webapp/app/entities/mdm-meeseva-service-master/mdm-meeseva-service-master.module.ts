import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OnePortalAppSharedModule } from 'app/shared/shared.module';
import { MdmMeesevaServiceMasterComponent } from './mdm-meeseva-service-master.component';
import { MdmMeesevaServiceMasterDetailComponent } from './mdm-meeseva-service-master-detail.component';
import { MdmMeesevaServiceMasterUpdateComponent } from './mdm-meeseva-service-master-update.component';
import { MdmMeesevaServiceMasterDeleteDialogComponent } from './mdm-meeseva-service-master-delete-dialog.component';
import { mdmMeesevaServiceMasterRoute } from './mdm-meeseva-service-master.route';

@NgModule({
  imports: [OnePortalAppSharedModule, RouterModule.forChild(mdmMeesevaServiceMasterRoute)],
  declarations: [
    MdmMeesevaServiceMasterComponent,
    MdmMeesevaServiceMasterDetailComponent,
    MdmMeesevaServiceMasterUpdateComponent,
    MdmMeesevaServiceMasterDeleteDialogComponent
  ],
  entryComponents: [MdmMeesevaServiceMasterDeleteDialogComponent]
})
export class OnePortalAppMdmMeesevaServiceMasterModule {}
