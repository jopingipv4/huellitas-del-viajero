# M8 Actividad — Entrega final de la aplicación de Android

**Huellitas del Viajero**  
Johan Dario Tellez Bonilla — Saint Leo University  
Desarrollo de Apps Móviles (COM-437ES-AVO1) — 18 de octubre de 2026

## Descripción del proyecto

Huellitas del Viajero surgió como una propuesta académica para acercar a personas interesadas en el bienestar animal a perfiles de perros en situación vulnerable. En el diseño se plantearon las opciones Ver perritos, Apadrinar y Reportar caso. Durante los primeros módulos elaboré un wireframe en MIT App Inventor y, en el módulo 5, trasladé la idea a un proyecto nuevo en Android Studio utilizando Kotlin y Jetpack Compose. Para esta entrega final amplié el prototipo con almacenamiento local de reportes ficticios y un panel administrativo de demostración. El propósito es mostrar la estructura y el recorrido de una posible aplicación de apoyo, sin presentarla como una plataforma real de rescate.

## Exposición del problema

La información sobre animales vulnerables suele encontrarse en distintos canales, por lo que puede resultar difícil conocer los casos, identificar necesidades y organizar una manera de colaborar. A partir de esa necesidad diseñé una experiencia básica que permita consultar perfiles e introducir reportes de prueba, aunque todavía no existe conexión con fundaciones o un equipo que atienda casos reales. La prioridad de este prototipo es que las funciones sean comprensibles y comprobables antes de pensar en un despliegue público.

## Plataforma

El proyecto utiliza Android Studio, Kotlin, Jetpack Compose y Gradle. La configuración de Android contempla `minSdk 24` y `targetSdk 37`. Se probó visualmente en un emulador Pixel 7 API 37.2. Los datos de demostración se almacenan de forma local con `SharedPreferences` y JSON. No hay backend, autenticación, pagos, uso de mapas ni sincronización con sistemas externos; el código se encuentra en `android/HuellitasDelViajero`.

## Interfaz de usuario e interfaz de administrador

La interfaz para el usuario contiene la pantalla de inicio, lista de tres perros ficticios, detalles, información de apadrinamiento y el formulario para reportar casos de prueba. En el módulo 8 se añadieron mensajes de validación y guardado local, manteniendo visibles las advertencias de que se utilizan datos ficticios. La interfaz administrativa, igualmente demostrativa, muestra los reportes introducidos en el dispositivo y permite cambiar su estado entre Pendiente, En revisión y Cerrado. No posee contraseña, permisos diferenciados ni acceso exclusivo, por lo que **no debe considerarse segura para gestión real de casos**.

## Funcionalidad

En el emulador comprobé que se presenta la pantalla inicial y que se puede ingresar un reporte ficticio con descripción y ubicación, el cual aparece en el panel de demostración. También observé la actualización del estado a En revisión y Cerrado. Cuando intenté guardar el formulario con los dos campos vacíos, la aplicación mostró mensajes de validación específicos. En el código se implementó el almacenamiento local de los reportes; su funcionamiento después de cerrar y abrir completamente la aplicación queda pendiente de confirmar con evidencia adicional. Los perfiles de perros continúan siendo demostrativos y el apadrinamiento se mantiene como información, sin gestionar pagos.

## Diseño (wireframes o esquemas de página)

El wireframe elaborado al inicio del curso sirvió como referencia, pero el proyecto Android se implementó como una aplicación nueva y no como una conversión automática desde MIT App Inventor. El recorrido principal es Inicio → Ver perritos → Detalle; Inicio → Apadrinar; Inicio → Reportar caso → Validación y guardado local; e Inicio → Panel administrativo (Demo) → Consulta y cambio de estado. En el README se incluyen esquemas de este flujo, además de los enlaces a las evidencias de las pantallas del módulo 5 y del módulo 8.

## Pruebas y evidencias

Las capturas permiten distinguir la presentación normal de la aplicación, el formulario con datos, un reporte guardado, los estados Pendiente, En revisión y Cerrado, y los errores de campos vacíos. Corresponden a una ejecución en Pixel 7 API 37.2 el 18 de octubre de 2026. El registro detallado se encuentra en `PRUEBAS_M8.md`. Aunque el código prevé persistencia local, no se presenta como resultado comprobado después de reiniciar la aplicación mientras no exista una verificación registrada.

## Registro de cambios y alcance

El módulo 5 incorporó las pantallas iniciales y los perfiles ficticios, mientras que el módulo 8 añadió guardado local, validaciones visibles y panel de seguimiento. Se mantienen como limitaciones la ausencia de servidor, autenticación, atención de casos reales, pagos e integración con entidades de bienestar animal. Estos elementos serían parte de una etapa futura y requerirían privacidad, moderación, permisos y pruebas completas.

## Publicación, README y entrega

El archivo `README.md` contiene el borrador del proyecto con los seis apartados solicitados y un resumen de las pruebas. La documentación se complementa con `CHANGELOG.md`, `PRUEBAS_M8.md` y los archivos de evidencia. La publicación del módulo 8 en el repositorio personal se realizará cuando se suba este paquete; por el momento no se declara un enlace actualizado o una entrega efectuada en GitHub Classroom, descontinuado en agosto de 2026.

## Conclusión

Con esta actividad conseguí avanzar desde un diseño de pantalla hasta un prototipo Android que permite demostrar el registro y seguimiento de reportes ficticios. Considero que lo más importante no fue incorporar más opciones, sino comprobar que el formulario responde, que los datos aparecen donde corresponde y que una modificación de estado se refleja en pantalla. Aun así, la entrega mantiene límites claros: antes de utilizarlo con personas o animales reales sería necesario fortalecer seguridad, privacidad, almacenamiento y coordinación con organizaciones. De esa manera, el proyecto podría evolucionar de una demostración académica a una solución que aporte valor de forma responsable.

## Referencias

Android Developers. (s. f.). *Introducción a Android Studio*. https://developer.android.com/studio/intro?hl=es-419

GitHub Docs. (s. f.). *Acerca del archivo LÉAME del repositorio*. https://docs.github.com/es/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/about-readmes

GitHub. (2026, 27 de agosto). *GitHub Classroom deprecated*. https://github.blog/changelog/2026-08-27-github-classroom-deprecated/
