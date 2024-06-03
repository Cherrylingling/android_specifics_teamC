package com.example.android_specifics_gruppec

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi

class MyApplication:Application() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()

        val notificationManager :NotificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val notificationChannel = NotificationChannel(
            channel_ID,
            channel_Name,
            NotificationManager.IMPORTANCE_HIGH
        )

        notificationManager.createNotificationChannel(notificationChannel)

    }

}

/*
import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi

// Definiere eine Klasse MyApplication, die von der Android Application-Klasse erbt
class MyApplication: Application() {

    // Annotiere die Methode, um anzugeben, dass sie nur auf Android Oreo (API 26) und höher aufgerufen werden kann
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()

        // Hole den NotificationManager-Dienst aus dem System
        val notificationManager: NotificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Erstelle einen NotificationChannel mit der Kanal-ID, dem Kanalnamen und der Wichtigkeit
        val notificationChannel = NotificationChannel(
            channel_ID, // Kanal-ID, definiert im vorherigen Code
            channel_Name, // Kanalname, definiert im vorherigen Code
            NotificationManager.IMPORTANCE_HIGH // Wichtigkeit der Benachrichtigungen in diesem Kanal
        )

        // Registriere den NotificationChannel beim NotificationManager
        notificationManager.createNotificationChannel(notificationChannel)
    }
}


Erklärung:

    import: Importiert benötigte Klassen und Schnittstellen.
    MyApplication-Klasse: Eine Klasse, die von Application erbt und globale Anwendungsinitialisierungen durchführt.
    @RequiresApi(Build.VERSION_CODES.O): Eine Annotation, die angibt, dass diese Methode nur auf Android Oreo (API-Level 26) und höher aufgerufen werden kann.
    onCreate(): Eine Methode, die aufgerufen wird, wenn die Anwendung erstellt wird. Hier werden Initialisierungen durchgeführt.
    notificationManager: Ein Objekt, das den Benachrichtigungsdienst verwaltet.
    notificationChannel: Ein Objekt, das einen Benachrichtigungskanal definiert. Ein Benachrichtigungskanal ist notwendig für Benachrichtigungen ab Android Oreo.
    createNotificationChannel: Eine Methode des NotificationManager, die den definierten Benachrichtigungskanal registriert.
 */