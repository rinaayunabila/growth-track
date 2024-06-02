package com.capstone.growthtrack.ui.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Typeface
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Patterns
import android.view.View
import androidx.appcompat.widget.AppCompatEditText

class edtEmail : AppCompatEditText {

    constructor(context: Context) : super(context) { init() }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) { init() }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) { init() }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        hint = "Enter Your Email"
        textAlignment = View.TEXT_ALIGNMENT_VIEW_START
        setHintTextColor(Color.GRAY)
        setTextColor(Color.BLACK)
        setTextSize(16f)
        typeface = Typeface.SANS_SERIF
        setBackgroundResource(android.R.drawable.edit_text)
        setCompoundDrawablesWithIntrinsicBounds(0, 0, android.R.drawable.ic_menu_send, 0)
    }

    private fun init() {
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (Patterns.EMAIL_ADDRESS.matcher(s).matches()) {
                    showError(null)
                } else {
                    showError("Must be in email format")
                }
            }
        })
    }

    private fun showError(errorMessage: String?) {
        error = errorMessage
    }
}
