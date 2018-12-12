package me.next.markwoncodeex

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import me.next.codex.CodeVisitor
import ru.noties.markwon.Markwon
import ru.noties.markwon.SpannableBuilder
import ru.noties.markwon.SpannableConfiguration
import ru.noties.markwon.spans.SpannableTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvContent = findViewById<TextView>(R.id.tv_content)

        val builder = SpannableBuilder()
        val spannableTheme = SpannableTheme.builderWithDefaults(this)
            .codeBlockTextColor(resources.getColor(R.color.codeTextColor))
            .codeBlockBackgroundColor(resources.getColor(R.color.codeBackgroundColor)).build()
        val spannableBuilder = SpannableConfiguration.builder(this).theme(spannableTheme).build()
        val visitor = CodeVisitor(
            spannableBuilder,
            builder,
            spannableTheme,
            resources.getColor(R.color.codeTextColor) // code text color
        )
        Markwon.createParser().parse(
//            "# Markwon\n" +
//            "## Markwon\n" +
//            "### Markwon\n" +
//            "#### Markwon\n" +
//            "##### Markwon\n" +
            "`test`aaa`test`bbb`test`ccc`testtesttesttesttesttest`\n" +
            "`asasasasasasasasasasasasasasasasasasasasasasasasasasasasa`\n" +
            "```\n" +
            "asas\n" +
            "asasasasasas\n" +
            "asasasasasasasas\n" +
            "asasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasasas\n" +
            "```"
        ).accept(visitor)

        tvContent.text = builder.text()
    }

}
