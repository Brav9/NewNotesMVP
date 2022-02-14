package com.hfad.newnotesmvp.ui.editnote;

public interface EditNoteContract {

    interface IEditNotePresenter {

        void updateNote(String note);
        void closeNoteClick();

    }

    interface IEditNoteView {

        void updateNote();
        void closeEditNoteScreen();
    }
}
