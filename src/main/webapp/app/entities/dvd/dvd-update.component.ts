import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IDvd, Dvd } from 'app/shared/model/dvd.model';
import { DvdService } from './dvd.service';

@Component({
  selector: 'jhi-dvd-update',
  templateUrl: './dvd-update.component.html',
})
export class DvdUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    name: [null, [Validators.required]],
    releaseYear: [],
    diskCount: [],
    format: [],
    lang: [],
    state: [],
    added: [],
  });

  constructor(protected dvdService: DvdService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ dvd }) => {
      if (!dvd.id) {
        const today = moment().startOf('day');
        dvd.added = today;
      }

      this.updateForm(dvd);
    });
  }

  updateForm(dvd: IDvd): void {
    this.editForm.patchValue({
      id: dvd.id,
      name: dvd.name,
      releaseYear: dvd.releaseYear,
      diskCount: dvd.diskCount,
      format: dvd.format,
      lang: dvd.lang,
      state: dvd.state,
      added: dvd.added ? dvd.added.format(DATE_TIME_FORMAT) : null,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const dvd = this.createFromForm();
    if (dvd.id !== undefined) {
      this.subscribeToSaveResponse(this.dvdService.update(dvd));
    } else {
      this.subscribeToSaveResponse(this.dvdService.create(dvd));
    }
  }

  private createFromForm(): IDvd {
    return {
      ...new Dvd(),
      id: this.editForm.get(['id'])!.value,
      name: this.editForm.get(['name'])!.value,
      releaseYear: this.editForm.get(['releaseYear'])!.value,
      diskCount: this.editForm.get(['diskCount'])!.value,
      format: this.editForm.get(['format'])!.value,
      lang: this.editForm.get(['lang'])!.value,
      state: this.editForm.get(['state'])!.value,
      added: this.editForm.get(['added'])!.value ? moment(this.editForm.get(['added'])!.value, DATE_TIME_FORMAT) : undefined,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IDvd>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }
}
