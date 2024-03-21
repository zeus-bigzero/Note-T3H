package edu.t3h.note.listener

import edu.t3h.note.model.Note

interface OnNoteClickListener {
    fun onNoteClick(note: Note)
    fun onNoteLongClick(note: Note)
}