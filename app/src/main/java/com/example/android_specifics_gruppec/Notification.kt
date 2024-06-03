package com.example.android_specifics_gruppec

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

val channel_ID = "ch-1"
val channel_Name = "Test Notification"
val notification_id = 100
val REQUEST_CODE = 200
class Notification(
    val context :Context
) {
    val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    val myIntent = Intent(context, MainActivity::class.java)
    val pendingIntent = PendingIntent.getActivity(
        context,
        REQUEST_CODE,
        myIntent,
        PendingIntent.FLAG_IMMUTABLE
    )

    fun showNotification(){
        val notification =
            NotificationCompat.Builder(context, channel_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Test")
                .setContentText("Hi")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .build()

        notificationManager.notify(notification_id, notification)

    }


}


/*
package com.example.android_specifics_gruppec

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

// Definiere die Kanal-ID für die Benachrichtigung
val channel_ID = "ch-1"

// Definiere den Kanalnamen für die Benachrichtigung
val channel_Name = "Test Notification"

// Definiere eine Benachrichtigungs-ID
val notification_id = 100

// Definiere einen Anforderungscode für das PendingIntent
val REQUEST_CODE = 200

// Klasse für die Erstellung und Anzeige von Benachrichtigungen
class Notification(
    val context :Context // Kontext des Aufrufers
) {
    // Hole den NotificationManager-Dienst aus dem System
    val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    // Erstelle ein Intent, das die MainActivity startet
    val myIntent = Intent(context, MainActivity::class.java)

    // Erstelle ein PendingIntent, das beim Klicken auf die Benachrichtigung ausgeführt wird
    val pendingIntent = PendingIntent.getActivity(
        context, // aktueller Kontext
        REQUEST_CODE, // eindeutiger Anforderungscode
        myIntent, // das Intent, das ausgeführt wird
        PendingIntent.FLAG_IMMUTABLE // Flag, das angibt, dass das PendingIntent unveränderlich ist
    )

    // Funktion zum Anzeigen der Benachrichtigung
    fun showNotification(){
        // Erstelle die Benachrichtigung mit den angegebenen Eigenschaften
        val notification =
            NotificationCompat.Builder(context, channel_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground) // Symbol der Benachrichtigung
                .setContentTitle("Test") // Titel der Benachrichtigung
                .setContentText("Hi") // Text der Benachrichtigung
                .setPriority(NotificationCompat.PRIORITY_HIGH) // Priorität der Benachrichtigung
                .setContentIntent(pendingIntent) // Das PendingIntent, das ausgeführt wird, wenn die Benachrichtigung angeklickt wird
                .build()

        // Zeige die Benachrichtigung mit der angegebenen ID an
        notificationManager.notify(notification_id, notification)
    }
}

 */
