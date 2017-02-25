package adapter


import adapter.holder.FlickrHolder
import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mvp.ojk.mvpractice.R
import kotlinx.android.synthetic.main.item_flickr_recycler_view.view.*
import model.Photo
import java.util.*

/**
 * Created by jeonggyuoh on 2017. 2. 24..
 */
class FlickrRecyclerViewAdapter(var context : Context) :Adapter<FlickrHolder>() {

    var photos :MutableList<Photo> = ArrayList()

    override fun getItemCount() = photos.size


    override fun onBindViewHolder(holder: FlickrHolder, position: Int) {

        holder?.imageViewOnItem?.apply {
            Glide.with(context)
                    .load(makeUrl(photos?.get(position)))
                    .centerCrop()
                    .into(imageViewOnItem)
        }

        holder?.titleTextView?.apply {
            text = photos?.get(position)?.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FlickrHolder
            = FlickrHolder(LayoutInflater.from(context).inflate(R.layout.item_flickr_recycler_view, parent, false))


    fun makeUrl(photo :Photo) :String{

        return StringBuilder("http://farm")
                .append(photo.farm)
                .append(".staticflickr.com/")
                .append(photo.server)
                .append("/")
                .append(photo.id)
                .append("_")
                .append(photo.secret)
                .append(".jpg")
                .toString()

    }


    fun addItems(list :List<Photo>){
        for (photo in list) {
            if(!photos?.contains(photo)) photos?.add(photo)
        }
        notifyDataSetChanged()
    }



}