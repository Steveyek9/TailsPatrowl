package org.example.project.Models

import kotlinx.serialization.Serializable


@Serializable
data class LoginProfile (
    val email: String
)