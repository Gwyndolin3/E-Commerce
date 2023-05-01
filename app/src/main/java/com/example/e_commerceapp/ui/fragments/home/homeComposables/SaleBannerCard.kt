package com.example.e_commerceapp.ui.fragments.home.homeComposables


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.e_commerceapp.ui.fragments.home.HomeState

@Composable
fun SaleBannerCard(modifier: Modifier = Modifier, state : HomeState){
    
    Card(
        modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(15.dp, 10.dp)
    , RoundedCornerShape(corner = CornerSize(15.dp))
    ) {

        AsyncImage(model = state.categoriesInfo?.get(1)?.image, contentDescription =null,
        contentScale = ContentScale.Crop
            )

    }
    
}