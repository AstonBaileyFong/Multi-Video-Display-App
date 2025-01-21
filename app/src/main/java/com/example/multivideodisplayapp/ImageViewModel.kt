package com.example.multivideodisplayapp

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ImageViewModel: AppCompatActivity(){
    fun InitialiseImage(screenName: String, imageName: String, image: ImageView){


        if (screenName == "ImageOne"){

            image.setImageResource(R.drawable.ventureandexcelsiors)
        }else{

            image.setImageResource(R.drawable.odysseycriticallydamaged)
        }
    }
}