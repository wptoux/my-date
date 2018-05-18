package com.wangzhen.mydate.presentation

import android.app.Application
import com.wangzhen.mydate.model.Event
import com.wangzhen.mydate.model.MyObjectBox
import io.objectbox.kotlin.boxFor
import java.util.*

class EventManager(app: Application){
    private val _boxStore = MyObjectBox.builder().androidContext(app).build()!!
    private val _eventBox = _boxStore.boxFor<Event>()

    fun getEvents(year:Int, month:Int, day:Int): List<Event>{
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day)
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)

        val query = _eventBox.query()
                .filter{event->
                    val calEvent = Calendar.getInstance()
                    calEvent.time = event.dateTime

                    val calY = calEvent.get(Calendar.YEAR)
                    val calM = calEvent.get(Calendar.MONTH)
                    val calD = calEvent.get(Calendar.DAY_OF_MONTH)
                    val calDW = calEvent.get(Calendar.DAY_OF_WEEK)

                    if (calY == year && calM == month && calD == day){
                        true
                    }
                    else if (event.bRepeatYear && calM == month && calD == day){
                        true
                    }
                    else if (event.bRepeatMonth && calD == day){
                        true
                    }
                    else if (event.bRepeatWeek && calDW == dayOfWeek){
                        true
                    }
                    else event.bRepeatDay
                }
                .build()

        return query.find()
    }

    fun addEvent(event: Event){
        _eventBox.put(event)
    }
}