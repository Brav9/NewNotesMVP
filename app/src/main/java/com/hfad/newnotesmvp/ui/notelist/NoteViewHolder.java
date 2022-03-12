package com.hfad.newnotesmvp.ui.notelist;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.newnotesmvp.R;
import com.hfad.newnotesmvp.data.model.Note;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    TextView tvNoteText;
    TextView tvUuid;
    Note currentNote;

    public NoteViewHolder(@NonNull View itemView, OnNoteClickListener clickListener) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onNoteClick(currentNote);
            }
        });
        tvNoteText = itemView.findViewById(R.id.tvNoteText);
        tvUuid = itemView.findViewById(R.id.tvUuid);
    }

    public void bind(Note note) {
        currentNote = note;
        tvNoteText.setText(note.getValue());
        tvUuid.setText(note.getUuid());
    }
}
