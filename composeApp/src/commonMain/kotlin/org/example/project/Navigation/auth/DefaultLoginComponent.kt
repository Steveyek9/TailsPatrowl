package org.example.project.Navigation.auth

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import org.example.project.Models.LoginProfile

class DefaultLoginComponent(
    componentContext: ComponentContext,
    private val onRegister: () -> Unit,
) : LoginComponent ,ComponentContext by componentContext{

    override fun onRegClicked() = onRegister()

}