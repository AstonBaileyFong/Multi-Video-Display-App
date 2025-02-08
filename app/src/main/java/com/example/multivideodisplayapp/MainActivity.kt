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

/*
* This class functions as the program's View within the MVVM framework.
* It creates and manages all UI elements, encompassing the menu and VideoViews.
* This class includes several functions, such as onCreate() for program initialisation, onSupportNavigateUp() for menu opening and onBackPressed() for menu closure.
 */
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

        drawerLayout = findViewById(R.id.drawerLayout)

        actionBarToggle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)
        drawerLayout.addDrawerListener(actionBarToggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        actionBarToggle.syncState()

        navView = findViewById(R.id.navView)

        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.main -> {
//                    setContentView(R.layout.activity_main)
                    Toast.makeText(this, "Main", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.settings -> {
                    Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
//                    setContentView(R.layout.activity_settings)
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

        var simpleVideoView: VideoView = findViewById(R.id.simpleVideoView)
        var simpleVideoView2: VideoView = findViewById(R.id.simpleVideoView2)

        if (!::mediaControl.isInitialized) {
            mediaControl = MediaController(this)
            mediaControl.setAnchorView(simpleVideoView)
        }
        if (!::mediaControl2.isInitialized) {
            mediaControl2 = MediaController(this)
            mediaControl2.setAnchorView(simpleVideoView2)
        }
        var videoOne = VideoModel(Uri.parse("android.resource://" + packageName + "/" + R.raw.enterprisegflyby), mediaControl)
        var videoTwo = VideoModel(Uri.parse("android.resource://" + packageName + "/" + R.raw.stargazermeetenterprise), mediaControl2)
        var videoUri: Uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.enterprisegflyby)
        var videoUri2: Uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.stargazermeetenterprise)
        VideoViewModel().initialiseVideo("simpleVideoView", videoOne.getVideoLocation(), simpleVideoView, videoOne.getMediaControls(), applicationContext)
        VideoViewModel().initialiseVideo("simpleVideoView2", videoTwo.getVideoLocation(), simpleVideoView2, videoTwo.getMediaControls(), applicationContext)
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