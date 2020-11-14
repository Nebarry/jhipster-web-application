import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterWebApplicationSharedModule } from 'app/shared/shared.module';
import { DvdComponent } from './dvd.component';
import { DvdDetailComponent } from './dvd-detail.component';
import { DvdUpdateComponent } from './dvd-update.component';
import { DvdDeleteDialogComponent } from './dvd-delete-dialog.component';
import { dvdRoute } from './dvd.route';

@NgModule({
  imports: [JhipsterWebApplicationSharedModule, RouterModule.forChild(dvdRoute)],
  declarations: [DvdComponent, DvdDetailComponent, DvdUpdateComponent, DvdDeleteDialogComponent],
  entryComponents: [DvdDeleteDialogComponent],
})
export class JhipsterWebApplicationDvdModule {}
