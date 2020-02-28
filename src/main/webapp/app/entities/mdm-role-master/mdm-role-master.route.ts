import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IMdmRoleMaster, MdmRoleMaster } from 'app/shared/model/mdm-role-master.model';
import { MdmRoleMasterService } from './mdm-role-master.service';
import { MdmRoleMasterComponent } from './mdm-role-master.component';
import { MdmRoleMasterDetailComponent } from './mdm-role-master-detail.component';
import { MdmRoleMasterUpdateComponent } from './mdm-role-master-update.component';

@Injectable({ providedIn: 'root' })
export class MdmRoleMasterResolve implements Resolve<IMdmRoleMaster> {
  constructor(private service: MdmRoleMasterService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IMdmRoleMaster> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((mdmRoleMaster: HttpResponse<MdmRoleMaster>) => {
          if (mdmRoleMaster.body) {
            return of(mdmRoleMaster.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new MdmRoleMaster());
  }
}

export const mdmRoleMasterRoute: Routes = [
  {
    path: '',
    component: MdmRoleMasterComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmRoleMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: MdmRoleMasterDetailComponent,
    resolve: {
      mdmRoleMaster: MdmRoleMasterResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmRoleMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: MdmRoleMasterUpdateComponent,
    resolve: {
      mdmRoleMaster: MdmRoleMasterResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmRoleMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: MdmRoleMasterUpdateComponent,
    resolve: {
      mdmRoleMaster: MdmRoleMasterResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmRoleMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
