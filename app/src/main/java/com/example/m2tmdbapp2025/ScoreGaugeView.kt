package com.example.m2tmdbapp2025

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View

/**
 * TODO: document your custom view class.
 */
class ScoreGaugeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
        textSize = 50f
        textAlign = Paint.Align.CENTER
    }

    private val circlePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLUE
        style = Paint.Style.FILL
    }

    private val arcPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
        style = Paint.Style.STROKE
        strokeWidth = 20f
    }

    private var score: Float = 0f

    init {
        // Load custom attributes if any
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ScoreGaugeView,
            0, 0
        ).apply {
            try {
                // Initialize custom attributes here if needed
            } finally {
                recycle()
            }
        }
    }
}