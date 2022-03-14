package com.hfad.newnotesmvp.ui.notelist;

import static androidx.recyclerview.widget.RecyclerView.NO_POSITION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.hfad.newnotesmvp.R;
import com.hfad.newnotesmvp.data.model.Note;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    private List<Note> notes;
   OnNoteClickListener clickListener;

    public NotesAdapter(OnNoteClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        if (position != NO_POSITION) {
            Note note = notes.get(position);
            if (note != null) {
                holder.bind(note);
            }
        }
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
