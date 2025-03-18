package com.example.m2tmdbapp2025

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View


class ScoreGaugeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val LOGTAG = ScoreGaugeView::class.simpleName

    // hold XML custom attributes
    private var scoreMax:Float
    private var scoreValue:Float
    private var scoreLabel:String?
    private var scoreColor:Int

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ScoreGaugeView)
        scoreMax = typedArray.getFloat(R.styleable.ScoreGaugeView_scoreMax, 100f)
        scoreValue = typedArray.getFloat(R.styleable.ScoreGaugeView_scoreValue, 75f)
        scoreLabel = typedArray.getString(R.styleable.ScoreGaugeView_scoreLabel)
        if (scoreLabel == null) scoreLabel = if (isInEditMode) context.getString(R.string.no_label) else ""
        scoreColor = typedArray.getColor(R.styleable.ScoreGaugeView_scoreColor, Color.GREEN)
        typedArray.recycle()
    }

}