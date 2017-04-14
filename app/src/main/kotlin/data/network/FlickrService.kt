package data.network

import data.model.Result
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by jeonggyuoh on 2017. 2. 24..
 */
interface FlickrService {
    @GET("services/rest/")
    fun getRecentImage(
            @Query("method") method :String,
            @Query("api_key") api_key :String,
            @Query("format") format :String,
            @Query("per_page") per_page :Int,
            @Query("nojsoncallback") nojsoncallback:Int
    ) :Flowable<Result>
}