package edu.t3h.note

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.GridLayoutManager

class CustomLayoutManager @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyle: Int = 1,
    defStyleRes: Int = 0
) : GridLayoutManager(context, 2)  { //attr, defStyle, defStyleRes) {

    override fun setSpanSizeLookup(spanSizeLookup: SpanSizeLookup?) {
        super.setSpanSizeLookup(spanSizeLookup)


    }
    override fun getSpanSizeLookup(): SpanSizeLookup {
        return object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                if (position == 0 || position == 1) {
                    return 2
                }
                return 1
            }

        }
    }
}