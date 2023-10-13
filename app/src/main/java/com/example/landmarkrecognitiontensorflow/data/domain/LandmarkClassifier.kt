package com.example.landmarkrecognitiontensorflow.data.domain

import android.graphics.Bitmap
import com.example.landmarkrecognitiontensorflow.data.model.Classification

interface LandmarkClassifier {
    fun classify(bitmap: Bitmap, rotation: Int): List<Classification>
}