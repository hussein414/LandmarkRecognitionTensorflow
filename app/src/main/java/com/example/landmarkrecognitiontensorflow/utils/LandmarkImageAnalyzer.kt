package com.example.landmarkrecognitiontensorflow.utils

import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.example.landmarkrecognitiontensorflow.data.domain.LandmarkClassifier
import com.example.landmarkrecognitiontensorflow.data.model.Classification

class LandmarkImageAnalyzer(
    private val classifier: LandmarkClassifier,
    private val onResult: (List<Classification>) -> Unit
) : ImageAnalysis.Analyzer {
    private var frameSkipCounter = 0
    override fun analyze(image: ImageProxy) {
        if (frameSkipCounter % 60 == 0) {
            val rotationDegrees = image.imageInfo.rotationDegrees
            val bitmap = image.toBitmap().centerCrop(desiredWith = 321, desiredHeight = 321)
            val result = classifier.classify(bitmap = bitmap, rotationDegrees)
            onResult(result)
        }
        frameSkipCounter++
        image.close()
    }
}