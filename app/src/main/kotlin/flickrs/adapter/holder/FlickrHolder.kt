package flickrs.adapter.holder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mvp.ojk.mvpractice.R

/**
 * Created by jeonggyuoh on 2017. 2. 24..
 */
class FlickrHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    internal val imageViewOnItem by lazy {
        itemView.findViewById(R.id.imageViewOnItem) as ImageView
    }

    internal val titleTextView  by lazy {
        itemView.findViewById(R.id.titleTextView) as TextView
    }

}