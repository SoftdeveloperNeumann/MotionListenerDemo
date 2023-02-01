package com.example.motionlistenerdemo

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.TableLayout
import androidx.annotation.ColorRes
import androidx.core.view.MotionEventCompat
import com.example.motionlistenerdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var tableLayout: TableLayout

    fun Button.isPressed(x: Float, y: Float): Boolean {
        Log.d("TAG", "isPressed: $x : $y")
        val location = IntArray(2)
        getLocationOnScreen(location)
        val viewX = location[0] - width*0.2
        val viewY = location[1] - height*2
        Log.d("TAG", "${this.id}: $viewX : $viewY")
        return x > viewX && x < viewX + width && y > viewY && y < viewY + height
    }


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        tableLayout = findViewById(R.id.table)
//        val view = findViewById<View>(R.id.roottag)
//        val button1 = findViewById<Button>(R.id.button1)
//        val button2 = findViewById<Button>(R.id.button2)
//        val button3 = findViewById<Button>(R.id.button3)

        binding.root.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {

                }
                MotionEvent.ACTION_MOVE -> {
                    // Finger bewegt sich auf der Ansicht

                    val x = event.x
                    val y = event.y
                    Log.d("TAG", "onCreate: ${event.x} : ${event.y}")
                    with(binding) {
                        when {
                            button1.isPressed(x, y) -> button1.setBackgroundColor(Color.RED)
                            button2.isPressed(x, y) -> button2.setBackgroundColor(Color.RED)
                            button3.isPressed(x, y) -> button3.setBackgroundColor(Color.RED)
                            button4.isPressed(x, y) -> button4.setBackgroundColor(Color.RED)
                            button5.isPressed(x, y) -> button5.setBackgroundColor(Color.RED)
                            button6.isPressed(x, y) -> button6.setBackgroundColor(Color.RED)
                            button7.isPressed(x, y) -> button7.setBackgroundColor(Color.RED)
                            button8.isPressed(x, y) -> button8.setBackgroundColor(Color.RED)
                            button9.isPressed(x, y) -> button9.setBackgroundColor(Color.RED)
                            button10.isPressed(x, y) -> button10.setBackgroundColor(Color.RED)
                            button11.isPressed(x, y) -> button11.setBackgroundColor(Color.RED)
                            button12.isPressed(x, y) -> button12.setBackgroundColor(Color.RED)
                            button13.isPressed(x, y) -> button13.setBackgroundColor(Color.RED)
                            button14.isPressed(x, y) -> button14.setBackgroundColor(Color.RED)
                            button15.isPressed(x, y) -> button15.setBackgroundColor(Color.RED)
                            button16.isPressed(x, y) -> button16.setBackgroundColor(Color.RED)
                        }
                    }
                }
                MotionEvent.ACTION_UP -> {
                    // Finger wurde von der Ansicht entfernt
                }
                else -> return@setOnTouchListener false
            }
            true
        }
    }
}


