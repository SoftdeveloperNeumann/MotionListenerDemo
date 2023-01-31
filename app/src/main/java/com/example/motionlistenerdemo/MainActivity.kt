package com.example.motionlistenerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Button
import android.widget.TableLayout
import androidx.core.view.MotionEventCompat

class MainActivity : AppCompatActivity() {
    lateinit var tableLayout: TableLayout
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tableLayout = findViewById(R.id.table)
        button = findViewById<Button>(R.id.button1)


//        Log.d("TAGAUSGABE", "onCreate:position is ${position[0]} : ${position[1]} and size ${position.size}")

        button.setOnTouchListener { v, event ->
           when(event.action){
               MotionEvent.ACTION_DOWN -> {
                   Log.d("TAGAUSGABE", "onCreate:is down ")
                   var position  = IntArray(2)
                   button.getLocationInWindow(position)
                   Log.d("TAGAUSGABE", "onCreate:position is ${position[0]} : ${position[1]} and size ${position.size}")
                   positions.plus(position)
               }
               MotionEvent.ACTION_OUTSIDE-> Log.d("TAGAUSGABE", "onCreate: is enter ")
               MotionEvent.ACTION_UP-> Log.d("TAGAUSGABE", "onCreate: is up")
           }
            true
        }

    }


    override fun onStart() {
        super.onStart()
        var position  = IntArray(2)
        button.getLocationInWindow(position)
        Log.d("TAGAUSGABE", "onStart:position is ${position[0]} : ${position[1]} and size ${position.size}")
    }
}

val positions = Array<IntArray>(16)

fun <T> Array(size: Int): Array<T> {
    return Array<T>(size)
}
