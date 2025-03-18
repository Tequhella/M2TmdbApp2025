package com.example.m2tmdbapp2025

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import kotlin.math.abs
import kotlin.math.min


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

    // Paint styles used for rendering are initialized here to improve performance,
    // since onDraw() is called for every screen refresh.
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = context.resources.getDimension(R.dimen.score_gauge_view_label)
        typeface = Typeface.create(null as String?, Typeface.BOLD)
    }

    // compute dimensions to be used for drawing text
    private val fontMetrics = paint.fontMetrics
    private val textHeight = abs(paint.fontMetrics.ascent + fontMetrics.descent)

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ScoreGaugeView)
        scoreMax = typedArray.getFloat(R.styleable.ScoreGaugeView_scoreMax, 100f)
        scoreValue = typedArray.getFloat(R.styleable.ScoreGaugeView_scoreValue, 75f)
        scoreLabel = typedArray.getString(R.styleable.ScoreGaugeView_scoreLabel)
        if (scoreLabel == null) scoreLabel = if (isInEditMode) context.getString(R.string.no_label) else ""
        scoreColor = typedArray.getColor(R.styleable.ScoreGaugeView_scoreColor, Color.GREEN)
        typedArray.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        // requested width and height
        val reqWidth = MeasureSpec.getSize(widthMeasureSpec)
        val reqHeight = MeasureSpec.getSize(heightMeasureSpec)

        // your choice
        val desiredWidth: Int = reqWidth
        val desiredHeight: Int = (textHeight * 2.5).toInt()

        val width = when (MeasureSpec.getMode(widthMeasureSpec)) {
            MeasureSpec.EXACTLY -> reqWidth
            MeasureSpec.UNSPECIFIED -> desiredWidth
            else -> min(reqWidth, desiredWidth) // AT_MOST condition
        }
        val height = when (MeasureSpec.getMode(heightMeasureSpec)) {
            MeasureSpec.EXACTLY -> reqHeight
            MeasureSpec.UNSPECIFIED -> desiredHeight
            else -> min(reqHeight, desiredHeight) // AT_MOST condition
        }

        // set the width and the height of the view
        if (isInEditMode) {
            setMeasuredDimension(desiredWidth, desiredHeight)
        } else {
            setMeasuredDimension(width, height)
        }
    }

}