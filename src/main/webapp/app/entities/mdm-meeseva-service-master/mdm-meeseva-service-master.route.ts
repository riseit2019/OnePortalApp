import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IMdmMeesevaServiceMaster, MdmMeesevaServiceMaster } from 'app/shared/model/mdm-meeseva-service-master.model';
import { MdmMeesevaServiceMasterService } from './mdm-meeseva-service-master.service';
import { MdmMeesevaServiceMasterComponent } from './mdm-meeseva-service-master.component';
import { MdmMeesevaServiceMasterDetailComponent } from './mdm-meeseva-service-master-detail.component';
import { MdmMeesevaServiceMasterUpdateComponent } from './mdm-meeseva-service-master-update.component';

@Injectable({ providedIn: 'root' })
export class MdmMeesevaServiceMasterResolve implements Resolve<IMdmMeesevaServiceMaster> {
  constructor(private service: MdmMeesevaServiceMasterService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IMdmMeesevaServiceMaster> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((mdmMeesevaServiceMaster: HttpResponse<MdmMeesevaServiceMaster>) => {
          if (mdmMeesevaServiceMaster.body) {
            return of(mdmMeesevaServiceMaster.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new MdmMeesevaServiceMaster());
  }
}

export const mdmMeesevaServiceMasterRoute: Routes = [
  {
    path: '',
    component: MdmMeesevaServiceMasterComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmMeesevaServiceMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: MdmMeesevaServiceMasterDetailComponent,
    resolve: {
      mdmMeesevaServiceMaster: MdmMeesevaServiceMasterResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmMeesevaServiceMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: MdmMeesevaServiceMasterUpdateComponent,
    resolve: {
      mdmMeesevaServiceMaster: MdmMeesevaServiceMasterResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmMeesevaServiceMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: MdmMeesevaServiceMasterUpdateComponent,
    resolve: {
      mdmMeesevaServiceMaster: MdmMeesevaServiceMasterResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmMeesevaServiceMaster.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
