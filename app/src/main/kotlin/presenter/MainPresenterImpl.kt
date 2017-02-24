package presenter

import junit.framework.Test
import model.TestModel


/**
 * Created by jeonggyuoh on 2017. 2. 24..
 */


class MainPresenterImpl(val view: MainPresenter.View) : MainPresenter {



    override fun sendToPresenter() {
        view.onDataReceived(getDate())
    }

    fun getDate() :String{
        return TestModel.getModelData()
    }
}