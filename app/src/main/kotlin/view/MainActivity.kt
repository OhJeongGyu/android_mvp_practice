package view

import adapter.FlickrRecyclerViewAdapter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.mvp.ojk.mvpractice.R
import presenter.MainContract
import presenter.MainPresenter

open class MainActivity : AppCompatActivity() {

    private var presenter: MainContract.Presenter? = null

    private val recyclerView by lazy { 
        findViewById(R.id.recyclerView) as RecyclerView
    }

    private var flickrRecyclerViewAdapter :FlickrRecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initPresenter()
    }

    

    fun initRecyclerView() {
        flickrRecyclerViewAdapter = FlickrRecyclerViewAdapter(this)
        recyclerView.apply {
            adapter = flickrRecyclerViewAdapter
            layoutManager = GridLayoutManager(context, 2)
        }

    }

    fun initPresenter() {

        flickrRecyclerViewAdapter?.let {
            presenter = MainPresenter(it)
        }

        findViewById(R.id.button).setOnClickListener{
            presenter?.refresh()
        }

    }

}
