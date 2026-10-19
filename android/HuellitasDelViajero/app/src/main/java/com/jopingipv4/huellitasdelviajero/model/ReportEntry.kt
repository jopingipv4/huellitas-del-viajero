package com.jopingipv4.huellitasdelviajero.model

/** Reporte ficticio almacenado únicamente en este dispositivo de demostración. */
data class ReportEntry(
    val id: String,
    val description: String,
    val location: String,
    val createdAtMillis: Long,
    val status: ReportStatus = ReportStatus.PENDIENTE
)

enum class ReportStatus(val label: String) {
    PENDIENTE("Pendiente"),
    EN_REVISION("En revisión"),
    CERRADO("Cerrado")
}
