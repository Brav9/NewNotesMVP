package com.hfad.newnotesmvp.data;

import com.hfad.newnotesmvp.data.model.Note;

import java.util.List;

public interface INotesRepository {

    void saveNote(Note note);

    void deleteNote(Note note);

    List<Note> getNotes();

    Note getNote(String uuid);
}
