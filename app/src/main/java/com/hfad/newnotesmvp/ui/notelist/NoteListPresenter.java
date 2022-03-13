package com.hfad.newnotesmvp.ui.notelist;

import android.content.Context;
import com.hfad.newnotesmvp.data.INotesRepository;
import com.hfad.newnotesmvp.data.NotesRepository;
import com.hfad.newnotesmvp.data.model.Note;
import java.util.List;

public class NoteListPresenter implements NoteListContract.INoteListPresenter {

    NoteListContract.INoteListView view;
    INotesRepository repository;

    public NoteListPresenter(NoteListContract.INoteListView view, Context applicationContext) {
        this.view = view;
        repository = new NotesRepository(applicationContext);
    }

    public void loadNotes() {
        List<Note> notes = repository.getNotes();
        view.showNotes(notes);
    }

    @Override
    public void onLongClick(Note note) {
        view.showDeleteDialog(note);
    }

    @Override
    public void deleteNote(Note note) {
        repository.deleteNote(note);
        loadNotes();
    }

    @Override
    public void clickedOnButton() {
        view.openCreateNoteScreen();
    }

    @Override
    public void openNoteClick(Note note) {
        view.openEditNoteScreen(note.getUuid());
    }
}
