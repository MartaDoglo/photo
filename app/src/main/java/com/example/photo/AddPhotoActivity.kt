package com.example.photo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_add_photo.*

class AddPhotoActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_DESK = "answer"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_photo)

    }

    fun textClicked(view : View){
        if (!text.text.isEmpty()) {
            val res = Intent()
            res.putExtra(EXTRA_DESK, text.text.toString())
            setResult(Activity.RESULT_OK, res)
        } else {
            setResult(Activity.RESULT_CANCELED)
        }
        finish()
    }

}

