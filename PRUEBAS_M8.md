# Registro de pruebas y evidencias — Módulo 8

**Fecha de capturas:** 18 de octubre de 2026. **Entorno:** Android Studio, emulador Pixel 7 API 37.2. Los datos ingresados se tratan como ficticios. Esta tabla diferencia las comprobaciones observadas de las pendientes; no constituye un acta de pruebas exhaustivas.

| ID | Prueba | Resultado documentado | Evidencia |
|---|---|---|---|
| P01 | Inicio actualizado | Correcto: menú y opción administrativa visibles | `evidencias/modulo-8/01-inicio-m8.png` |
| P02 | Navegación al panel desde inicio | Pantalla y botón visibles | `evidencias/modulo-8/02-navegacion-panel.png` |
| P03 | Reporte con datos ficticios | El formulario muestra descripción y ubicación ingresadas | `evidencias/modulo-8/03-formulario-caso.png` |
| P04 | Consulta de reportes | El panel muestra 1 reporte y estado Pendiente | `evidencias/modulo-8/04-panel-pendiente.png` |
| P05 | Cambio de estado | Se muestra En revisión | `evidencias/modulo-8/05-estado-en-revision.png` |
| P06 | Cambio de estado | Se muestra Cerrado | `evidencias/modulo-8/06-estado-cerrado.png` |
| P07 | Formulario vacío | Se visualiza formulario sin datos | `evidencias/modulo-8/07-formulario-vacio.png` |
| P08 | Validación de campos | Se muestran errores de descripción y ubicación obligatorias | `evidencias/modulo-8/08-validacion-campos.png` |
| P09 | Cerrar y reabrir aplicación | **No se adjuntó captura que documente esta comprobación** | Pendiente |
| P10 | Flujo lista / detalle / apadrinar en M8 | Conservado del módulo 5, sin captura nueva de ejecución M8 | Evidencias M5 |

**Sobre la persistencia:** el código implementa almacenamiento local de reportes mediante `SharedPreferences`, pero el mecanismo debe verificarse en ejecución con la aplicación cerrada completamente y abierta de nuevo. Un cambio entre pantallas no demuestra por sí solo esta persistencia.

**Alcance:** no se ensayaron transacciones, rescates reales, envío a organizaciones, usuarios autenticados o una base de datos centralizada.
