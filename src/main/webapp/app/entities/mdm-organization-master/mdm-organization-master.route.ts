import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IMdmOrganizationMaster, MdmOrganizationMaster } from 'app/shared/model/mdm-organization-master.model';
import { MdmOrganizationMasterService } from './mdm-organization-master.service';
import { MdmOrganizationMasterComponent } from './mdm-organization-master.component';
import { MdmOrganizationMasterDetailComponent } from './mdm-organization-master-detail.component';
import { MdmOrganizationMasterUpdateComponent } from './mdm-organization-master-update.component';

@Injectable({ providedIn: 'root' })
export class MdmOrganizationMasterResolve implements Resolve<IMdmOrganizationMaster> {
  constructor(private service: MdmOrganizationMasterService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IMdmOrganizationMaster> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((mdmOrganizationMaster: HttpResponse<MdmOrganizationMaster>) => {
          if (mdmOrganizationMaster.body) {
            return of(mdmOrganizationMaster.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new MdmOrganizationMaster());
  }
}

export const mdmOrganizationMasterRoute: Routes = [
  {
    path: '',
    component: MdmOrganizationMasterComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmOrganizationMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: MdmOrganizationMasterDetailComponent,
    resolve: {
      mdmOrganizationMaster: MdmOrganizationMasterResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmOrganizationMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: MdmOrganizationMasterUpdateComponent,
    resolve: {
      mdmOrganizationMaster: MdmOrganizationMasterResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmOrganizationMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: MdmOrganizationMasterUpdateComponent,
    resolve: {
      mdmOrganizationMaster: MdmOrganizationMasterResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmOrganizationMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
