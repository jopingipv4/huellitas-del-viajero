# Huellitas del Viajero — Proyecto Android (COM-437ES-AVO1)

**Módulo 8 — Entrega final académica (18 de octubre de 2026)**  
**Autor:** Johan Dario Tellez Bonilla — Saint Leo University  
**Estado:** aplicación compilada y ejecutada en el emulador Pixel 7; se verificaron mediante capturas la navegación inicial, el registro de prueba, los cambios de estado y las validaciones de campos obligatorios. **La persistencia tras cerrar y reabrir la aplicación sigue pendiente de comprobación documentada.**

> **Aviso:** prototipo universitario con casos y datos ficticios. No ofrece adopciones ni rescates reales, no envía reportes a organizaciones, no realiza pagos y **no cuenta con autenticación administrativa**.

## 1. Descripción del proyecto

Huellitas del Viajero es un prototipo de aplicación Android que reúne perfiles demostrativos de perros vulnerables, información sobre apadrinamiento y un formulario para ensayar el reporte de casos. La idea se originó en un wireframe elaborado con MIT App Inventor y se implementó posteriormente como una aplicación nativa nueva en Android Studio. Su objetivo académico es mostrar cómo organizar un recorrido accesible para ciudadanos y una vista de seguimiento de reportes ficticios.

## 2. Exposición del problema

La información sobre animales que requieren ayuda puede estar distribuida en diferentes canales, lo que dificulta consultar perfiles y conocer formas de colaborar. El prototipo reúne esas opciones en una interfaz de demostración, pero todavía **no conecta con refugios, fundaciones, rescatistas ni bases de datos compartidas**. Es una propuesta de experiencia de usuario y no un servicio operativo.

## 3. Plataforma

- **Android Studio**, **Kotlin** y **Jetpack Compose**.
- Proyecto Gradle con `minSdk 24` y `targetSdk 37`, según `app/build.gradle.kts`.
- Pruebas visuales en emulador **Pixel 7, API 37.2** (capturas del 18 de octubre de 2026).
- Datos de reportes demo almacenados en el dispositivo con `SharedPreferences` y formato `JSON`.
- Sin backend, pagos, sincronización remota ni servicios externos de rescate.
- Código fuente principal: [`android/HuellitasDelViajero`](android/HuellitasDelViajero).

## 4. Interfaz de usuario e interfaz de administrador

**Interfaz de usuario:** portada, menú *Ver perritos*, fichas de detalle de Firulais, Luna y Rocky, explicación de apadrinamiento y formulario de reporte con descripción y ubicación ficticia. Los campos obligatorios muestran errores cuando están vacíos.

**Panel administrativo (Demo):** muestra cantidad y detalle de los reportes guardados y permite cambiar estados entre **Pendiente, En revisión y Cerrado**. **No existe inicio de sesión, autorización por roles ni tratamiento de reportes reales**. La visualización de reportes está disponible desde el menú del prototipo para fines académicos.

## 5. Funcionalidad y resultados de las pruebas

| Comprobación | Evidencia | Resultado |
|---|---|---|
| Compilación y apertura en Pixel 7 | Captura de inicio M8 | Observado: correcto |
| Navegación inicial | Pantalla de inicio | Observado: opciones visibles |
| Registro de reporte ficticio | Formulario completo y panel | Observado: un reporte registrado y listado |
| Modificar a En revisión | Captura del panel | Observado: estado cambiado |
| Modificar a Cerrado | Captura del panel | Observado: estado cambiado |
| Guardar con ambos campos vacíos | Captura de formulario | Observado: mensajes de validación |
| Persistencia tras reinicio de la app | Sin captura específica | **Pendiente de confirmación** |
| Validación de lista, detalle y apadrinamiento en M8 | Evidencias de M5 | Se conserva el código; no se realizó una nueva verificación capturada en M8 |

