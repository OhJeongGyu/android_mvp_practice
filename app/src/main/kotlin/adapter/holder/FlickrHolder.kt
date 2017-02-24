package adapter.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.mvp.ojk.mvpractice.R

/**
 * Created by jeonggyuoh on 2017. 2. 24..
 */
class FlickrHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    private val imageViewOnItem by lazy {
        itemView?.findViewById(R.id.imageViewOnItem)
    }

    private val titleTextView  by lazy {
        itemView?.findViewById(R.id.titleTextView)

    }
}