package com.jopingipv4.huellitasdelviajero.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.jopingipv4.huellitasdelviajero.ui.components.DemoBadge

@Composable
fun SponsorScreen(
    onBackToHome: () -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Programa de Apadrinamiento",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            OutlinedButton(onClick = onBackToHome) {
                Text("Volver")
            }
        }

        DemoBadge("DEMOSTRACIÓN M5 - No se procesan solicitudes ni pagos reales.")

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "¿Cómo funciona el Apadrinamiento?",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Al apadrinar, contribuyes mensualmente con alimento, medicinas y cuidados veterinarios para perritos rescatados mientras encuentran un hogar definitivo.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        Text(
            text = "Niveles de Apadrinamiento (Ejemplo)",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        SponsorOptionCard(
            title = "Plan Alimentación (Demo)",
            details = "Cubre la comida mensual de un perrito."
        )

        SponsorOptionCard(
            title = "Plan Salud Veterinaria (Demo)",
            details = "Cubre vacunas, desparasitación y revisiones médicas."
        )

        SponsorOptionCard(
            title = "Plan Integral Huellita (Demo)",
            details = "Cubre alimentación completa, medicina y hospedaje temporal."
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { showDialog = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Simular solicitud de apadrinamiento")
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Aviso de Demostración (M5)") },
                text = {
                    Text("Esta función es demostrativa. Actualmente no se procesan solicitudes de apadrinamiento ni transacciones reales. Próximamente se integrará el sistema de apadrinamiento completo.")
                },
                confirmButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Entendido")
                    }
                }
            )
        }
    }
}

@Composable
private fun SponsorOptionCard(
    title: String,
    details: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = details,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
