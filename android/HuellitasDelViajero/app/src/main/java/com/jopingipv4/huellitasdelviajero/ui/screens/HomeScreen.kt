package com.jopingipv4.huellitasdelviajero.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.jopingipv4.huellitasdelviajero.ui.components.DemoBadge

@Composable
fun HomeScreen(
    onNavigateToDogs: () -> Unit,
    onNavigateToSponsor: () -> Unit,
    onNavigateToReport: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Huellitas del Viajero",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Protección y bienestar animal en el camino",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        DemoBadge()

        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Bienvenido a Huellitas del Viajero",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Nuestra misión es conectar a perritos rescatados o en situación vulnerable con personas dispuestas a apadrinar, adoptar o reportar casos.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        Text(
            text = "Opciones disponibles",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        OptionCard(
            title = "🐾 Ver perritos",
            description = "Explora la lista de perritos rescatados y conoce sus historias de vida.",
            onClick = onNavigateToDogs
        )

        OptionCard(
            title = "❤️ Apadrinar",
            description = "Conoce cómo apoyar el sustento y tratamiento médico de un perrito.",
            onClick = onNavigateToSponsor
        )

        OptionCard(
            title = "📢 Reportar caso",
            description = "Registra información y ubicación de perritos que necesiten ayuda.",
            onClick = onNavigateToReport
        )
    }
}

@Composable
private fun OptionCard(
    title: String,
    description: String,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
