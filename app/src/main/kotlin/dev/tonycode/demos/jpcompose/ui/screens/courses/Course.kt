package dev.tonycode.demos.jpcompose.ui.screens.courses


data class Course(

    val id: Int,

    val title: String,

    val coverUrl: String,

    val lessons: Int,

    val tags: List<String>

)
