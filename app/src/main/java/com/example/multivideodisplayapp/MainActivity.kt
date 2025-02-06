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
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.multivideodisplayapp.ImageViewModel
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.exitProcess


class MainActivity :  AppCompatActivity() {


    // Initialise the DrawerLayout, NavigationView and ToggleBar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var navView: NavigationView
    lateinit var mediaControl: MediaController
    lateinit var mediaControl2: MediaController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Call findViewById on the DrawerLayout
        drawerLayout = findViewById(R.id.drawerLayout)

        // Pass the ActionBarToggle action into the drawerListener
        actionBarToggle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)
        drawerLayout.addDrawerListener(actionBarToggle)

        // Display the hamburger icon to launch the drawer
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Call syncState() on the action bar so it'll automatically change to the back button when the drawer layout is open
        actionBarToggle.syncState()


        // Call findViewById on the NavigationView
        navView = findViewById(R.id.navView)

        // Call setNavigationItemSelectedListener on the NavigationView to detect when items are clicked
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.settings -> {
                    Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.about -> {
                    Toast.makeText(this, "About", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.exit -> {
                    Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show()
                    true
                    exitProcess(0)
                }
                else -> {
                    false
                }
            }
        }
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
        var videoUri: Uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.enterprisegflyby)
        var videoUri2: Uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.stargazermeetenterprise)
        VideoViewModel().initialiseVideo("simpleVideoView", videoUri, simpleVideoView, mediaControl, applicationContext)
        VideoViewModel().initialiseVideo("simpleVideoView2", videoUri2, simpleVideoView2, mediaControl2, applicationContext)
//        initialiseVideo("simpleVideoView", videoUri, simpleVideoView, mediaControl)
//        initialiseVideo("simpleVideoView2", videoUri2, simpleVideoView2, mediaControl)
        println("E")

    }

    private fun initialiseVideo(screenName: String, videoUri: Uri, video: VideoView, mediaControls: MediaController){
        video.setMediaController(mediaControls)
        video.setVideoURI(videoUri)

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
    // override the onSupportNavigateUp() function to launch the Drawer when the hamburger icon is clicked
    override fun onSupportNavigateUp(): Boolean {
        drawerLayout.openDrawer(navView)
        return true
    }

    // override the onBackPressed() function to close the Drawer when the back button is clicked
    override fun onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }




}