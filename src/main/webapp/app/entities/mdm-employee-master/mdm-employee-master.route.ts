import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IMdmEmployeeMaster, MdmEmployeeMaster } from 'app/shared/model/mdm-employee-master.model';
import { MdmEmployeeMasterService } from './mdm-employee-master.service';
import { MdmEmployeeMasterComponent } from './mdm-employee-master.component';
import { MdmEmployeeMasterDetailComponent } from './mdm-employee-master-detail.component';
import { MdmEmployeeMasterUpdateComponent } from './mdm-employee-master-update.component';

@Injectable({ providedIn: 'root' })
export class MdmEmployeeMasterResolve implements Resolve<IMdmEmployeeMaster> {
  constructor(private service: MdmEmployeeMasterService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IMdmEmployeeMaster> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((mdmEmployeeMaster: HttpResponse<MdmEmployeeMaster>) => {
          if (mdmEmployeeMaster.body) {
            return of(mdmEmployeeMaster.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new MdmEmployeeMaster());
  }
}

export const mdmEmployeeMasterRoute: Routes = [
  {
    path: '',
    component: MdmEmployeeMasterComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmEmployeeMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: MdmEmployeeMasterDetailComponent,
    resolve: {
      mdmEmployeeMaster: MdmEmployeeMasterResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmEmployeeMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: MdmEmployeeMasterUpdateComponent,
    resolve: {
      mdmEmployeeMaster: MdmEmployeeMasterResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmEmployeeMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: MdmEmployeeMasterUpdateComponent,
    resolve: {
      mdmEmployeeMaster: MdmEmployeeMasterResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmEmployeeMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
