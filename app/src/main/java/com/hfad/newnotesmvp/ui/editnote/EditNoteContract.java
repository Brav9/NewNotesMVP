package com.hfad.newnotesmvp.ui.editnote;

import com.hfad.newnotesmvp.data.model.Note;

public interface EditNoteContract {

    interface IEditNotePresenter {

        void updateNote(String note);

        void saveNote(String note);

    }

    interface IEditNoteView {

        void updateNote();

        void closeEditNoteScreen();
    }
}
