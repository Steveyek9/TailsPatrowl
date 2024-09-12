package org.example.project.Navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import org.example.project.Navigation.auth.DefaultLoginComponent
import org.example.project.Navigation.auth.DefaultRegistrationComponent

class DefaultRootComponent(
    componentContext: ComponentContext,

) : RootComponent, ComponentContext by componentContext{

    private val nav = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, RootComponent.Child>> = childStack(
        source = nav,
        serializer = Config.serializer(),
        initialConfiguration = Config.Login,
        handleBackButton = true,
        childFactory = ::CreateChild,
    )

    private fun CreateChild(
        config: Config,
        componentContext: ComponentContext
    ): RootComponent.Child = when (config) {
        Config.Login -> RootComponent.Child.LoginChild(
            DefaultLoginComponent(
                componentContext = componentContext,
                onRegister = {
                    nav.pushNew(Config.Registration)
                }
            )
        )
        is Config.Registration -> RootComponent.Child.RegistrationChild(
            DefaultRegistrationComponent(
                componentContext = componentContext,
                onBack = {
                    nav.pop()
                },
            )
        )
    }


    @kotlinx.serialization.Serializable
     sealed class Config {
        @kotlinx.serialization.Serializable
        data object Login : Config()

        @Serializable
        data object Registration : Config()

    }

}