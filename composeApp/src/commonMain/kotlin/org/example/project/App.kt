package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.arkivanov.decompose.router.stack.childStack
import org.example.project.Navigation.DefaultRootComponent
import org.example.project.Navigation.RootComponent
import org.example.project.ui.auth.LoginView
import org.example.project.ui.auth.RegistrationView
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import tailspatrowl.composeapp.generated.resources.Res
import tailspatrowl.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App(root: RootComponent) {
    MaterialTheme {
        val childStack by root.stack.subscribeAsState()

        Children(
            stack = childStack,
            animation = stackAnimation (slide())
        ){
            child ->
            when (val instance = child.instance){
                is RootComponent.Child.LoginChild -> LoginView(instance.component)
                is RootComponent.Child.RegistrationChild -> RegistrationView(instance.component)
            }
        }
    }
}