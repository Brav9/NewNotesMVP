package com.hfad.newnotesmvp.ui.editnote;

import android.content.Context;

import com.hfad.newnotesmvp.data.INotesRepository;
import com.hfad.newnotesmvp.data.NotesRepository;
import com.hfad.newnotesmvp.data.model.Note;

import java.util.UUID;

public class EditNotePresenter implements EditNoteContract.IEditNotePresenter {

    public EditNotePresenter(EditNoteContract.IEditNoteView view, Context applicationContext) {
        this.view = view;
        repository = new NotesRepository(applicationContext);
    }

    EditNoteContract.IEditNoteView view;
    INotesRepository repository;

    @Override
    public void updateNote(String note) {
    }

    @Override
    public void saveNote(String note) {
        repository.saveNote(new Note(UUID.randomUUID().toString(), note));
        view.closeEditNoteScreen();
    }
}
