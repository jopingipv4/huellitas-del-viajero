package com.jopingipv4.huellitasdelviajero.model

data class Dog(
    val id: String,
    val name: String,
    val breed: String,
    val age: String,
    val location: String,
    val description: String,
    val healthStatus: String
)

val sampleDogs = listOf(
    Dog(
        id = "1",
        name = "Firulais (Demo)",
        breed = "Mestizo",
        age = "2 años",
        location = "Parque Central, Sector Norte",
        description = "Rescatado cerca del mercado local. Es muy juguetón, cariñoso y convive bien con otros animales.",
        healthStatus = "Vacunado y esterilizado"
    ),
    Dog(
        id = "2",
        name = "Luna (Demo)",
        breed = "Labrador Mix",
        age = "1 año y medio",
        location = "Av. Del Sol, Zona Este",
        description = "Encontrada desorientada cerca de la terminal. Le encanta correr y es excelente con niños.",
        healthStatus = "Vacunación completa"
    ),
    Dog(
        id = "3",
        name = "Rocky (Demo)",
        breed = "Criollo",
        age = "4 años",
        location = "Barrio San José",
        description = "Perrito tranquilo y guardián que busca un hogar donde reciba cariño y un espacio cómodo.",
        healthStatus = "En recuperación con tratamiento veterinario"
    )
)
