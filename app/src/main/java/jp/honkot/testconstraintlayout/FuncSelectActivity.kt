package jp.honkot.testconstraintlayout

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View

class FuncSelectActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_func_select)
    }

    fun onClickedMoveToImagePlaceHolder(@Suppress("UNUSED_PARAMETER") view: View) {
        startActivity(Intent(this, ImagePlaceHolderActivity::class.java))
    }

    fun onClickedMoveToTextPlaceHolder(@Suppress("UNUSED_PARAMETER") view: View) {
        startActivity(Intent(this, TextPlaceHolderActivity::class.java))
    }
}
