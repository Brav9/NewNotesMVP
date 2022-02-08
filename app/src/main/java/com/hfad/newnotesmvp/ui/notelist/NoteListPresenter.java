package com.hfad.newnotesmvp.ui.notelist;

import com.hfad.newnotesmvp.data.INotesRepository;

public class NoteListPresenter implements NoteListContract.INoteListPresenter {

    NoteListContract.INoteListView view;
//    INotesRepository ....

    public NoteListPresenter(NoteListContract.INoteListView view) {
        this.view = view;
        loadNotes();
//        repo = new Repo
    }

    public void loadNotes() {
        //TODO сходить в репозиторий, получить все заметки и передать на вью
        //view.showNotes();
    }

    @Override
    public void clickedOnButton() {
        view.openCreateNoteScreen();
    }

    @Override
    public void openNoteClick(int id) {
        view.openEditNoteScreen(id);
    }
}
