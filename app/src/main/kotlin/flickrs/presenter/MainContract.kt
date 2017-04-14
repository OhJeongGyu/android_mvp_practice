package flickrs.presenter

import data.model.Photo

/**
 * Created by jeonggyuoh on 2017. 3. 13..
 */
interface MainContract {

    interface Presenter {
        fun refresh()
        fun sendButtonEvent(name: String)
    }

    interface AdapterModel {
        fun onPhotosReceived(data: List<Photo>)
        fun onError(throwable: Throwable)
    }
}