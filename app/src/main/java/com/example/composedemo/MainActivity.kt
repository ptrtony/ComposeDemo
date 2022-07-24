package com.example.composedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this).get(PlatDetailViewModel::class.java)
        setContent {
            MaterialTheme(){
//                platWaterHeader("Watering needs","every 7 days")
                PlatDetailDescription(viewModel)
            }
        }
    }


    @Composable
    private fun PlaneName(name: String) {
        Text(
            style=MaterialTheme.typography.h5,
            text = name,
            color = colorResource(id = R.color.black),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(horizontal = 10.dp, vertical = 5.dp)
        )
    }

    @Composable
    private fun PlatDetailDescription(plantDetailViewModel:PlatDetailViewModel){
        val plantEntity = plantDetailViewModel.loadImage()
        PlaneName(name = plantEntity.value.name)
    }



    @Composable
    private fun platWaterHeader(headerWater: String, plantWatering: String) {
        Column(Modifier.fillMaxWidth()) {
            PlaneName("Apple")
            Text(
                text = headerWater,
                color = MaterialTheme.colors.primaryVariant,
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
                    .padding(
                        start = dimensionResource(id = R.dimen.margin_small),
                        top = dimensionResource(id = R.dimen.margin_small),
                        end = dimensionResource(id = R.dimen.margin_small)
                    ),
                fontWeight = FontWeight.Bold,

                )

            Text(
                text = plantWatering,
                modifier = Modifier
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
                    .padding(
                        start = dimensionResource(id = R.dimen.margin_small),
                        end = dimensionResource(id = R.dimen.margin_small)
                    ),
            )
        }
    }


}