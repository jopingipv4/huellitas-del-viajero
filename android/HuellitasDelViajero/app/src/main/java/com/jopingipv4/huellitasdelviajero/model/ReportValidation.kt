package com.jopingipv4.huellitasdelviajero.model

/** Validaciones locales sin acceso a red; comprobables también con pruebas unitarias. */
object ReportValidation {
    fun descriptionError(value: String): String? = when {
        value.isBlank() -> "La descripción no puede estar vacía"
        value.trim().length < 10 -> "Escribe al menos 10 caracteres"
        value.length > 400 -> "La descripción no puede superar 400 caracteres"
        else -> null
    }

    fun locationError(value: String): String? = when {
        value.isBlank() -> "La ubicación no puede estar vacía"
        value.trim().length < 5 -> "Escribe al menos 5 caracteres"
        value.length > 140 -> "La ubicación no puede superar 140 caracteres"
        else -> null
    }
}
