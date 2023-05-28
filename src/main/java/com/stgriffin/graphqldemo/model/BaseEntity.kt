package com.stgriffin.graphqldemo.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    protected val user_id: String?=null
        get() = field


    @CreationTimestamp
    protected val creationTime: LocalDateTime? =null

    @UpdateTimestamp
    protected val updateTime: LocalDateTime? =null

}