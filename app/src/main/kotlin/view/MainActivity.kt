package view

import adapter.FlickrRecyclerViewAdapter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import com.mvp.ojk.mvpractice.R
import model.Photo
import presenter.MainPresenter
import presenter.MainPresenterImpl

open class MainActivity : AppCompatActivity(), MainPresenter.View, OnClickListener{

    var presenter :MainPresenterImpl = MainPresenterImpl(this)

    private val textView by lazy {
        findViewById(R.id.textView) as TextView
    }

    private val recyclerView by lazy { 
        findViewById(R.id.recyclerView) as RecyclerView
    }

    private var flickrRecyclerViewAdapter :FlickrRecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        initRecyclerView()
    }

    override fun onClick(v: View?) {
        presenter.sendToPresenter()
    }
    
    fun init() {
        findViewById(R.id.button).setOnClickListener(this)
    }
    
    fun initRecyclerView() {
        flickrRecyclerViewAdapter = FlickrRecyclerViewAdapter(this)
        recyclerView.adapter = flickrRecyclerViewAdapter
        recyclerView.layoutManager = GridLayoutManager(this,2)
    }


    override fun onDataReceived(data: String) {
        textView.text = data
    }


    override fun onPhotosReceived(data: List<Photo>) {

        flickrRecyclerViewAdapter?.addItems(data)

    }

    override fun onError(throwable: Throwable) {
        Log.i("onError", throwable.message)
    }
}
