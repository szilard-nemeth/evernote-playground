package com.szilardnemeth.evernote.playground;

import com.evernote.auth.EvernoteService;
import com.evernote.edam.type.Notebook;
import com.evernote.edam.type.SharedNotebook;
import org.springframework.social.evernote.api.Evernote;
import org.springframework.social.evernote.api.NoteStoreOperations;
import org.springframework.social.evernote.api.impl.EvernoteTemplate;

public class EvernoteAuth {
  public static void authenticate() {
    // you can use it without any of the spring-social or spring-framework classes at this level
    Evernote evernote = new EvernoteTemplate(EvernoteService.PRODUCTION, "access-token");

// NoteStoreOperations is an interface corresponds to NoteStoreClient
    NoteStoreOperations noteStore = evernote.noteStoreOperations();

    Notebook notebook = noteStore.getDefaultNotebook();  // no checked exception is thrown

    for (SharedNotebook sharedNotebook : notebook.getSharedNotebooks()) {  // no NPE when there is no shared notebooks
      System.out.println(sharedNotebook);
    }
  }
}
