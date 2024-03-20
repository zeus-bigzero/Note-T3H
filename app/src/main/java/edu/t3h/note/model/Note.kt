package edu.t3h.note.model

import androidx.annotation.ColorRes

data class Note(
    val title: String,
    val content: String,
    @ColorRes var color: Int = android.R.color.white,
    var isFavorite: Boolean = false,
    var isHidden: Boolean = false,
    var isDeleted: Boolean = false,
//    @DrawableRes var backGround: Int = R.drawable.rectangle4
)

