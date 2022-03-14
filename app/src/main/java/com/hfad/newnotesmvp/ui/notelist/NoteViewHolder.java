package com.hfad.newnotesmvp.ui.notelist;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.hfad.newnotesmvp.R;
import com.hfad.newnotesmvp.data.model.Note;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    final TextView tvNoteText;
    Note currentNote;

    public NoteViewHolder(@NonNull View itemView, OnNoteClickListener clickListener) {
        super(itemView);
        itemView.setOnClickListener(v -> clickListener.onNoteClick(currentNote));

        itemView.setOnLongClickListener(v -> {
            clickListener.onLongNoteClick(currentNote);
            return true;
        });
        tvNoteText = itemView.findViewById(R.id.tvNoteText);
    }

    public void bind(Note note) {
        currentNote = note;
        tvNoteText.setText(note.getValue());
    }
}
