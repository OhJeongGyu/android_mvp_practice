package data

import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

/**
 * Created by jeonggyuoh on 2017. 4. 14..
 */
class FirebaseRepository {


    private var context: Context? = null

    private val analytics: FirebaseAnalytics by lazy {
        FirebaseAnalytics.getInstance(context)
    }

    companion object {

        private val firebaseRepository: FirebaseRepository by lazy {
            FirebaseRepository()
        }

        fun getInstance(context: Context): FirebaseRepository {
            firebaseRepository.context = context
            return firebaseRepository
        }

    }

    fun logEvent(bundle: Bundle) {
        analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
    }



}