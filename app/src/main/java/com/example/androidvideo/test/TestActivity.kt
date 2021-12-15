package com.example.androidvideo.test

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.androidvideo.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)


        //标准的flow是冷流，需要collect才开始emit
        val flow = flow {
            (0..5).forEach {
                delay(500)
                Log.d("YUEDEVTAG", "emit:${it}")
                emit(it)
            }
        }


        val sharedFlow = MutableSharedFlow<Int>()

        sharedFlow.onStart {
            Log.d("YUEDEVTAG", "sharedFlow onStart")
        }

        lifecycleScope.launch {
            sharedFlow.collect {
                Log.d("YUEDEVTAG", "sharedFlow collect:${it}")
            }
        }

        lifecycleScope.launch {
            Log.d("YUEDEVTAG", "sharedFlow emit 100")
            sharedFlow.emit(100)

        }


        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {

        }
    }
}