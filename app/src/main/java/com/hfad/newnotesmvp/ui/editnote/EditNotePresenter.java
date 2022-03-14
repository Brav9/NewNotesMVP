package com.hfad.newnotesmvp.ui.editnote;

import android.content.Context;

import com.hfad.newnotesmvp.data.INotesRepository;
import com.hfad.newnotesmvp.data.NotesRepository;
import com.hfad.newnotesmvp.data.model.Note;

import java.util.UUID;

public class EditNotePresenter implements EditNoteContract.IEditNotePresenter {

    Note note;

    public EditNotePresenter(EditNoteContract.IEditNoteView view, Context applicationContext) {
        this.view = view;
        repository = new NotesRepository(applicationContext);
    }

    final EditNoteContract.IEditNoteView view;
    final INotesRepository repository;

    @Override
    public void saveNote(String text) {
        if (note != null) {
            note.setValue(text);
            repository.saveNote(note);
        } else {
            repository.saveNote(new Note(UUID.randomUUID().toString(), text));
        }
        view.closeEditNoteScreen();
    }

    @Override
    public void loadNote(String uuid) {
        Note note = repository.getNote(uuid);
        if (note != null) {
            this.note = note;
            view.showNote(note);
        }
    }
}
