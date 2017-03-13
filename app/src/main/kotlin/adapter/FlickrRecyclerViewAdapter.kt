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
import android.widget.Toast
import com.bumptech.glide.Glide
import com.mvp.ojk.mvpractice.R
import kotlinx.android.synthetic.main.item_flickr_recycler_view.view.*
import model.Photo
import presenter.MainContract
import java.util.*

/**
 * Created by jeonggyuoh on 2017. 2. 24..
 */
class FlickrRecyclerViewAdapter(private val context: Context):
        Adapter<FlickrHolder>(), MainContract.AdapterModel {


    private val photos: MutableList<Photo> = ArrayList(0)

    override fun getItemCount() = photos.size


    override fun onBindViewHolder(holder: FlickrHolder, position: Int) {

        Glide.with(context)
                .load(makeUrl(photos[position]))
                .centerCrop()
                .into(holder.imageViewOnItem)

        holder.titleTextView.text = photos[position].title


    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FlickrHolder
            = FlickrHolder(LayoutInflater.from(context).inflate(R.layout.item_flickr_recycler_view, parent, false))


    private fun makeUrl(photo :Photo) :String{
        return "http://farm${photo.farm}.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}.jpg"
    }


    fun addItems(list :List<Photo>){
        list.filterNot { photos.contains(it) }
            .forEach { photos.add(it) }
        notifyDataSetChanged()
    }


    override fun onPhotosReceived(data: List<Photo>) {
        addItems(data)
    }

    override fun onError(throwable: Throwable) {
        Toast.makeText(context, throwable.message, Toast.LENGTH_SHORT).show()
    }

}