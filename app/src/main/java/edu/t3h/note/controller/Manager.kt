package edu.t3h.note.controller

import android.provider.ContactsContract.CommonDataKinds.Note
import edu.t3h.note.model.NoteModel

object Manager {
    var step = 0
    var title = ""
    var des = ""
    var note : NoteModel? = null
}