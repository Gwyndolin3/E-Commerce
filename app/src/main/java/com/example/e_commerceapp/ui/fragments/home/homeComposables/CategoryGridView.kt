package com.example.e_commerceapp.ui.fragments.home.homeComposables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*



import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.progressSemantics
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.e_commerceapp.ui.fragments.home.HomeState
import com.example.e_commerceapp.ui.theme.DarkBlueForText


@Composable

fun CategoryGridView(modifier: Modifier = Modifier,
                     state : HomeState) {
        Column(
                modifier = Modifier.heightIn(300.dp),
        ) {
                Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                                .padding(10.dp,0.dp)
                ) {
                        Text(
                                text = "Category",
                                fontSize = 20.sp,
                                color = DarkBlueForText,
                                fontWeight = FontWeight.Bold
                        )

                        Text(text = "view all",
                        color = DarkBlueForText,
                                fontWeight = FontWeight.Bold
                        )
                }
                if (state.isLoading) {
                        Row(
                                modifier = Modifier.heightIn(300.dp)
                                        .fillMaxWidth(),
                                verticalAlignment = CenterVertically,
                                horizontalArrangement = Arrangement.Center


                        ) {

                                CircularProgressIndicator(
                                        modifier = Modifier
                                                .progressSemantics()
                                                .size(150.dp)
                                                .align(CenterVertically)

                                        )
                        }
                } else if (!(state.categoriesInfo.isNullOrEmpty())) {
                        LazyHorizontalGrid(rows = GridCells.Fixed(2),
                                Modifier
                                        .fillMaxWidth()
                                        .heightIn(max = 300.dp),
                                content = {
                                        items(state.categoriesInfo?.size ?: 5) { it ->
                                                Column(
                                                        modifier = Modifier.wrapContentHeight(),
                                                        horizontalAlignment = Alignment.CenterHorizontally,
                                                        ) {
                                                        AsyncImage(
                                                                model = state.categoriesInfo?.get(it)?.image,
                                                                contentDescription = null,
                                                                modifier
                                                                        .size(110.dp)
                                                                        .padding(10.dp)
                                                                        .clip(CircleShape),
                                                                contentScale = ContentScale.Crop
                                                        )
                                                        Text(
                                                                text = state.categoriesInfo?.get(it)?.name
                                                                        ?: "Loading",
                                                                modifier
                                                                        .widthIn(max = 100.dp),
                                                                fontSize = 17.sp,
                                                                textAlign = TextAlign.Center,
                                                                color = DarkBlueForText
                                                        )
                                                }
                                        }

                                }
                        )

                }
                else if(!state.error.isNullOrBlank()){

                        Text(text = state.error)
                }
        }
}