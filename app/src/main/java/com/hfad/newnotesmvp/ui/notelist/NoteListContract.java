package com.hfad.newnotesmvp.ui.notelist;

import com.hfad.newnotesmvp.data.model.Note;

import java.util.List;

public interface NoteListContract {

    interface INoteListPresenter {
        void clickedOnButton();
        void openNoteClick(int id);
        void loadNotes();
    }

    interface INoteListView {
        void showNotes(List<Note> notes);
        void openCreateNoteScreen();
        void openEditNoteScreen(int id);
    }

}
