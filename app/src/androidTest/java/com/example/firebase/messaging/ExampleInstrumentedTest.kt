package com.example.firebase.messaging

import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*


@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
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
                assert(token.isNotBlank())
            })
    }
}