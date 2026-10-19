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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.jopingipv4.huellitasdelviajero.model.ReportValidation
import com.jopingipv4.huellitasdelviajero.ui.components.DemoBadge

@Composable
fun ReportCaseScreen(
    onBackToHome: () -> Unit,
    onSaveReport: (String, String) -> Boolean
) {
    var description by rememberSaveable { mutableStateOf("") }
    var location by rememberSaveable { mutableStateOf("") }
    var descriptionError by rememberSaveable { mutableStateOf<String?>(null) }
    var locationError by rememberSaveable { mutableStateOf<String?>(null) }
    var showSavedDialog by rememberSaveable { mutableStateOf(false) }
    var savingError by rememberSaveable { mutableStateOf(false) }

    fun validateAndSave() {
        descriptionError = ReportValidation.descriptionError(description)
        locationError = ReportValidation.locationError(location)
        if (descriptionError == null && locationError == null) {
            if (onSaveReport(description, location)) {
                showSavedDialog = true
                savingError = false
            } else {
                savingError = true
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp).verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Reportar caso", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            OutlinedButton(onClick = onBackToHome) { Text("Volver") }
        }

        DemoBadge("DEMOSTRACIÓN M8 — Usa únicamente datos inventados. El reporte se guarda en este dispositivo, NO se envía a una organización.")

        Text(
            "Describe un caso ficticio para probar la validación y el almacenamiento local.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        OutlinedTextField(
            value = description,
            onValueChange = {
                description = it
                descriptionError = null
                savingError = false
            },
            label = { Text("Descripción del caso") },
            placeholder = { Text("Ej.: Perrito mestizo pequeño que necesita ayuda.") },
            isError = descriptionError != null,
            supportingText = {
                descriptionError?.let { Text(it, color = MaterialTheme.colorScheme.error) }
            },
            minLines = 3,
            maxLines = 5,
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = location,
            onValueChange = {
                location = it
                locationError = null
                savingError = false
            },
            label = { Text("Ubicación ficticia de referencia") },
            placeholder = { Text("Ej.: Parque central, zona de prueba.") },
            isError = locationError != null,
            supportingText = {
                locationError?.let { Text(it, color = MaterialTheme.colorScheme.error) }
            },
            modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)
        )

        Button(onClick = ::validateAndSave, modifier = Modifier.fillMaxWidth()) {
            Text("Guardar reporte de prueba")
        }

        if (savingError) {
            Spacer(modifier = Modifier.height(12.dp))
            Card(
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.errorContainer)
            ) {
                Text(
                    "No se pudo guardar el reporte en este dispositivo. Inténtalo nuevamente.",
                    modifier = Modifier.padding(12.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "Los reportes de prueba pueden consultarse en el panel administrativo de demostración. Permanecen en este dispositivo hasta que se borren los datos de la aplicación o se desinstale.",
            style = MaterialTheme.typography.bodySmall
        )

        if (showSavedDialog) {
            AlertDialog(
                onDismissRequest = { showSavedDialog = false },
                title = { Text("Reporte de prueba guardado") },
                text = {
                    Text("El registro se guardó localmente para este prototipo. No se envió a internet ni a una organización de rescate.")
                },
                confirmButton = {
                    TextButton(onClick = {
                        showSavedDialog = false
                        description = ""
                        location = ""
                    }) { Text("Aceptar y limpiar") }
                }
            )
        }
    }
}
