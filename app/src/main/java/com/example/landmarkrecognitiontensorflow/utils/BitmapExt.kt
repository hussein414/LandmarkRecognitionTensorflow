package com.example.landmarkrecognitiontensorflow.utils

import android.graphics.Bitmap
import java.lang.IllegalArgumentException

fun Bitmap.centerCrop(desiredWith: Int, desiredHeight: Int): Bitmap {
    val xStart = (width - desiredWith) / 2
    val yStart = (height - desiredHeight) / 2
    if (xStart < 0 || yStart < 0 || desiredWith > width || desiredHeight > height) {
        throw IllegalArgumentException("Invalid argument for Center Crop")
    }
    return Bitmap.createBitmap(this, xStart, yStart, desiredWith, desiredHeight)
}