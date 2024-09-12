package org.example.project.Navigation

import com.arkivanov.decompose.Child
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import org.example.project.Navigation.auth.LoginComponent
import org.example.project.Navigation.auth.RegistrationComponent

interface RootComponent {
    val stack: Value<ChildStack<*, Child>>
    sealed class Child {
        class LoginChild(val component: LoginComponent) : Child()
        class RegistrationChild(val component: RegistrationComponent) : Child()
    }

}