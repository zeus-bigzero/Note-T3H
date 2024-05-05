package edu.t3h.note.listener

import edu.t3h.note.model.NoteModel

interface OnNoteClickListener {
    fun onClickNote(note: NoteModel)

    fun onLongClickNote(note: NoteModel)
}