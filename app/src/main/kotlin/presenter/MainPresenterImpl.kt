package presenter

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import junit.framework.Test
import model.Photos
import model.Result
import model.TestModel
import network.FlickrService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by jeonggyuoh on 2017. 2. 24..
 */


class MainPresenterImpl(val view :MainPresenter.View) :MainPresenter {

    val BASE_URL = "https://api.flickr.com/"
    val METHOD = "flickr.photos.getRecent"
    val API_KEY = "<API_KEY>"
    val FORMAT = "json"


    override fun sendToPresenter() {
//        view.onDataReceived(getDate())
        getDateByFlickr()
    }

    fun getDate() :String{
        return TestModel.getModelData()
    }

    fun getDateByFlickr() {

        Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(FlickrService::class.java)
                .getRecentImage(METHOD, API_KEY, FORMAT, 10, 1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe({ it -> view.onPhotosReceived(it?.photos?.photo!!) },
                    { it -> view.onError(it) }
                )
    }
}