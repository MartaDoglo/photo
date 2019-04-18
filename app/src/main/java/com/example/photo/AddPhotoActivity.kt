package com.example.photo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_photo.*

class AddPhotoActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_DESK = "answer"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_photo)


        et_choose.setOnClickListener {
            //
        }
    }



    fun buttonClicked(view : View){
        if (!et_name.text.isEmpty()) {
            val res = Intent()
            res.putExtra(EXTRA_DESK, button_add.text.toString())
            setResult(Activity.RESULT_OK, res)
            finish()
        } else {
            Toast.makeText(this, "Name is empty", Toast.LENGTH_SHORT).show()
            setResult(Activity.RESULT_CANCELED)
        }

    }

}

