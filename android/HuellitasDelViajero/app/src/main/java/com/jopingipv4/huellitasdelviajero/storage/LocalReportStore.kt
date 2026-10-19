package com.jopingipv4.huellitasdelviajero.storage

import android.content.Context
import com.jopingipv4.huellitasdelviajero.model.ReportEntry
import com.jopingipv4.huellitasdelviajero.model.ReportStatus
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

/**
 * Persistencia sencilla para un prototipo académico, sin servidor ni datos reales.
 * No es una base de datos compartida ni un sistema de gestión de rescates.
 */
class LocalReportStore(context: Context) {
    private val preferences = context.getSharedPreferences("huellitas_m8_demo", Context.MODE_PRIVATE)

    fun loadReports(): List<ReportEntry> {
        val raw = preferences.getString(KEY_REPORTS, "[]") ?: "[]"
        return try {
            val array = JSONArray(raw)
            buildList {
                for (index in 0 until array.length()) {
                    val item = array.getJSONObject(index)
                    val description = item.optString("description").trim()
                    val location = item.optString("location").trim()
                    val id = item.optString("id")
                    if (description.isNotEmpty() && location.isNotEmpty() && id.isNotEmpty()) {
                        val status = try {
                            ReportStatus.valueOf(item.optString("status", "PENDIENTE"))
                        } catch (_: IllegalArgumentException) {
                            ReportStatus.PENDIENTE
                        }
                        add(
                            ReportEntry(
                                id = id,
                                description = description,
                                location = location,
                                createdAtMillis = item.optLong("createdAtMillis", 0L),
                                status = status
                            )
                        )
                    }
                }
            }
        } catch (_: JSONException) {
            emptyList()
        }
    }

    /** Retorna false si Android no puede guardar los datos localmente. */
    fun saveReports(reports: List<ReportEntry>): Boolean {
        val array = JSONArray()
        reports.forEach { report ->
            array.put(
                JSONObject().apply {
                    put("id", report.id)
                    put("description", report.description)
                    put("location", report.location)
                    put("createdAtMillis", report.createdAtMillis)
                    put("status", report.status.name)
                }
            )
        }
        // Volumen pequeño: escritura sincrónica para confirmar que se guardó antes de avisar al usuario.
        return preferences.edit().putString(KEY_REPORTS, array.toString()).commit()
    }

    companion object {
        private const val KEY_REPORTS = "demo_reports_json"
    }
}
