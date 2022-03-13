package com.hfad.newnotesmvp.ui.editnote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hfad.newnotesmvp.R;
import com.hfad.newnotesmvp.data.model.Note;

public class EditNoteActivity extends AppCompatActivity implements EditNoteContract.IEditNoteView {

    EditNoteContract.IEditNotePresenter presenter;

    private Button btnSave;
    private EditText etMultiLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_aditor);

        presenter = new EditNotePresenter(this, getApplicationContext());

        btnSave = findViewById(R.id.btnSave);
        etMultiLine = findViewById(R.id.etTextMultiLine);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.saveNote(etMultiLine.getText().toString());
            }
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String uuid = bundle.getString("KEY_NOTE_ID", "");
            presenter.loadNote(uuid);
        }
    }

    @Override
    public void closeEditNoteScreen() {
        finish();
    }

    @Override
    public void showNote(Note note) {
        etMultiLine.setText(note.getValue());
    }
}