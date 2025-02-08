package com.example.multivideodisplayapp

import android.net.Uri
import android.widget.MediaController



/*
* This class represents the Model of the program within the MVVM structure.
* It stores the data, specifically video information prior to initialisation.
* The class provides only getter and setter methods for other program components to access the data.
 */
class VideoModel(private var videoURI: Uri, private var mediaControl: MediaController) {
    fun getVideoLocation(): Uri{
        return this.videoURI
    }
    fun getMediaControls(): MediaController{
        return this.mediaControl
    }
    fun setVideoLocation(videoURI: Uri){
        this.videoURI = videoURI
    }
    fun setMediaControls(mediaControl: MediaController){
        this.mediaControl = mediaControl
    }
}