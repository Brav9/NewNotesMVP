package com.hfad.newnotesmvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class NoteEditorActivity extends AppCompatActivity implements IContract.IViewNote {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_aditor);

        Bundle bundle = getIntent().getExtras();
        String tittle = bundle.getString("key1", "");
    }
}