package com.hfad.newnotesmvp.ui.editnote;

import com.hfad.newnotesmvp.data.model.Note;

public interface EditNoteContract {

    interface IEditNotePresenter {

        void saveNote(String note);

        void loadNote(String uuid);
    }

    interface IEditNoteView {

        void updateNote();

        void closeEditNoteScreen();

        void showNote(Note note);
    }
}
