package com.jopingipv4.huellitasdelviajero.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.jopingipv4.huellitasdelviajero.model.ReportEntry
import com.jopingipv4.huellitasdelviajero.model.ReportStatus
import com.jopingipv4.huellitasdelviajero.ui.components.DemoBadge
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun AdminReportsScreen(
    reports: List<ReportEntry>,
    onBackToHome: () -> Unit,
    onChangeStatus: (String, ReportStatus) -> Boolean
) {
    var lastError by remember { mutableStateOf<String?>(null) }
    val dateFormatter = remember { SimpleDateFormat("dd/MM/yyyy HH:mm", Locale("es", "CO")) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Panel administrativo", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            OutlinedButton(onClick = onBackToHome) { Text("Volver") }
        }

        DemoBadge("PANEL DEMO M8 — No requiere contraseña. Sin permisos reales, usuarios ni servidor; utiliza únicamente reportes ficticios locales.")

        Text("Reportes guardados: ${reports.size}", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(8.dp))
        lastError?.let {
            Text(it, color = MaterialTheme.colorScheme.error)
            Spacer(Modifier.height(8.dp))
        }

        if (reports.isEmpty()) {
            Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)) {
                Text(
                    "Todavía no hay reportes de prueba. Regresa a «Reportar caso» y guarda uno con información inventada.",
                    modifier = Modifier.padding(16.dp)
                )
            }
        } else {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                items(reports.sortedByDescending { it.createdAtMillis }, key = { it.id }) { report ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Text(
                                "Estado: ${report.status.label}",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                "Registrado: ${dateFormatter.format(Date(report.createdAtMillis))}",
                                style = MaterialTheme.typography.labelMedium
                            )
                            Spacer(Modifier.height(6.dp))
                            Text("Descripción: ${report.description}")
                            Text("Ubicación: ${report.location}")
                            Spacer(Modifier.height(10.dp))
                            Text("Cambiar estado (solo demostración):", style = MaterialTheme.typography.labelMedium)
                            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                ReportStatus.entries.forEach { nextStatus ->
                                    OutlinedButton(
                                        onClick = {
                                            lastError = if (onChangeStatus(report.id, nextStatus)) null
                                            else "No se pudo guardar el cambio de estado."
                                        },
                                        enabled = report.status != nextStatus,
                                        modifier = Modifier.weight(1f),
                                        contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 2.dp)
                                    ) {
                                        Text(nextStatus.label, style = MaterialTheme.typography.labelSmall)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
