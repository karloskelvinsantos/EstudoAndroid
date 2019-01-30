package com.example.kelvinsantos.youcandraw

import android.graphics.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val paint by lazy {
        val paint = Paint()
        paint.isAntiAlias = true
        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        paint.strokeJoin = Paint.Join.ROUND
        paint.strokeWidth = 10f
        paint
    }

    val bitmap by lazy {
        Bitmap.createBitmap(draw.width, draw.height, Bitmap.Config.ARGB_8888)
    }

    val canvas by lazy {
        Canvas(bitmap)
    }

    val path by lazy {
        Path()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupImageView()
    }

    private fun setupImageView() {
        draw.post { draw.setImageBitmap(bitmap) }
        draw.setOnTouchListener { _, event ->

            val x = event.x
            val y = event.y

            when(event.actionMasked) {
                MotionEvent.ACTION_DOWN -> {
                    //desenhar um ponto
                    fingerDrown(x, y)
                }
                MotionEvent.ACTION_MOVE -> {
                    fingerDrag(x, y)
                }

            }

            true
        }
    }

    private fun fingerDrown(x: Float, y: Float) {
        path.reset()
        path.moveTo(x, y)
        canvas.drawPoint(x, y, paint)
        draw.invalidate()
    }

    private fun fingerDrag(x: Float, y: Float) {
        path.lineTo(x, y)
        canvas.drawPath(path, paint)
        draw.invalidate()
    }
}
