package model

/**
 * Created by jeonggyuoh on 2017. 3. 13..
 */
data class Photo (
        val id :String,
        val owner :String,
        val secret :String,
        val server :String,
        val farm :Int,
        val title :String
)


