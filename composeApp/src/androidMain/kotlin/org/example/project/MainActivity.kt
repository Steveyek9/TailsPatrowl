package org.example.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.retainedComponent
import org.example.project.Navigation.DefaultRootComponent
import org.example.project.Navigation.RootComponent
import org.example.project.ui.auth.LoginView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root = retainedComponent {
            DefaultRootComponent(it)
        }

        setContent {
        App(root)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    //App()

}