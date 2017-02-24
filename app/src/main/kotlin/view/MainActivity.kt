package view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.mvp.ojk.mvpractice.R
import presenter.MainPresenter
import presenter.MainPresenterImpl

class MainActivity : AppCompatActivity(), MainPresenter.View{



    private val textView by lazy {
        findViewById(R.id.textView) as TextView
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init() {
        var presenter: MainPresenterImpl = MainPresenterImpl(this)
        findViewById(R.id.button).setOnClickListener { it: View? -> presenter.sendToPresenter() }
    }


    override fun onDataReceived(data: String) {
        textView.text = data
    }
}