Las evidencias nuevas se encuentran en [`evidencias/modulo-8/`](evidencias/modulo-8/). Las capturas anteriores están en [`evidencias/modulo-5/`](evidencias/modulo-5/).

## 6. Diseño: wireframes y esquemas de página

**Wireframe inicial:** [`evidencias/pantalla-inicio.png`](evidencias/pantalla-inicio.png), creado como concepto en MIT App Inventor.

**Flujo de pantallas:**

```text
                             ┌──────────────┐
                             │    INICIO    │
                             └──────┬───────┘
              ┌─────────────────────┼─────────────────────┐
              │                     │                     │
         VER PERRITOS           APADRINAR             REPORTAR CASO
              │                (información)              │
        LISTA FICTICIA                                     │
              │                                    VALIDAR FORMULARIO
       DETALLE DE PERFIL                                  │
                                                  GUARDADO LOCAL DEMO
                                                        │
                               PANEL ADMINISTRATIVO (DEMO)
                                       │
                          VER REPORTE Y CAMBIAR ESTADO
                      PENDIENTE → EN REVISIÓN → CERRADO
```

**Esquema del formulario:** descripción + ubicación ficticia → validación → guardado local.  
**Esquema administrativo:** contador de reportes → detalle, fecha y estado → botones de actualización.

## 7. Registro de cambios

Consulta [`CHANGELOG.md`](CHANGELOG.md) y [`PRUEBAS_M8.md`](PRUEBAS_M8.md). Los cambios de M8 se diferenciaron de las funciones desarrolladas hasta M5. No se atribuyen pruebas de datos en producción ni funciones de pagos.

## 8. Instalación y ejecución

1. Abrir **`android/HuellitasDelViajero`** desde **File → Open** en Android Studio (no abrir únicamente la carpeta superior del repositorio).
2. Esperar la sincronización de Gradle y seleccionar **Pixel 7**.
3. Ejecutar la configuración **app**.
4. Probar *Reportar caso* con campos vacíos y luego con datos ficticios válidos.
5. Abrir *Panel administrativo (Demo)* y comprobar los estados.
6. Para confirmar persistencia: cerrar completamente la app, volverla a abrir y verificar que el reporte y el estado se conservan; guardar una evidencia adicional.

## 9. Entregables y enlaces

- **README:** archivo actual [`README.md`](README.md).
- **Borrador del informe:** [`documentos/M8_borrador_informe.md`](documentos/M8_borrador_informe.md).
- **Informe Word:** [`documentos/JohanTellez_COM437_M8_Informe_Final.docx`](documentos/JohanTellez_COM437_M8_Informe_Final.docx).
- **Registro de cambios:** [`CHANGELOG.md`](CHANGELOG.md).
- **Guía de exposición y presentación:** [`presentacion/`](presentacion/), si se incluye en la entrega GitHub.
- **Repositorio:** https://github.com/jopingipv4/huellitas-del-viajero

**Enlaces directos cuando se publique el commit en `main`:**  
README: https://github.com/jopingipv4/huellitas-del-viajero/blob/main/README.md  
Borrador: https://github.com/jopingipv4/huellitas-del-viajero/blob/main/documentos/M8_borrador_informe.md

> Estos enlaces **no se consideran actualizados hasta subir los archivos**. No se ha realizado aquí ninguna publicación en GitHub. GitHub Classroom fue descontinuado el 28 de agosto de 2026, por lo cual el proyecto se presenta en el repositorio personal y se solicita al profesor la modalidad equivalente de entrega tipo wiki: https://github.blog/changelog/2026-08-27-github-classroom-deprecated/.

## 10. Alcance y próximos pasos

La aplicación es una demostración, no un producto listo para usuarios reales. Una futura versión requeriría autenticación, roles, respaldo y sincronización segura, moderación, controles de privacidad, alianzas con entidades de protección animal y comprobaciones funcionales adicionales. La prioridad sería garantizar un proceso verificable antes de recibir casos reales.
