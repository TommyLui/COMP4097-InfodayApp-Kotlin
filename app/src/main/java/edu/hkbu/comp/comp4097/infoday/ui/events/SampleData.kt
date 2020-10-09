package edu.hkbu.comp.comp4097.infoday.ui.events

import edu.hkbu.comp.comp4097.infoday.data.Dept
import edu.hkbu.comp.comp4097.infoday.data.Event

object SampleData {
    val DEPT = listOf(
        Dept("Computer Science", "COMP"),
        Dept("Communication Studies", "COMS")
    )
    val EVENT = listOf(
        Event(1, "COMP Welcome speech", "COMP"),
        Event(2, "COMP Exit speech", "COMP"),
        Event(3, "TV Show", "COMS"),
        Event(4, "TED Talk", "COMS")
    )
}