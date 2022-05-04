package com.example.firebase.messaging

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        FirebaseMessaging.getInstance().token
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    println("La recuperation du token a echoue")
                    return@OnCompleteListener
                }
                // On recupere le TOKEN
                val token = task.result
                // On recupére et on affiche le token
                Log.d("TOKEN", token)
            })
    }
}