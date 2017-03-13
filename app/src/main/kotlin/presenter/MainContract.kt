package presenter

import model.Photo

/**
 * Created by jeonggyuoh on 2017. 3. 13..
 */
interface MainContract {

    interface Presenter {
        fun refresh()
    }

    interface AdapterModel {
        fun onPhotosReceived(data: List<Photo>)
        fun onError(throwable: Throwable)
    }
}