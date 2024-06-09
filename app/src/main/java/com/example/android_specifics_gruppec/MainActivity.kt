package com.example.android_specifics_gruppec

import android.Manifest
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_specifics_gruppec.ui.theme.Android_specifics_gruppeCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_specifics_gruppeCTheme {
                MainScreen(applicationContext)
            }
        }
    }
}

@Composable
fun MainScreen(context: Context) {
    val notificationService = Notification(context)
    val permissionState = remember { mutableStateOf(false) }

    val requestPermissionLauncher = rememberLauncherForPermission {
        permissionState.value = it
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !permissionState.value) {
                OutlinedButton(
                    onClick = { requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS) },
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Text(text = "Allow Notification", fontSize = 22.sp)
                }
            }

            Button(
                onClick = { notificationService.showNotification() },
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Text(text = "Show Notification", fontSize = 22.sp)
            }
        }
    }
}

@Composable
fun rememberLauncherForPermission(onPermissionResult: (Boolean) -> Unit): ActivityResultLauncher<String> {
    return rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
        onPermissionResult(isGranted)
    }
}





