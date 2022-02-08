package com.hfad.newnotesmvp.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hfad.newnotesmvp.data.model.Note;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class NotesRepository implements INotesRepository {

    private final String NOTES = "notes";
    private SharedPreferences prefs;
    private Gson gson;

    public NotesRepository(Context context) {
        prefs = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();
    }

    @Override
    public void saveNote(Note note) {
        List<Note> notes = getNotes();
        //TODO найти, как удалить из List один объект
        // скорее всего новая коллекция (ArrayList).
        // Затем notes перебираешь в цикле, каждый объект в листе сравниваешь по id
        // с тем, который передан в аргументах. Если не совпадают, то добавляшь из массива, иначе - из аргументов
//        saveNotes();
    }

    @Override
    public void deleteNote(Note note) {
        List<Note> notes = getNotes();
        //TODO найти, как удалить из List один объект
        // скорее всего новая коллекция (ArrayList).
        // Затем notes перебираешь в цикле, каждый объект в листе сравниваешь по id
        // с тем, который передан в аргументах. Если не совпадают, то добавляшь заметку в новый лист
//        saveNotes();
    }

    private void saveNotes(List<Note> notes) {
        //TODO prefs putSTring NOTES, gson.toJson(notes)
    }

    @Override
    public List<Note> getNotes() {
        String notesJson = prefs.getString(NOTES, "[]");
        Note[] notesArray = gson.fromJson(notesJson, Note[].class);
        List<Note> notes = Arrays.asList(notesArray);
        return notes;
    }


}
