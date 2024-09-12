package org.example.project.Navigation.auth

import com.arkivanov.decompose.ComponentContext

class DefaultRegistrationComponent (
    componentContext: ComponentContext,
    private val onBack: () -> Unit,
): RegistrationComponent ,ComponentContext by componentContext{
    override fun onBackPressed() = onBack()

}