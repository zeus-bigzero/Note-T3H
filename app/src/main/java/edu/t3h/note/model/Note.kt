package edu.t3h.note.model

// Định nghĩa đối tượng: Nó phải có những thuộc tính gì?
data class Note(
    val id: Long = System.currentTimeMillis(), // định danh. chỉ nó.
    var title: String, // title notes
    val des: String, // des note
    val colorResId: Int = -1, // color display
    var isFavorite: Boolean = false,
    var isHidden: Boolean = false,
    var isFlag: Boolean = true
)
