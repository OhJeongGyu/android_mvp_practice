package presenter

import model.Photo
import view.MainActivity

/**
 * Created by jeonggyuoh on 2017. 2. 24..
 */
interface MainPresenter {

    fun sendToPresenter()

    interface View {
        fun onDataReceived(data :String)
        fun onPhotosReceived(data :List<Photo>)
        fun onError(throwable :Throwable)
    }

}