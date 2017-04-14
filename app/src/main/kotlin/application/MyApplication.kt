package application
import android.app.Application
import com.google.android.gms.analytics.GoogleAnalytics
import com.google.android.gms.analytics.Tracker
import com.mvp.ojk.mvpractice.R

/**
 * Created by jeonggyuoh on 2017. 4. 14..
 */

class MyApplication: Application() {

    private val tracker: Tracker by lazy {
        GoogleAnalytics.getInstance(this).newTracker(R.xml.global_tracker)
    }


    override fun onCreate() {
        super.onCreate()
    }

    fun getDefaultTracker(): Tracker {
        return tracker
    }
}