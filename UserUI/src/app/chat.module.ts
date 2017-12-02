import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ChatDialogComponent } from './chat-dialog/chat-dialog.component';
import { ChatService } from './chat.service';

import { FormsModule } from '@angular/forms';
import { MatButtonModule, MatToolbarModule, MatAutocompleteModule, MatInputModule, MatSidenavModule } from '@angular/material';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    BrowserModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatAutocompleteModule,
    MatInputModule,
    MatSidenavModule,
  ],
  declarations: [
    ChatDialogComponent
  ],
  exports: [ ChatDialogComponent ],
  providers: [ChatService]
})
export class ChatModule { }
