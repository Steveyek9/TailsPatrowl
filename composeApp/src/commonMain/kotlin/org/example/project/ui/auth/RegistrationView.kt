package org.example.project.ui.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.Navigation.auth.LoginComponent
import org.example.project.Navigation.auth.RegistrationComponent

@Composable
fun RegistrationView(
    component: RegistrationComponent,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Welcome", style = MaterialTheme.typography.h5)

        Spacer(modifier = Modifier.height(20.dp))

        // Bottone per tornare indietro
        Button(onClick = { component.onBackPressed() }) {
            Text(text = "Torna indietro")
        }
    }
}
