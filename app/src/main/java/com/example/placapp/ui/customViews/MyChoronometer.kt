package com.example.placapp.ui.customViews

import android.content.Context
import android.os.SystemClock
import android.util.AttributeSet
import android.widget.Chronometer

class MyChronometer : Chronometer {

    private var lastPause: Long = 0

    init {
        lastPause = SystemClock.elapsedRealtime()
    }
    var isRunning = false
        // somente aqui esta classe pode ser setada
        private set

    // construtores base para construção da view w usar no xml
    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {}

    // sobrescrevendo os métodos de start e stop do cronômetro existente
    override fun start() {
        super.start()
        this.base = this.base + SystemClock.elapsedRealtime() - lastPause
        isRunning = true
    }

    override fun stop() {
        super.stop()
        lastPause = SystemClock.elapsedRealtime()
        isRunning = false
    }

}