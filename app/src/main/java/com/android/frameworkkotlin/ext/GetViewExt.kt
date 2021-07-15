package com.android.frameworkkotlin.ext

import android.annotation.SuppressLint
import androidx.appcompat.widget.Toolbar
import com.android.frameworkkotlin.R

@SuppressLint("ResourceAsColor")
fun Toolbar.init(titleStr: String = ""): Toolbar {
    setBackgroundColor(R.color.colorPrimary)
    title = titleStr
    return this
}