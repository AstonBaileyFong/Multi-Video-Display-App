package com.example.multivideodisplayapp

import android.net.Uri
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import android.content.Context

class VideoViewModel: AppCompatActivity() {

    fun initialiseVideo(screenName: String, videoUri: Uri, video: VideoView, mediaControls: MediaController, context: Context){
        video.setMediaController(mediaControls)
        video.setVideoURI(videoUri)
        println("C")
        video.requestFocus()
        video.start()

        println("D")
//        video.setOnCompletionListener {
//            Toast.makeText(applicationContext, "Video completed",
//                Toast.LENGTH_LONG).show()
//            true
//        }
//
//        // display a toast message if any
//        // error occurs while playing the video
//        video.setOnErrorListener { mp, what, extra ->
//            Toast.makeText(applicationContext, "An Error Occurred " +
//                    "While Playing Video !!!", Toast.LENGTH_LONG).show()
//            false
//        }
    }
}
