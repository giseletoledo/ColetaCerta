package br.com.androiddev.model

data class Shift(
    val shiftType: String,
    val time: String,
    var notificationEnabled: Boolean = false,
    val daysOfWeek: List<String>
)
