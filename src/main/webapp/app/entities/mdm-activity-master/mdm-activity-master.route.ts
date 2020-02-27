import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IMdmActivityMaster, MdmActivityMaster } from 'app/shared/model/mdm-activity-master.model';
import { MdmActivityMasterService } from './mdm-activity-master.service';
import { MdmActivityMasterComponent } from './mdm-activity-master.component';
import { MdmActivityMasterDetailComponent } from './mdm-activity-master-detail.component';
import { MdmActivityMasterUpdateComponent } from './mdm-activity-master-update.component';

@Injectable({ providedIn: 'root' })
export class MdmActivityMasterResolve implements Resolve<IMdmActivityMaster> {
  constructor(private service: MdmActivityMasterService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IMdmActivityMaster> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((mdmActivityMaster: HttpResponse<MdmActivityMaster>) => {
          if (mdmActivityMaster.body) {
            return of(mdmActivityMaster.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new MdmActivityMaster());
  }
}

export const mdmActivityMasterRoute: Routes = [
  {
    path: '',
    component: MdmActivityMasterComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmActivityMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: MdmActivityMasterDetailComponent,
    resolve: {
      mdmActivityMaster: MdmActivityMasterResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmActivityMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: MdmActivityMasterUpdateComponent,
    resolve: {
      mdmActivityMaster: MdmActivityMasterResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmActivityMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: MdmActivityMasterUpdateComponent,
    resolve: {
      mdmActivityMaster: MdmActivityMasterResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmActivityMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
