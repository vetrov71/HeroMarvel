package com.example.marvelhero1.domain.entity

import java.io.Serializable

data class Marvel(
    var name: String? = null,
    var realname: String? = null,
    var team: String? = null,
    var createdby: String? = null,
    var firstappearance: String? = null,
    var publisher: String? = null,
    var imageurl: String? = null,
    var bio: String? = null
): Serializable