package com.hfad.newnotesmvp.ui.notelist;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hfad.newnotesmvp.R;
import com.hfad.newnotesmvp.data.model.Note;
import com.hfad.newnotesmvp.ui.editnote.EditNoteActivity;
import java.util.List;

public class NoteListActivity extends AppCompatActivity implements NoteListContract.INoteListView {

    private RecyclerView rvNotes;
    private FloatingActionButton floatingActionButton;

    private final NotesAdapter adapter = new NotesAdapter(new OnNoteClickListener() {
        @Override
        public void onNoteClick(Note note) {
            presenter.openNoteClick(note);
        }

        @Override
        public void onLongNoteClick(Note note) {
            presenter.onLongClick(note);
        }
    });

    private NoteListContract.INoteListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvNotes = findViewById(R.id.rvNotes);
        floatingActionButton = findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickedOnButton();
            }
        });

        rvNotes.setLayoutManager(new LinearLayoutManager(this));
        rvNotes.setAdapter(adapter);

        presenter = new NoteListPresenter(this, getApplicationContext());
    }

    @Override
    public void showNotes(List<Note> notes) {
        adapter.setNotes(notes);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(getApplicationContext(), EditNoteActivity.class);
//                intent.putExtra("noteId", position);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    public void openCreateNoteScreen() {
        Intent intent = new Intent(getApplicationContext(), EditNoteActivity.class);
        startActivity(intent);
    }

    @Override
    public void openEditNoteScreen(String uuid) {
        Intent intent = new Intent(getApplicationContext(), EditNoteActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("KEY_NOTE_ID", uuid);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void showDeleteDialog(Note note) {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Are you sure?")
                .setMessage("Do you want to delete this note?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        presenter.deleteNote(note);
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadNotes();
    }
}