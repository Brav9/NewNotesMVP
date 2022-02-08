package com.hfad.newnotesmvp.ui.notelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.hfad.newnotesmvp.data.model.Note;
import com.hfad.newnotesmvp.ui.editnote.EditNoteActivity;
import com.hfad.newnotesmvp.R;

import java.util.ArrayList;
import java.util.List;

public class NoteListActivity extends AppCompatActivity implements NoteListContract.INoteListView {

//    static ArrayList<String> notes = new ArrayList<>();
    private ArrayAdapter<Note> arrayAdapter; //TODO поискать, как отображать свою модель
    private NoteListContract.INoteListPresenter presenter;
    private ListView listView;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        floatingActionButton = findViewById(R.id.floatingActionButton);

        presenter = new NoteListPresenter(this);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickedOnButton();
            }
        });
    }

    @Override
    public void showNotes(List<Note> notes) {
        //TODO отображение в адаптере и привязка адаптера к listView
    }

    @Override
    public void openCreateNoteScreen() {
        Intent intent = new Intent(getApplicationContext(), EditNoteActivity.class);
        startActivity(intent);
    }

    @Override
    public void openEditNoteScreen(int id) {
        Intent intent = new Intent(getApplicationContext(), EditNoteActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_NOTE_ID", id);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}