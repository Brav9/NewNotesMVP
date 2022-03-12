package com.hfad.newnotesmvp.ui.editnote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.hfad.newnotesmvp.R;

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
        etMultiLine = (EditText) findViewById(R.id.etTextMultiLine);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.saveNote(etMultiLine.getText().toString());
            }
        });
//        etMultiLine.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                presenter.updateNote(etMultiLine.getText().toString());
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//        Bundle bundle = getIntent().getExtras();
//        String tittle = bundle.getString("key1", "");
    }


    @Override
    public void updateNote() {

    }

    @Override
    public void closeEditNoteScreen() {
        finish();
    }
}