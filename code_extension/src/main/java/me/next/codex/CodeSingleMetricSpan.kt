package me.next.codex

import android.text.TextPaint
import android.text.style.MetricAffectingSpan

import ru.noties.markwon.spans.SpannableTheme

/**
 * <pre>
 * author : NeXT
 * time   : 2018/12/11
 * desc   :
 * </pre> *
 */
class CodeSingleMetricSpan(private val theme: SpannableTheme) : MetricAffectingSpan() {

    override fun updateDrawState(textPaint: TextPaint) {
        apply(textPaint)
    }

    override fun updateMeasureState(textPaint: TextPaint) {
        apply(textPaint)
    }

    private fun apply(p: TextPaint) {
        theme.applyCodeTextStyle(p, false)
    }

}
