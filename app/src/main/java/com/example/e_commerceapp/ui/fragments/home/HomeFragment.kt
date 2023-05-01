package com.example.e_commerceapp.ui.fragments.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll


import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import coil.compose.AsyncImage
import com.example.e_commerceapp.ui.fragments.home.homeComposables.CategoryGridView
import com.example.e_commerceapp.ui.fragments.home.homeComposables.SaleBannerCard

import com.example.e_commerceapp.ui.fragments.home.homeComposables.SubCategoryLazyRow
import com.example.e_commerceapp.ui.fragments.home.homeComposables.ViewPager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel : HomeViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
viewModel.state()
        return ComposeView(requireContext()).apply {
            setContent {
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    ViewPager()
                    CategoryGridView(state = viewModel.state)
                    SubCategoryLazyRow(state = viewModel.state, title = "Home Appliance", context = requireContext())
                    SaleBannerCard(state = viewModel.state)
                    SubCategoryLazyRow(state = viewModel.state, title ="New Arrival", context = requireContext())
                    SubCategoryLazyRow(state = viewModel.state, title ="Smart Watches", context = requireContext())
                    Spacer(modifier = Modifier.height(50.dp))
                }
            }
        }
    }
}







