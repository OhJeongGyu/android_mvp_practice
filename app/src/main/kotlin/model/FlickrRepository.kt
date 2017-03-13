package model

import android.content.Context
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import network.FlickrService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by jeonggyuoh on 2017. 3. 13..
 */

class FlickrRepository {

    private val BASE_URL = "https://api.flickr.com/"
    private val METHOD = "flickr.photos.getRecent"
    private val API_KEY = "<API_KEY>"
    private val FORMAT = "json"

    internal var flickrEventListener: FlickrEventListener? = null

    companion object{
        private var flickrRepositoryInstance: FlickrRepository? = null
        internal fun getInstance(): FlickrRepository {
            return flickrRepositoryInstance ?: FlickrRepository()
        }
    }


    internal fun getDateByFlickr() {
        Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(FlickrService::class.java)
                .getRecentImage(METHOD, API_KEY, FORMAT, 10, 1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ flickrEventListener?.onDataReceived(it)},
                        {  flickrEventListener?.onError(it)}
                )
    }


    interface FlickrEventListener{
        fun onDataReceived(result: Result)
        fun onError(throwable: Throwable)
    }


}