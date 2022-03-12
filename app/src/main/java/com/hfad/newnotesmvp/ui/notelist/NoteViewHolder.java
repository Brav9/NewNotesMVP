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

    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);

        tvNoteText = itemView.findViewById(R.id.tvNoteText);
        tvUuid = itemView.findViewById(R.id.tvUuid);
    }

    public void bind(Note note) {
        tvNoteText.setText(note.getValue());
        tvUuid.setText(note.getUuid());
    }
}
