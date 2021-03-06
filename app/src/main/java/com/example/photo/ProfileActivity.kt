package com.example.photo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

/*
*
* Сделать кнопку для добавления картинки:
*   нажать на кнопку
*   новая активити -> название и выбор картинки
*   кнопка создать
*   вернуться в первоначальную активити
*
 */
class ProfileActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        getSupportActionBar()!!.setElevation(0.0f)

        val fragmentAdapter =
            SampleFragmentPagerAdapter(supportFragmentManager)

        viewpager.adapter = fragmentAdapter
        tabs_main.setupWithViewPager(viewpager)


//MB все же в фрагменте?
        val userDBProvider = UserDBProvider()
        userDBProvider.initConnection(this)

        var userList = userDBProvider.GetAllUsers()
    }

}


