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
import androidx.compose.material3.OutlinedTextField
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
fun ReportCaseScreen(
    onBackToHome: () -> Unit
) {
    var description by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }

    var descriptionError by remember { mutableStateOf<String?>(null) }
    var locationError by remember { mutableStateOf<String?>(null) }

    var lastReportSubmitted by remember { mutableStateOf<Pair<String, String>?>(null) }
    var showConfirmationDialog by remember { mutableStateOf(false) }

    fun validateAndSubmit() {
        var isValid = true

        if (description.trim().isEmpty()) {
            descriptionError = "La descripción no puede estar vacía"
            isValid = false
        } else {
            descriptionError = null
        }

        if (location.trim().isEmpty()) {
            locationError = "La ubicación de referencia no puede estar vacía"
            isValid = false
        } else {
            locationError = null
        }

        if (isValid) {
            lastReportSubmitted = Pair(description.trim(), location.trim())
            showConfirmationDialog = true
        }
    }

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
                text = "Reportar Caso",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            OutlinedButton(onClick = onBackToHome) {
                Text("Volver")
            }
        }

        DemoBadge("DEMOSTRACIÓN M5 - Los datos ingresados no se envían a internet ni se guardan permanentemente.")

        Text(
            text = "Ingresa los detalles del perrito que necesita ayuda:",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        OutlinedTextField(
            value = description,
            onValueChange = {
                description = it
                if (it.trim().isNotEmpty()) descriptionError = null
            },
            label = { Text("Descripción del caso") },
            placeholder = { Text("Ej: Perrito mestizo pequeño con pata herida, requiere atención.") },
            isError = descriptionError != null,
            supportingText = {
                descriptionError?.let {
                    Text(text = it, color = MaterialTheme.colorScheme.error)
                }
            },
            minLines = 3,
            maxLines = 5,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = location,
            onValueChange = {
                location = it
                if (it.trim().isNotEmpty()) locationError = null
            },
            label = { Text("Ubicación de referencia") },
            placeholder = { Text("Ej: Esquina de la Av. Principal con Calle 5, cerca del parque.") },
            isError = locationError != null,
            supportingText = {
                locationError?.let {
                    Text(text = it, color = MaterialTheme.colorScheme.error)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Button(
            onClick = { validateAndSubmit() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar reporte")
        }

        lastReportSubmitted?.let { (desc, loc) ->
            Spacer(modifier = Modifier.height(20.dp))
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Último reporte validado en esta sesión:",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "• Descripción: $desc",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = "• Ubicación: $loc",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "⚠️ Nota: Este reporte es temporal y no se ha guardado en ninguna base de datos ni servidor.",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }

        if (showConfirmationDialog) {
            AlertDialog(
                onDismissRequest = { showConfirmationDialog = false },
                title = { Text("¡Reporte Registrado!") },
                text = {
                    Text("El reporte ha sido validado correctamente para esta sesión de demostración.\n\nRecuerda que por ahora NO se envía información a internet ni a servidores.")
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            showConfirmationDialog = false
                            description = ""
                            location = ""
                        }
                    ) {
                        Text("Aceptar y limpiar formulario")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showConfirmationDialog = false }) {
                        Text("Cerrar")
                    }
                }
            )
        }
    }
}
