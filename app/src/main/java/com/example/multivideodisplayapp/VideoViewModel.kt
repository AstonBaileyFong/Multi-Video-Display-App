package com.example.multivideodisplayapp

import android.net.Uri
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import android.content.Context
/*
* This class serves as the program's ViewModel within the MVVM architecture.
* It initialises any VideoView passed to it, facilitating the view's interaction with the model.
* It contains a single function, thereby controlling the view's access to the model.
 */
class VideoViewModel: AppCompatActivity() {

    fun initialiseVideo(screenName: String, videoUri: Uri, video: VideoView, mediaControls: MediaController, context: Context){
        video.setMediaController(mediaControls)
        video.setVideoURI(videoUri)
        video.requestFocus()
        video.start()
    }
}
