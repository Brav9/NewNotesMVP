package com.hfad.newnotesmvp.ui.notelist;


import android.provider.ContactsContract;

import com.hfad.newnotesmvp.data.INotesRepository;
import com.hfad.newnotesmvp.data.NotesRepository;
import com.hfad.newnotesmvp.data.model.Note;

import java.util.List;

public class NoteListPresenter implements NoteListContract.INoteListPresenter {

    NoteListContract.INoteListView view;
//    INotesRepository ....
    INotesRepository repository;

    public NoteListPresenter(NoteListContract.INoteListView view) {
        this.view = view;
        loadNotes();
//        repo = new Repo

     repository = new INotesRepository() {
         @Override
         public void saveNote(Note note) {

         }

         @Override
         public void deleteNote(Note note) {

         }

         @Override
         public List<Note> getNotes() {
             return null;
         }
     };

    }

    public void loadNotes() {
        //TODO сходить в репозиторий, получить все заметки и передать на вью
        //view.showNotes();
        view.showNotes(repository.getNotes());

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
