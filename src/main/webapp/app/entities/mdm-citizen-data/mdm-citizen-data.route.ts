import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IMdmCitizenData, MdmCitizenData } from 'app/shared/model/mdm-citizen-data.model';
import { MdmCitizenDataService } from './mdm-citizen-data.service';
import { MdmCitizenDataComponent } from './mdm-citizen-data.component';
import { MdmCitizenDataDetailComponent } from './mdm-citizen-data-detail.component';
import { MdmCitizenDataUpdateComponent } from './mdm-citizen-data-update.component';

@Injectable({ providedIn: 'root' })
export class MdmCitizenDataResolve implements Resolve<IMdmCitizenData> {
  constructor(private service: MdmCitizenDataService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IMdmCitizenData> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((mdmCitizenData: HttpResponse<MdmCitizenData>) => {
          if (mdmCitizenData.body) {
            return of(mdmCitizenData.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new MdmCitizenData());
  }
}

export const mdmCitizenDataRoute: Routes = [
  {
    path: '',
    component: MdmCitizenDataComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmCitizenData.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: MdmCitizenDataDetailComponent,
    resolve: {
      mdmCitizenData: MdmCitizenDataResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmCitizenData.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: MdmCitizenDataUpdateComponent,
    resolve: {
      mdmCitizenData: MdmCitizenDataResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmCitizenData.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: MdmCitizenDataUpdateComponent,
    resolve: {
      mdmCitizenData: MdmCitizenDataResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'onePortalApp.mdmCitizenData.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
