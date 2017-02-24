package adapter


import adapter.holder.FlickrHolder
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import model.Photo
import java.util.*

/**
 * Created by jeonggyuoh on 2017. 2. 24..
 */
class FlickrRecyclerViewAdapter :Adapter<FlickrHolder>() {

    private var photos :MutableList<Photo> = ArrayList()

    override fun getItemCount() = photos.size


    override fun onBindViewHolder(holder: FlickrHolder?, position: Int) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FlickrHolder {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun getItem(index :Int) = photos.get(index)


    fun addItems(list :List<Photo>){
        for (photo in list) {
            if(!photos.contains(photo)) photos.add(photo)
            Log.i("item",photo.id)
        }

    }

}