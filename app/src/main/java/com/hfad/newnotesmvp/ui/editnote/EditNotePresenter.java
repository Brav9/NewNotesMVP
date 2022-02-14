package com.hfad.newnotesmvp.ui.editnote;

import android.content.Context;

import com.hfad.newnotesmvp.data.INotesRepository;
import com.hfad.newnotesmvp.data.NotesRepository;

public class EditNotePresenter implements EditNoteContract.IEditNotePresenter {

    public EditNotePresenter(EditNoteContract.IEditNoteView view, Context applicationContext) {
        this.view = view;
        repository = new NotesRepository(applicationContext);
    }

    EditNoteContract.IEditNoteView view;
    INotesRepository repository;

    @Override
    public void updateNote(String note) {
        try {
            if (note != null) {

            } else {

            }
        } catch (NullPointerException | NumberFormatException ignored) {

        }
    }

    @Override
    public void closeNoteClick() {

    }
}
