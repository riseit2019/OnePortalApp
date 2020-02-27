import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'mdm-organization-master',
        loadChildren: () =>
          import('./mdm-organization-master/mdm-organization-master.module').then(m => m.OnePortalAppMdmOrganizationMasterModule)
      },
      {
        path: 'mdm-citizen-data',
        loadChildren: () => import('./mdm-citizen-data/mdm-citizen-data.module').then(m => m.OnePortalAppMdmCitizenDataModule)
      },
      {
        path: 'mdm-service-master',
        loadChildren: () => import('./mdm-service-master/mdm-service-master.module').then(m => m.OnePortalAppMdmServiceMasterModule)
      },
      {
        path: 'mdm-activity-master',
        loadChildren: () => import('./mdm-activity-master/mdm-activity-master.module').then(m => m.OnePortalAppMdmActivityMasterModule)
      },
      {
        path: 'mdm-employee-master',
        loadChildren: () => import('./mdm-employee-master/mdm-employee-master.module').then(m => m.OnePortalAppMdmEmployeeMasterModule)
      },
      {
        path: 'mdm-meeseva-service-master',
        loadChildren: () =>
          import('./mdm-meeseva-service-master/mdm-meeseva-service-master.module').then(m => m.OnePortalAppMdmMeesevaServiceMasterModule)
      },
      {
        path: 'mdm-role-master',
        loadChildren: () => import('./mdm-role-master/mdm-role-master.module').then(m => m.OnePortalAppMdmRoleMasterModule)
      },
      {
        path: 'mdm-emp-role-master',
        loadChildren: () => import('./mdm-emp-role-master/mdm-emp-role-master.module').then(m => m.OnePortalAppMdmEmpRoleMasterModule)
      },
      {
        path: 'mdm-role-activity-master',
        loadChildren: () =>
          import('./mdm-role-activity-master/mdm-role-activity-master.module').then(m => m.OnePortalAppMdmRoleActivityMasterModule)
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ]
})
export class OnePortalAppEntityModule {}
