package com.example.myapplication.utils

import android.content.Context
import android.view.View
import android.widget.Toast


fun Context.showToast(msg: Any) {

    Toast.makeText(
        applicationContext, if (msg is Int) {
            getString(msg)
        } else {
            msg as String
        }, Toast.LENGTH_SHORT
    ).show()


}




 fun View.hide ()
 {
     if(this.visibility==View.VISIBLE)
     this.visibility=View.GONE
 }
fun View.show ()
 {
     if(this.visibility==View.GONE)
     this.visibility=View.VISIBLE
 }