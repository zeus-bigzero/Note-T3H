package edu.t3h.note.model

data class Note(
    val id: Long = System.currentTimeMillis(),
    val title: String,
    val des: String,
//    val colorResID: Int,
//    val isFavourite: Boolean = false,
//    val isHidden: Boolean = false,
//    val isFlag: Boolean = true
) {

}