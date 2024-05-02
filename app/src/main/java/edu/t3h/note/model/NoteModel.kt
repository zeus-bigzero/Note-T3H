package edu.t3h.note.model

import com.google.gson.Gson

data class NoteModel(
    val id: Long = System.currentTimeMillis(),
    val title: String,
    val des: String,
    val colorResID : String,
    val isFavourite: Boolean = false,
    val isHidden: Boolean = false,
    val isTrash: Boolean = false
) {

    override fun toString(): String {
        return "{\"id\":$id,\"title\":$title,\"des\":$des,\"colorResID\":$colorResID,\"isFavourite\":$isFavourite,\"isHidden\":$isHidden,\"isTrash\":$isTrash}"
    }
}

