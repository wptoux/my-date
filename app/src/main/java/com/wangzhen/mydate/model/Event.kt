package com.wangzhen.mydate.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import java.util.*

@Entity
data class Event(
        @Id var id: Long = 0,
        val eventName: String,
        val eventType: String,
        val dateTime: Date,
        val bRepeatYear: Boolean,
        val bRepeatMonth: Boolean,
        val bRepeatWeek: Boolean,
        val bRepeatDay: Boolean,
        val icon: String?,
        val splash: String?
)