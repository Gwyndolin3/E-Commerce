package com.example.e_commerceapp.ui.fragments.home.homeComposables

import android.content.Context
import android.graphics.Paint.Style
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.progressSemantics
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.e_commerceapp.R
import com.example.e_commerceapp.ui.fragments.home.HomeState
import com.example.e_commerceapp.ui.theme.DarkBlueForText

@Composable


fun SubCategoryLazyRow(modifier: Modifier= Modifier, state : HomeState, title:String,
context : Context){

    Column(
modifier = Modifier.fillMaxWidth()

    ) {
        Spacer(modifier = modifier.height(10.dp))

        Text(text = title,
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 10.dp),
            color = DarkBlueForText,
            fontWeight = FontWeight.Bold
        )
        if(state.isLoading){
        CircularProgressIndicator(
            modifier = Modifier
                .progressSemantics()
                .size(100.dp)
                .align(CenterHorizontally)

        )
        }
        else {
            LazyRow(content = {
                items(
                    state.categoriesInfo?.size ?: 0,

                    ) {
                    Card(
                        shape = RoundedCornerShape(15.dp),
                        backgroundColor = Color.White,
                        modifier = modifier
                            .padding(10.dp)
                            .width(158.dp)
                            .wrapContentHeight()


                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            Box(
                                modifier = Modifier
                                    .height(130.dp)
                                    .width(158.dp)
                            )
                            {


                                AsyncImage(
                                    model = state.categoriesInfo?.get(it)?.image,
                                    contentDescription = "none",
                                    contentScale = ContentScale.FillBounds

                                )
                                Image(
                                    painter = painterResource(R.drawable.wishlist_icon),
                                    contentDescription = "any",
                                    Modifier.align(Alignment.TopEnd),

                                )
                            }

                            Text(
                                text = "text", modifier = Modifier.padding(5.dp, 10.dp)
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth()
                            ) {

                                Text(
                                    text = "Text",
                                    modifier = Modifier.padding(5.dp, 10.dp)

                                )
                                Text(
                                    text = "Telllllllllllllllllllllllllxt",
                                    modifier = Modifier.padding(5.dp, 10.dp)
                                )
                            }



                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,

                                ) {

                                Text(
                                    text = "text",
                                    modifier = Modifier.padding(5.dp, 10.dp)
                                )




                                Image(
                                    painter = painterResource(id = R.drawable.add_to_cart_icon),
                                    contentDescription = null,
                                    Modifier
                                        .padding(10.dp)
                                        .clickable {
                                            Toast.makeText(context,"Added to Cart", Toast.LENGTH_SHORT).show()
                                        }




                                )
                            }
                        }

                    }

                }
            })
        }

}}