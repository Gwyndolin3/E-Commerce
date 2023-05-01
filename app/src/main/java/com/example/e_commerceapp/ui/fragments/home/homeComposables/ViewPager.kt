package com.example.e_commerceapp.ui.fragments.home.homeComposables

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.e_commerceapp.R
import com.example.e_commerceapp.ui.theme.DarkBlueForText
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield


@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun ViewPager( modifier: Modifier = Modifier){

    Card(shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.Black,
        modifier = Modifier.padding(10.dp)

    ) {
        

    Box () {

        val pageCount = 3
        val pagerState = rememberPagerState(initialPage = 0)

        LaunchedEffect(Unit){
            while (true){
                yield()
                delay(2000)
                pagerState.animateScrollToPage(
                    page = (pagerState.currentPage + 1) % (pageCount ),
                    animationSpec = tween(600)

                )
            }
        }

        HorizontalPager(
            pageCount = pageCount,
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)

        ) { page ->

            Text(text = "$page"
            , color = Color.Blue
            )
            // Our page content
            Image(
                painter = painterResource(id = R.drawable.home_tab_icon),
                contentDescription = "mm",
                modifier = Modifier.fillMaxSize()

            )

        }
        Row(
            Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd)

            ,
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center


        ) {
            repeat(pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) Color(R.color.colorPrimaryBlue) else Color.White
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(10.dp)


                )
            }
        }
    }

}}
