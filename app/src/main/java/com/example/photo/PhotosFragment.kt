package com.example.photo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_page.*


class PhotosFragment : Fragment(), PhotoAdapter.onItemClickListener {

    override fun onItemClick(item: Photo) {
        Toast.makeText(context,item.name, Toast.LENGTH_SHORT).show()
    }

    val photos : ArrayList<Photo> = ArrayList()

    companion object {
        const val ARG_PAGE = "ARG_PAGE"
    }

    var mPage : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setPhotos()

        if (arguments != null){
            mPage = arguments!!.getInt(ARG_PAGE)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_page, container, false)
        return view
    }


    fun newInstance (page : Int) : PhotosFragment {
        val args = Bundle()
        args.putInt(ARG_PAGE,page)
        val fragment = PhotosFragment()
        fragment.arguments(args)
        return fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvUserList.apply {
            layoutManager = GridLayoutManager(activity,3)
            adapter = PhotoAdapter(activity,photos, this@PhotosFragment)
        }
    }

    fun setPhotos (){
        photos.add(Photo("one", R.drawable.birdy))
        photos.add(Photo("two", R.drawable.kitty))
        photos.add(Photo("three", R.drawable.birdy))
        photos.add(Photo("four", R.drawable.kitty))
        photos.add(Photo("five", R.drawable.birdy))

        photos.add(Photo("one", R.drawable.birdy))
        photos.add(Photo("two", R.drawable.kitty))
        photos.add(Photo("three", R.drawable.birdy))
        photos.add(Photo("four", R.drawable.kitty))
        photos.add(Photo("five", R.drawable.birdy))

        photos.add(Photo("one", R.drawable.birdy))
        photos.add(Photo("two", R.drawable.kitty))
        photos.add(Photo("three", R.drawable.birdy))
        photos.add(Photo("four", R.drawable.kitty))
        photos.add(Photo("five", R.drawable.birdy))

        photos.add(Photo("one", R.drawable.birdy))
        photos.add(Photo("two", R.drawable.kitty))
        photos.add(Photo("three", R.drawable.birdy))
        photos.add(Photo("four", R.drawable.kitty))
        photos.add(Photo("five", R.drawable.birdy))
    }
}

private operator fun Bundle?.invoke(args: Bundle) {
    //wut
}



