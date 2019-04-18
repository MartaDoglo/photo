package com.example.photo

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

open class SampleFragmentPagerAdapter (fm : FragmentManager) : FragmentPagerAdapter(fm) {

    val tabTitles = arrayOf<String>("Tab1", "Tab2", "Tab3")


    companion object {
        const val PAGE_COUNT = 3
    }


    override fun getItem(p0: Int): Fragment {
        return when (p0) {
            0 -> {
                PhotosFragment()
            }
            1 -> TempFragment()
            else -> {

                return PhotosFragment()
            }
        }
    }

    override fun getCount(): Int {
        return PAGE_COUNT
    }

    override fun getPageTitle (position : Int) : CharSequence{
        return when (position) {
            0 -> "First Tab"
            1 -> "Second Tab"
            else -> {
                return "Third Tab"
            }
        }
    }

}