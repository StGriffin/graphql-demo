package com.stgriffin.graphqldemo.model

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import java.time.LocalDateTime

@Entity(name="`user`")
data class User(

        private var userName: String,
        private var mail: String,
        @Enumerated(EnumType.STRING)
        private var role: Role,
) : BaseEntity(
        id = "",
        creationTime = LocalDateTime.now(),
        updateTime = null
)
{
    var _userName: String
        get() = userName
        set(value) {
            userName = value
        }

    var _mail: String
        get() = mail
        set(value) {
            mail = value
        }

    var _role: Role
        get() = role
        set(value) {
            role = value
        }

}

