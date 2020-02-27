import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { OnePortalAppSharedModule } from 'app/shared/shared.module';
import { OnePortalAppCoreModule } from 'app/core/core.module';
import { OnePortalAppAppRoutingModule } from './app-routing.module';
import { OnePortalAppHomeModule } from './home/home.module';
import { OnePortalAppEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ActiveMenuDirective } from './layouts/navbar/active-menu.directive';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    OnePortalAppSharedModule,
    OnePortalAppCoreModule,
    OnePortalAppHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    OnePortalAppEntityModule,
    OnePortalAppAppRoutingModule
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, ActiveMenuDirective, FooterComponent],
  bootstrap: [MainComponent]
})
export class OnePortalAppAppModule {}
