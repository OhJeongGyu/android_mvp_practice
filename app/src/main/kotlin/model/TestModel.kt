package model

/**
 * Created by jeonggyuoh on 2017. 2. 24..
 */


class TestModel {

    companion object{

        var data :Int = 0

        fun getModelData(): String{
            return "hello" + data++
        }
    }

}