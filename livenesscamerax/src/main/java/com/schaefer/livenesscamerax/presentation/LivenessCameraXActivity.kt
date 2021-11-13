package com.schaefer.livenesscamerax.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.schaefer.livenesscamerax.databinding.LivenessCameraxActivityBinding
import com.schaefer.livenesscamerax.di.LibraryModule
import com.schaefer.livenesscamerax.di.LibraryModule.container
import com.schaefer.domain.model.exceptions.LivenessCameraXException

class LivenessCameraXActivity : AppCompatActivity() {

    private val resultHandler by lazy { container.provideResultLivenessRepository() }
    private lateinit var binding: LivenessCameraxActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LivenessCameraxActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        LibraryModule.initializeDI(application)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        resultHandler.error(LivenessCameraXException.UserCanceledException())
    }
}
