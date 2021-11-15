package com.schaefer.camera.callback

import java.io.File

interface CameraXCallback {
    fun onSuccess(photoFile: File, takenByUser: Boolean)
    fun onError(exception: Exception)
}
