package com.example.android_specifics_gruppec

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_specifics_gruppec.ui.theme.Android_specifics_gruppeCTheme
import com.example.android_specifics_gruppec.ui.theme.red
import android.app.NotificationManager
import android.app.NotificationChannel
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedButton
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_specifics_gruppeCTheme {
               val notificationService = Notification(applicationContext)
                
                Box(modifier = Modifier
                    .fillMaxSize(),
                    contentAlignment = Alignment.Center){

                    Column(modifier = Modifier
                        .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                           val permissionState = rememberPermissionState(
                               permission = android.Manifest.permission.POST_NOTIFICATIONS
                           )
                            if(!permissionState.status.isGranted){
                                OutlinedButton(onClick = { permissionState.launchPermissionRequest() }) {
                                    Text(text = "Allow Notification",
                                        fontSize = 22.sp)
                                }
                            }
                        }
                        
                        Spacer(modifier = Modifier.size(16.dp))
                        Button(onClick = { notificationService.showNotification() }) {
                            Text(text = "Show Notification",
                                fontSize = 22.sp)
                        }
                    }
                }
            }
        }
    }
}

/*
package com.example.android_specifics_gruppec

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_specifics_gruppec.ui.theme.Android_specifics_gruppeCTheme
import com.example.android_specifics_gruppec.ui.theme.red
import android.app.NotificationManager
import android.app.NotificationChannel
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedButton
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

// Definiere die MainActivity, die von ComponentActivity erbt
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setze den Inhalt der Activity mit einer Compose-Funktion
        setContent {
            Android_specifics_gruppeCTheme {
                // Erstelle ein Notification-Objekt mit dem Anwendungskontext
                val notificationService = Notification(applicationContext)

                // Definiere eine Box, die den gesamten Bildschirm füllt
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    // Definiere eine Spalte, die die gesamte Breite füllt und ihre Elemente zentriert
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Überprüfe, ob die Android-Version TIRAMISU (API 33) oder höher ist
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                            // Definiere den Berechtigungsstatus für Benachrichtigungen
                            val permissionState = rememberPermissionState(
                                permission = android.Manifest.permission.POST_NOTIFICATIONS
                            )
                            // Wenn die Berechtigung nicht erteilt ist, zeige eine Schaltfläche, um die Berechtigung anzufordern
                            if (!permissionState.status.isGranted) {
                                OutlinedButton(onClick = { permissionState.launchPermissionRequest() }) {
                                    Text(
                                        text = "Allow Notification",
                                        fontSize = 22.sp
                                    )
                                }
                            }
                        }

                        // Füge einen Abstand von 16dp hinzu
                        Spacer(modifier = Modifier.size(16.dp))

                        // Definiere eine Schaltfläche, um eine Benachrichtigung zu zeigen
                        Button(onClick = { notificationService.showNotification() }) {
                            Text(
                                text = "Show Notification",
                                fontSize = 22.sp
                            )
                        }
                    }
                }
            }
        }
    }
}


Erklärung:

    package: Gibt das Paket an, in dem sich diese Datei befindet.
    import: Importiert benötigte Klassen und Schnittstellen.
    MainActivity: Eine Activity, die von ComponentActivity erbt und den Einstiegspunkt der App darstellt.
    @OptIn(ExperimentalPermissionsApi::class): Eine Annotation, die den experimentellen Status der verwendeten Berechtigungs-API angibt.
    onCreate: Die Methode, die aufgerufen wird, wenn die Activity erstellt wird.
    setContent: Eine Methode, um den Inhalt der Activity mit einer Compose-Funktion zu setzen.
    Android_specifics_gruppeCTheme: Eine benutzerdefinierte Themenfunktion für die App.
    Box: Ein Layout-Container, der seine Kinder in einer Box anordnet.
    Column: Ein Layout-Container, der seine Kinder in einer Spalte anordnet.
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU): Eine Bedingung, die überprüft, ob die aktuelle Android-Version TIRAMISU (API 33) oder höher ist.
    rememberPermissionState: Eine Funktion, die den Zustand einer Berechtigung speichert.
    permissionState.launchPermissionRequest(): Eine Methode, um die Berechtigung anzufordern.
    OutlinedButton: Eine Schaltfläche mit einer Umrandung.
    Spacer: Ein Layout-Element, das einen leeren Raum definiert.
    Button: Eine Schaltfläche, die eine Aktion auslöst.
    Text: Ein Text-Element, das Text anzeigt.
 */



