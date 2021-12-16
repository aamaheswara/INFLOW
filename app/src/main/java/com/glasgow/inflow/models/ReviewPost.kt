package com.glasgow.inflow.models

data class ReviewPost(
    var title: String,
    var body: String,
    var image: String, // this is a pointer to a raw image on the internet
    var username: String
) {

}