package edu.t3h.note.model

import org.json.JSONObject

data class NoteModel(
    val id: Long,
    val title: String,
    val des: String,
    val colorResID : String,
    val isFavourite: Boolean = false,
    val isHidden: Boolean = false,
    val isTrash: Boolean = true
) {

    override fun toString(): String {
        return "{\"id\":$id,\"title\":$title,\"des\":$des,\"colorResID\":$colorResID,\"isFavourite\":$isFavourite,\"isHidden\":$isHidden,\"isTrash\":$isTrash}"
    }
}

fun String.convertStringToNoteModel() : NoteModel {
    val json = JSONObject(this)
    return NoteModel(
        id = json.getLong("id"),
        title = json.getString("title"),
        des = json.getString("des"),
        colorResID = json.getString("colorResID"),
        isFavourite = json.getBoolean("isFavourite"),
        isHidden = json.getBoolean("isHidden"),
        isTrash = json.getBoolean("isTrash"),
    )
}

