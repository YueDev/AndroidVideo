package com.example.androidvideo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidvideo.adapter.VideoListAdapter
import com.example.androidvideo.repository.Resource
import com.example.androidvideo.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    @Inject
    lateinit var videoListAdapter: VideoListAdapter

    private val videoListView: RecyclerView by lazy {
        findViewById(R.id.recyclerView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        observeData()
    }

    private fun initView() {
        videoListView.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = videoListAdapter
        }
    }

    private fun observeData() {
        mainViewModel.getVideos().observe(this) {
            if (it is Resource.Success) videoListAdapter.submitList(it.data)
        }
    }
}