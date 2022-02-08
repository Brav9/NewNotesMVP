package com.hfad.newnotesmvp.ui.editnote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;


import com.hfad.newnotesmvp.R;

public class EditNoteActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_aditor);

        EditText editText = (EditText) findViewById(R.id.etTextMultiLine);

//        Bundle bundle = getIntent().getExtras();
//        String tittle = bundle.getString("key1", "");
    }
}