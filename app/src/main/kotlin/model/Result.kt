package model

/**
 * Created by jeonggyuoh on 2017. 2. 24..
 */


class Result {
    var photos :Photos? = null
    var stat :String? = null
}

class Photos {
    var photo :MutableList<Photo>? = null
}


class Photo {

    var id :String? = null
    var owner :String? = null
    var secret :String? = null
    var server :String? = null
    var farm :Int? = null
    var title :String? = null

}


