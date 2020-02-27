import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IMdmRoleActivityMaster, MdmRoleActivityMaster } from 'app/shared/model/mdm-role-activity-master.model';
import { MdmRoleActivityMasterService } from './mdm-role-activity-master.service';
import { MdmRoleActivityMasterComponent } from './mdm-role-activity-master.component';
import { MdmRoleActivityMasterDetailComponent } from './mdm-role-activity-master-detail.component';
import { MdmRoleActivityMasterUpdateComponent } from './mdm-role-activity-master-update.component';

@Injectable({ providedIn: 'root' })
export class MdmRoleActivityMasterResolve implements Resolve<IMdmRoleActivityMaster> {
  constructor(private service: MdmRoleActivityMasterService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IMdmRoleActivityMaster> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((mdmRoleActivityMaster: HttpResponse<MdmRoleActivityMaster>) => {
          if (mdmRoleActivityMaster.body) {
            return of(mdmRoleActivityMaster.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new MdmRoleActivityMaster());
  }
}

export const mdmRoleActivityMasterRoute: Routes = [
  {
    path: '',
    component: MdmRoleActivityMasterComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmRoleActivityMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: MdmRoleActivityMasterDetailComponent,
    resolve: {
      mdmRoleActivityMaster: MdmRoleActivityMasterResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmRoleActivityMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: MdmRoleActivityMasterUpdateComponent,
    resolve: {
      mdmRoleActivityMaster: MdmRoleActivityMasterResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmRoleActivityMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: MdmRoleActivityMasterUpdateComponent,
    resolve: {
      mdmRoleActivityMaster: MdmRoleActivityMasterResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmRoleActivityMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
