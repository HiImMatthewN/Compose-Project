package com.bell_kenz.firstcomposeproject.ui.screens

sealed class Screen(val route:String) {
    object ConversationsScreen:Screen("conversations_screen")
    object DetailsScreen:Screen("details_screen")

}