package com.jopingipv4.huellitasdelviajero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.jopingipv4.huellitasdelviajero.navigation.Screen
import com.jopingipv4.huellitasdelviajero.ui.screens.DogDetailScreen
import com.jopingipv4.huellitasdelviajero.ui.screens.DogListScreen
import com.jopingipv4.huellitasdelviajero.ui.screens.HomeScreen
import com.jopingipv4.huellitasdelviajero.ui.screens.ReportCaseScreen
import com.jopingipv4.huellitasdelviajero.ui.screens.SponsorScreen
import com.jopingipv4.huellitasdelviajero.ui.theme.HuellitasDelViajeroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HuellitasDelViajeroTheme {
                HuellitasApp()
            }
        }
    }
}

@Composable
fun HuellitasApp() {
    val backStack = remember { mutableStateListOf<Screen>(Screen.Home) }
    val currentScreen = backStack.lastOrNull() ?: Screen.Home

    fun navigateTo(screen: Screen) {
        if (currentScreen != screen) {
            backStack.add(screen)
        }
    }

    fun popBack() {
        if (backStack.size > 1) {
            backStack.removeAt(backStack.lastIndex)
        }
    }

    BackHandler(enabled = backStack.size > 1) {
        popBack()
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (currentScreen) {
                is Screen.Home -> HomeScreen(
                    onNavigateToDogs = { navigateTo(Screen.DogList) },
                    onNavigateToSponsor = { navigateTo(Screen.Sponsor) },
                    onNavigateToReport = { navigateTo(Screen.ReportCase) }
                )
                is Screen.DogList -> DogListScreen(
                    onDogSelected = { dogId -> navigateTo(Screen.DogDetail(dogId)) },
                    onBackToHome = { popBack() }
                )
                is Screen.DogDetail -> DogDetailScreen(
                    dogId = currentScreen.dogId,
                    onBackToList = { popBack() },
                    onNavigateToSponsor = { navigateTo(Screen.Sponsor) }
                )
                is Screen.Sponsor -> SponsorScreen(
                    onBackToHome = { popBack() }
                )
                is Screen.ReportCase -> ReportCaseScreen(
                    onBackToHome = { popBack() }
                )
            }
        }
    }
}
