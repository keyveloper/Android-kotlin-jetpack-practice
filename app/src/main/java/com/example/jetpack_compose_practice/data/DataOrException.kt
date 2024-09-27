package com.example.jetpack_compose_practice.data

data class DataOrException<T, Boolean, E: Exception>(
    var data: T? = null,
    var loading: Boolean? = null,
    var e : E? = null
)