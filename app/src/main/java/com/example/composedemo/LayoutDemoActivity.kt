package com.example.composedemo

import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class LayoutDemoActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotographerProfile(Photographer("Alfred Sisley","3 minutes age"))
        }
    }


//    @Preview
//    @Composable
//    fun showPhotographer(){
//        PhotographerProfile(Photographer("Alfred Sisley","3 minutes age"))
//    }
    @Composable
    fun PhotographerProfile(photographer: Photographer) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "avatar",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape))
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(photographer.name,fontWeight = FontWeight.Bold)
                Text(photographer.lastScreenOnline, color = colorResource(id = R.color.color_999))
            }
        }
    }


    data class Photographer(
        val name: String,
        val lastScreenOnline: String
    )
}