package com.hfad.newnotesmvp.ui.notelist;

import com.hfad.newnotesmvp.data.model.Note;

public interface OnNoteClickListener {

    void onNoteClick(Note note);
    void onLongNoteClick(Note note);

}
