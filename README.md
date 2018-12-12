[![](https://jitpack.io/v/kingideayou/MarkwonCodeEx.svg)](https://jitpack.io/#kingideayou/MarkwonCodeEx)

# MarkwonCodeEx
Markwon extensition support elegant code background.   
为 [Markwon](https://github.com/noties/Markwon) 提供优雅的代码块显示效果

### Preview
![](http://ww1.sinaimg.cn/mw690/6db4aff6gy1fy3ye4p2f3j20to0upjwd.jpg)

## ProGuard
```groovy
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

```groovy
  implementation 'ru.noties:markwon:2.0.1' 
  implementation 'com.github.kingideayou:MarkwonCodeEx:1.0.0'
```

## Simple usage snippet
```kotlin
val builder = SpannableBuilder()
val visitor = CodeVisitor(
    spannableBuilder,
    builder,
    spannableTheme,
    resources.getColor(R.color.codeTextColor) //Note: code text color
)

Markwon.createParser().parse("a simple `code`").accept(visitor)
tvContent.text = builder.text()
```
### layout
```xml

<me.next.codex.roundedbg.RoundedBgTextView
        android:id="@+id/tv_content"
        style="@style/Widget.RoundedBackground.SampleTextView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
```
### style
```xml
<style name="Widget.RoundedBackground.SampleTextView">
    <item name="android:lineSpacingExtra">2dp</item>
    <item name="android:lineSpacingMultiplier">1.2</item>
    <item name="android:padding">4dp</item>
    <item name="android:textSize">18sp</item>
    <item name="android:includeFontPadding">true</item>
    <item name="roundedTextHorizontalPadding">2.6dp</item> <!-- code background padding-->
    <item name="roundedTextVerticalPadding">2dp</item>
</style>
```

## Thanks
This library is inspired by [noties/Markwon](https://github.com/noties/Markwon) & [googlesamples/android-text](https://github.com/googlesamples/android-text/tree/master/RoundedBackground-Kotlin) and uses some of its source code.  

## License

    Copyright 2018 NeXT.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
