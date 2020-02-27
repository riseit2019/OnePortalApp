import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IMdmEmpRoleMaster, MdmEmpRoleMaster } from 'app/shared/model/mdm-emp-role-master.model';
import { MdmEmpRoleMasterService } from './mdm-emp-role-master.service';
import { MdmEmpRoleMasterComponent } from './mdm-emp-role-master.component';
import { MdmEmpRoleMasterDetailComponent } from './mdm-emp-role-master-detail.component';
import { MdmEmpRoleMasterUpdateComponent } from './mdm-emp-role-master-update.component';

@Injectable({ providedIn: 'root' })
export class MdmEmpRoleMasterResolve implements Resolve<IMdmEmpRoleMaster> {
  constructor(private service: MdmEmpRoleMasterService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IMdmEmpRoleMaster> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((mdmEmpRoleMaster: HttpResponse<MdmEmpRoleMaster>) => {
          if (mdmEmpRoleMaster.body) {
            return of(mdmEmpRoleMaster.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new MdmEmpRoleMaster());
  }
}

export const mdmEmpRoleMasterRoute: Routes = [
  {
    path: '',
    component: MdmEmpRoleMasterComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmEmpRoleMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: MdmEmpRoleMasterDetailComponent,
    resolve: {
      mdmEmpRoleMaster: MdmEmpRoleMasterResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmEmpRoleMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: MdmEmpRoleMasterUpdateComponent,
    resolve: {
      mdmEmpRoleMaster: MdmEmpRoleMasterResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmEmpRoleMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: MdmEmpRoleMasterUpdateComponent,
    resolve: {
      mdmEmpRoleMaster: MdmEmpRoleMasterResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmEmpRoleMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
