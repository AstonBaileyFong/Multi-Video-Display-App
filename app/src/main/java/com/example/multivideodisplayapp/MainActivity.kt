package com.example.multivideodisplayapp

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.multivideodisplayapp.ImageViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class MainActivity :  AppCompatActivity() {



    lateinit var mediaControl: MediaController
    lateinit var mediaControl2: MediaController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        var ImageOne: ImageView = findViewById(R.id.ImageOne)
//        var ImageTwo: ImageView = findViewById(R.id.ImageTwo)
//        ImageViewModel().InitialiseImage("ImageOne", "Image", ImageOne)
//        ImageViewModel().InitialiseImage("ImageTwo", "Image", ImageTwo)


        var simpleVideoView: VideoView = findViewById(R.id.simpleVideoView)
        var simpleVideoView2: VideoView = findViewById(R.id.simpleVideoView2)
        println("A")


        if (!::mediaControl.isInitialized) {
            mediaControl = MediaController(this)
            mediaControl.setAnchorView(simpleVideoView)
        }
        if (!::mediaControl2.isInitialized) {
            mediaControl2 = MediaController(this)
            mediaControl2.setAnchorView(simpleVideoView2)
        }
        println("B")
//        VideoViewModel().InitialiseVideo("simpleVideoView", "Video", simpleVideoView, mediaControl, applicationContext)
//        VideoViewModel().InitialiseVideo("simpleVideoView2", "Video", simpleVideoView2, mediaControl2, applicationContext)
        InitialiseVideo("simpleVideoView", "Video", simpleVideoView, mediaControl)
        InitialiseVideo("simpleVideoView2", "Video", simpleVideoView2, mediaControl)
        println("E")

    }

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.about -> Toast.makeText(this,"About Selected",Toast.LENGTH_SHORT).show()
            R.id.settings -> Toast.makeText(this,"Settings Selected",Toast.LENGTH_SHORT).show()
            R.id.exit -> Toast.makeText(this,"Exit Selected",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }


}