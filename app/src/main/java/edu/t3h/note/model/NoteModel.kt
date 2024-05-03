package edu.t3h.note.model

import com.google.gson.Gson

data class NoteModel(
    var id: Long = System.currentTimeMillis(),
    var title: String,
    var des: String,
    var colorResID : String,
    var isFavourite: Boolean = false,
    var isHidden: Boolean = false,
    var isTrash: Boolean = false
) {

    override fun toString(): String {
        return "{\"id\":$id,\"title\":$title,\"des\":$des,\"colorResID\":$colorResID,\"isFavourite\":$isFavourite,\"isHidden\":$isHidden,\"isTrash\":$isTrash}"
    }
}

