package br.com.androiddev.model

data class Address(
    val id: Int,
    val state: String,
    val city: String,
    val cep: String,
    val neighborhoods: List<Neighborhood>
)