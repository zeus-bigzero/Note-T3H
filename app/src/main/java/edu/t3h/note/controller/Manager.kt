package edu.t3h.note.controller

import edu.t3h.note.model.NoteModel

object Manager {
    var step = 0
    var title = ""
    var des = ""
    var listNotes = arrayListOf<NoteModel>()
}