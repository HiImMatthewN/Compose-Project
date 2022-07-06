package com.bell_kenz.firstcomposeproject.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object NavigationController{
    @Composable
    fun getNavController() = rememberNavController()
}


