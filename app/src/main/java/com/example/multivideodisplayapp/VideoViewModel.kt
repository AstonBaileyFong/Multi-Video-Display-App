package com.example.multivideodisplayapp

import android.net.Uri
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class VideoViewModel: AppCompatActivity() {

    fun InitialiseVideo(screenName: String, videoName: String, video: VideoView, mediaControls: MediaController){
        video.setMediaController(mediaControls)
        if (screenName == "simpleVideoView") {
            video.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.enterprisegflyby))
        } else if (screenName == "simpleVideoView2"){
            video.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.stargazermeetenterprise))
        }
        video.requestFocus()
        video.start()
        video.setOnCompletionListener {
            Toast.makeText(applicationContext, "Video completed",
                Toast.LENGTH_LONG).show()
            true
        }

        // display a toast message if any
        // error occurs while playing the video
        video.setOnErrorListener { mp, what, extra ->
            Toast.makeText(applicationContext, "An Error Occurred " +
                    "While Playing Video !!!", Toast.LENGTH_LONG).show()
            false
        }
    }
}
