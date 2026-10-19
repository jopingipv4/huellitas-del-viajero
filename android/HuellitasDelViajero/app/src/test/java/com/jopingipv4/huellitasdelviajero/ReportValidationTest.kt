package com.jopingipv4.huellitasdelviajero

import com.jopingipv4.huellitasdelviajero.model.ReportValidation
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test

class ReportValidationTest {
    @Test fun emptyFieldsAreRejected() {
        assertNotNull(ReportValidation.descriptionError(" "))
        assertNotNull(ReportValidation.locationError(""))
    }

    @Test fun validFictitiousReportIsAccepted() {
        assertNull(ReportValidation.descriptionError("Perrito de demostración en el parque."))
        assertNull(ReportValidation.locationError("Parque de prueba"))
    }

    @Test fun veryLongFieldsAreRejected() {
        assertNotNull(ReportValidation.descriptionError("x".repeat(401)))
        assertNotNull(ReportValidation.locationError("x".repeat(141)))
    }
}
