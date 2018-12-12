package me.next.codex

import android.text.Spannable
import android.text.style.ForegroundColorSpan

import org.commonmark.node.Code

import ru.noties.markwon.SpannableBuilder
import ru.noties.markwon.SpannableConfiguration
import ru.noties.markwon.renderer.SpannableMarkdownVisitor
import ru.noties.markwon.spans.SpannableTheme

/**
 * <pre>
 * author : NeXT
 * time   : 2018/12/11
 * desc   :
 * </pre> *
 */
class CodeVisitor(
    configuration: SpannableConfiguration,
    private val builder: SpannableBuilder,
    private val theme: SpannableTheme,
    private val codeTextColor: Int
) : SpannableMarkdownVisitor(configuration, builder) {

    override fun visit(code: Code) {
        val length = builder.length

        // NB, in order to provide a _padding_ feeling code is wrapped inside two unbreakable spaces
        // unfortunately we cannot use this for multiline code as we cannot control where a new line break will be inserted
        builder.append('\u00a0')
        builder.append(code.literal)
        val lengthEnd = builder.length
        builder.run {
            setSpan(
                    CodeSingleMetricSpan(theme), length + 1, lengthEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            setSpan(
                    ForegroundColorSpan(codeTextColor),
                    length + 1,
                    lengthEnd,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            append('\u00a0')
        }
    }
}
