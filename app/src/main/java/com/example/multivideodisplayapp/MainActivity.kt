package com.example.multivideodisplayapp

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
import com.example.multivideodisplayapp.ImageViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity :  AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var ImageOne: ImageView = findViewById(R.id.ImageOne)
        var ImageTwo: ImageView = findViewById(R.id.ImageTwo)
        ImageViewModel().InitialiseImage("ImageOne", "Image", ImageOne)
        ImageViewModel().InitialiseImage("ImageTwo", "Image", ImageTwo)



//        var ImageOne: ImageView = findViewById(R.id.ImageOne)
//        ImageOne.setImageResource(R.drawable.ventureandexcelsiors)
//
//        var ImageTwo: ImageView = findViewById(R.id.ImageTwo)
//        ImageTwo.setImageResource(R.drawable.odysseycriticallydamaged)
    }
//    fun InitialiseImage(screenName: String, imageName: String){
//        var Image: ImageView
//
//        if (screenName == "ImageOne"){
//            Image = findViewById(R.id.ImageOne)
//            Image.setImageResource(R.drawable.ventureandexcelsiors)
//        }else{
//            Image = findViewById(R.id.ImageTwo)
//            Image.setImageResource(R.drawable.odysseycriticallydamaged)
//        }
//    }

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