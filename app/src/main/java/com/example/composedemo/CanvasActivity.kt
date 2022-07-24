package com.example.composedemo

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

class CanvasActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            drawCanvas()
        }
    }

    @Composable
    fun drawCanvas(){
        Canvas(modifier = Modifier.fillMaxSize()){
            val canvasWidth = size.width
            val canvasHeight = size.height
            drawLine(
                start = Offset(x = canvasWidth,y = 0f),
                end = Offset(x = 0f,y = canvasHeight),
                color = Color.Blue,
                strokeWidth = 5f
            )
        }
    }
}