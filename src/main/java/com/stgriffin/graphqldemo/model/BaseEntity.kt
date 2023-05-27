package com.stgriffin.graphqldemo.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.cglib.core.Local
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private val id: String?,

    @CreationTimestamp
    private val creationTime: LocalDateTime,

    @UpdateTimestamp
    private val updateTime: LocalDateTime?

    )

{

}