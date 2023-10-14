package com.application.tvizy.service

import android.content.Context
import android.net.Uri
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.SimpleExoPlayerView
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory

class PlayVideo(private val context: Context, private val url: String, private val videoPlayer: SimpleExoPlayerView) {

    private var exoPlayer: SimpleExoPlayer?= null

    init {
        val bandwidthMeter= DefaultBandwidthMeter()
        val trackSelector= DefaultTrackSelector(AdaptiveTrackSelection.Factory(bandwidthMeter))
        exoPlayer = ExoPlayerFactory.newSimpleInstance(context, trackSelector)
        val videoUri = Uri.parse(url)
        val dataSourceFactory = DefaultHttpDataSourceFactory("exoplayer_video")
        val extractorsFactory = DefaultExtractorsFactory()
        val mediaSource = ExtractorMediaSource(videoUri, dataSourceFactory, extractorsFactory, null, null)
        videoPlayer.player = exoPlayer
        exoPlayer!!.prepare(mediaSource)
        exoPlayer!!.playWhenReady = true
        exoPlayer!!.volume= 0f
        exoPlayer!!.playWhenReady = true
        exoPlayer!!.playbackState
    }

}