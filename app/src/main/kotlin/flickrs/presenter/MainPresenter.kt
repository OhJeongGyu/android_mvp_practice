package flickrs.presenter


import android.content.Context
import android.os.Bundle
import application.MyApplication
import com.google.android.gms.analytics.HitBuilders
import com.google.android.gms.analytics.Tracker
import com.google.firebase.analytics.FirebaseAnalytics
import data.FirebaseRepository
import data.FlickrRepository
import data.model.Result


/**
 * Created by jeonggyuoh on 2017. 2. 24..
 */
class MainPresenter(private val adapterModel: MainContract.AdapterModel, private val context: Context):
        MainContract.Presenter,
        FlickrRepository.FlickrEventListener {

    private val flickrRepository: FlickrRepository

    private val myApplication: MyApplication by lazy {
        context.applicationContext as MyApplication
    }
    private val tracker: Tracker by lazy {
        myApplication.getDefaultTracker()
    }

    private val firebaseRepository by lazy {
        FirebaseRepository.getInstance(context)
    }


    init {
        flickrRepository = FlickrRepository.getInstance()
        flickrRepository.flickrEventListener = this
    }

    override fun refresh() {
        flickrRepository.getDateByFlickr()
    }

    override fun onDataReceived(result: Result) {
        result.photos?.photo?.let {
            adapterModel.onPhotosReceived(it)
        }

    }

    override fun onError(throwable: Throwable) {
        adapterModel.onError(throwable)
    }

    override fun sendButtonEvent(name: String) {
        tracker.send(HitBuilders.EventBuilder()
                .setCategory("BUTTON_CLICKED")
                .setAction(name)
                .build())
        val bundle: Bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "BUTTON_CLICKED_FB")
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name)
        firebaseRepository.logEvent(bundle)
    }



}
