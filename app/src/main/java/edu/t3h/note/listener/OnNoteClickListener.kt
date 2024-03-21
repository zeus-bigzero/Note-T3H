package edu.t3h.note.listener

import edu.t3h.note.model.Note

interface OnNoteClickListener {
    fun onClickNote(note: Note)

    fun onLongClickNote(note: Note)
}