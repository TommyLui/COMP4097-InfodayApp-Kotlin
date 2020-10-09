package edu.hkbu.comp.comp4097.infoday.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Event (
    @PrimaryKey
    val id: Int,
    val title: String,
    val deptId: String,
    var bookmarked:Boolean = false
) { } //the curly braces can be omitted.
