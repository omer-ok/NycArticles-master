package com.test.nyarticles.utilz

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

inline fun <reified T> genericCastOrNull(anything: Any?):T? {
    return anything as? T
}

fun Context.toast(message:String){
    Toast.makeText(this,message,Toast.LENGTH_LONG).show()
}

fun ProgressBar.show(){
    visibility = View.VISIBLE
}
fun ProgressBar.hide(){
    visibility = View.GONE
}