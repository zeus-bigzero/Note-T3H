package edu.t3h.note;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteViewHolderV2 extends RecyclerView.ViewHolder {

    public NoteViewHolderV2(@NonNull View itemView) {
        super(itemView);
    }

    public NoteViewHolderV2(@NonNull View itemView, String s) {
        super(itemView);
    }

    public NoteViewHolderV2(@NonNull View itemView, String s, int a) {
        super(itemView);
    }
}
