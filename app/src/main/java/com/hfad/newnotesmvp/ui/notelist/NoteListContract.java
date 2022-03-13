package com.hfad.newnotesmvp.ui.notelist;

import com.hfad.newnotesmvp.data.model.Note;

import java.util.List;

public interface NoteListContract {

    interface INoteListPresenter {

        void clickedOnButton();

        void openNoteClick(Note note);

        void loadNotes();

        void onLongClick(Note note);

        void deleteNote(Note note);

    }

    interface INoteListView {

        void showNotes(List<Note> notes);

        void openCreateNoteScreen();

        void openEditNoteScreen(String uuid);

        void showDeleteDialog(Note note);

    }

}
