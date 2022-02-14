package com.hfad.newnotesmvp.ui.notelist;

import android.content.Context;

import com.hfad.newnotesmvp.data.INotesRepository;

import com.hfad.newnotesmvp.data.NotesRepository;
import com.hfad.newnotesmvp.data.model.Note;

import java.util.List;

public class NoteListPresenter implements NoteListContract.INoteListPresenter {

    NoteListContract.INoteListView view;
    //    INotesRepository ....
    INotesRepository repository;

    public NoteListPresenter(NoteListContract.INoteListView view, Context applicationContext) {
        this.view = view;
//        loadNotes();
//        repo = new Repo
        repository = new NotesRepository(applicationContext);

    }

    public void loadNotes() {
        //TODO сходить в репозиторий, получить все заметки и передать на вью
        List<Note> notes = repository.getNotes();
        view.showNotes(notes);
//        repository.getNotes();
//        view.showNotes();
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
