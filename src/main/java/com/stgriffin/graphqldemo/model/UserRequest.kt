package com.stgriffin.graphqldemo.model
data class UserRequest(
        val id:Long?,
        val userName: String,
        val mail: String,
        val role: Role

)

{
}
