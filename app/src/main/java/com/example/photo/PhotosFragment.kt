package com.example.photo

import android.annotation.SuppressLint
import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.photos_fragment_page.*


class PhotosFragment : Fragment(), PhotoAdapter.onItemClickListener {

    companion object {
        const val ARG_PAGE = "ARG_PAGE"
        const val REQUEST_ADD_PHOTO = 1
    }

    val photos : ArrayList<Photo> = ArrayList()
    var mPage : Int = 0

    override fun onItemClick(item: Photo) {
        val builder = AlertDialog.Builder(this.activity!!)
        builder.setTitle("info")
//            .setNegativeButton("OK",
//                DialogInterface.OnClickListener { dialog, which ->
//                    Toast.makeText(context,"id: "+item.id+"\nname: "+item.name, Toast.LENGTH_LONG).show() })

//            .setPositiveButton("add", DialogInterface.OnClickListener {
//                    dialog, which ->
//
//                    val intent = Intent(activity,AddPhotoActivity::class.java)
//                    startActivityForResult(intent,REQUEST_ADD_PHOTO)
//
//            })
            .setMessage("id: "+item.id+"\nname: "+item.name)
        builder.create().show()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_ADD_PHOTO){
            if (resultCode == Activity.RESULT_OK){
                Toast.makeText(activity, data?.getStringExtra(AddPhotoActivity.EXTRA_DESK), Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setPhotos()

        if (arguments != null){
            mPage = arguments!!.getInt(ARG_PAGE)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.photos_fragment_page, container, false)

        return view
    }

    fun newInstance (page : Int) : PhotosFragment {
        val args = Bundle()
        args.putInt(ARG_PAGE,page)
        val fragment = PhotosFragment()
        fragment.arguments(args)
        return fragment
    }

    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //(activity!!.findViewById(R.id.but_add_photo) as FloatingActionButton).visibility = FloatingActionButton.VISIBLE

        but_add_photo.setOnClickListener {
            val intent = Intent(activity,AddPhotoActivity::class.java)
            startActivityForResult(intent,REQUEST_ADD_PHOTO)
        }
        rvUserList.apply {
            layoutManager = GridLayoutManager(activity,3)
            adapter = PhotoAdapter(activity,photos, this@PhotosFragment)
        }
    }

    fun setPhotos (){
        photos.add(Photo(1, "one", R.drawable.birdy))
        photos.add(Photo(2, "two", R.drawable.kitty))
        photos.add(Photo(3, "three", R.drawable.birdy))
        photos.add(Photo(4, "four", R.drawable.kitty))
        photos.add(Photo(5,"five", R.drawable.birdy))
    }
}

private operator fun Bundle?.invoke(args: Bundle) {
    //wut
}



