import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IMdmServiceMaster, MdmServiceMaster } from 'app/shared/model/mdm-service-master.model';
import { MdmServiceMasterService } from './mdm-service-master.service';
import { MdmServiceMasterComponent } from './mdm-service-master.component';
import { MdmServiceMasterDetailComponent } from './mdm-service-master-detail.component';
import { MdmServiceMasterUpdateComponent } from './mdm-service-master-update.component';

@Injectable({ providedIn: 'root' })
export class MdmServiceMasterResolve implements Resolve<IMdmServiceMaster> {
  constructor(private service: MdmServiceMasterService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IMdmServiceMaster> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((mdmServiceMaster: HttpResponse<MdmServiceMaster>) => {
          if (mdmServiceMaster.body) {
            return of(mdmServiceMaster.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new MdmServiceMaster());
  }
}

export const mdmServiceMasterRoute: Routes = [
  {
    path: '',
    component: MdmServiceMasterComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmServiceMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: MdmServiceMasterDetailComponent,
    resolve: {
      mdmServiceMaster: MdmServiceMasterResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmServiceMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: MdmServiceMasterUpdateComponent,
    resolve: {
      mdmServiceMaster: MdmServiceMasterResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmServiceMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: MdmServiceMasterUpdateComponent,
    resolve: {
      mdmServiceMaster: MdmServiceMasterResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmServiceMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
