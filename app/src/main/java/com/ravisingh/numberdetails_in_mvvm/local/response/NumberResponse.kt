package com.ravisingh.numberdetails_in_mvvm.local.response

data class NumberResponse(
    val date: String,
    val found: Boolean,
    val number: Int,
    val text: String,
    val type: String
)