package com.geektech.gridview

import java.io.Serializable

data class GridViewModal(
    val image: String,
    var isSelected: Boolean = false
): Serializable
