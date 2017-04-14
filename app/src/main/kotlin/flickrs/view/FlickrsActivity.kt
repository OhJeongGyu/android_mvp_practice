package flickrs.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.mvp.ojk.mvpractice.R
import flickrs.adapter.FlickrRecyclerViewAdapter
import flickrs.presenter.MainContract
import flickrs.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

open class FlickrsActivity : AppCompatActivity() {

    private val presenter: MainContract.Presenter by lazy {
        MainPresenter(flickrRecyclerViewAdapter, this)
    }

    private val recyclerView by lazy { 
        findViewById(R.id.recyclerView) as RecyclerView
    }

    private val flickrRecyclerViewAdapter : FlickrRecyclerViewAdapter by lazy {
        FlickrRecyclerViewAdapter(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        addListener()
    }

    private fun initView() {
        recyclerView.apply {
            adapter = flickrRecyclerViewAdapter
            layoutManager = GridLayoutManager(context, 2) as RecyclerView.LayoutManager
        }
    }

    private fun addListener () {
        button1.setOnClickListener {
            Toast.makeText(this, button1.text, Toast.LENGTH_SHORT).show()
            presenter.sendButtonEvent(button1.text.toString())
            presenter.refresh()
        }

        button2.setOnClickListener {
            Toast.makeText(this, button2.text, Toast.LENGTH_SHORT).show()
            presenter.sendButtonEvent(button2.text.toString())
        }

        button3.setOnClickListener {
            Toast.makeText(this, button3.text, Toast.LENGTH_SHORT).show()
            presenter.sendButtonEvent(button3.text.toString())
        }
    }


}
