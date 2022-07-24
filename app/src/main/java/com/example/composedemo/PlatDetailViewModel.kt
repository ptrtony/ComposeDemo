package com.example.composedemo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class PlatDetailViewModel : ViewModel(){

    @Composable
    fun loadImage(): State<PlantEntity>{
        return produceState(initialValue = PlantEntity.loading){
            val coroutines = flow {
                delay(1000)
                val plantEntity = PlantEntity("id","Apple","description")
                emit(plantEntity)
            }

            coroutines.collect {
                value = it
            }
        }
    }
}
