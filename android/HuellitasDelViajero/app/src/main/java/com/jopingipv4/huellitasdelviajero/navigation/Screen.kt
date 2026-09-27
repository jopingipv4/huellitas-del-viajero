package com.jopingipv4.huellitasdelviajero.navigation

sealed interface Screen {
    data object Home : Screen
    data object DogList : Screen
    data class DogDetail(val dogId: String) : Screen
    data object Sponsor : Screen
    data object ReportCase : Screen
}
