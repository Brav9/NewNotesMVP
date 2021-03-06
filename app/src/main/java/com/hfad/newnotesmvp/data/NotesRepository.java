package com.hfad.newnotesmvp.data;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hfad.newnotesmvp.data.model.Note;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NotesRepository implements INotesRepository {

    private final String NOTES = "notes";
    private final SharedPreferences prefs;
    private final Gson gson;

    public NotesRepository(Context context) {
        prefs = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();
    }

    @Override
    public void saveNote(Note note) {

        List<Note> notes = getNotes();
        List<Note> editedNotes = new ArrayList<>();

        boolean contains = false;

        for (Note noteIterate : notes) {
            if (noteIterate.getUuid().equals(note.getUuid())) {
                editedNotes.add(note);
                contains = true;
            } else {
                editedNotes.add(noteIterate);
            }
        }
        if (!contains) {
            editedNotes.add(note);
        }
        saveNotes(editedNotes);
    }

    @Override
    public void deleteNote(Note note) {

        List<Note> notes = getNotes();
        List<Note> editedNotes = new ArrayList<>();

        for (Note noteIterate : notes) {
            if (!noteIterate.getUuid().equals(note.getUuid())) {
                editedNotes.add(noteIterate);
            }
        }
        saveNotes(editedNotes);
    }

    private void saveNotes(List<Note> notes) {
        prefs.edit()
                .putString(NOTES, gson.toJson(notes))
                .apply();
    }

    @Override
    public List<Note> getNotes() {
        String notesJson = prefs.getString(NOTES, "[]");
        Note[] notesArray = gson.fromJson(notesJson, Note[].class);
        return Arrays.asList(notesArray);
    }

    @Override
    @Nullable
    public Note getNote(String uuid) {

        List<Note> notes = getNotes();
        for (Note noteIterate : notes) {
            if (noteIterate.getUuid().equals(uuid)) return noteIterate;
        }
        return null;
    }
}
