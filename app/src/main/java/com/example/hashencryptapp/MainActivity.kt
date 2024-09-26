package com.example.hashencryptapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import com.google.gson.Gson
import java.io.IOException

data class PublicKeyResponse(val key: String)
class MainActivity : AppCompatActivity() {

    private lateinit var publicKey: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val inputText = findViewById<EditText>(R.id.inputText)
        val hashButton = findViewById<Button>(R.id.hashButton)
        val resultText = findViewById<TextView>(R.id.resultText)


        fetchPublicKey()


        hashButton.setOnClickListener {
            val input = inputText.text.toString()
            if (input.isNotEmpty()) {

                resultText.text = "Processing input: $input\nUsing Public Key: $publicKey"
            } else {
                resultText.text = "Please enter a string."
            }
        }
    }

    private fun fetchPublicKey() {
        val url = "https://demo.api.piperks.com/.well-known/pi-xcels.json"

        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
                runOnUiThread {

                }
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    response.body?.let { responseBody ->
                        val publicKeyJson = responseBody.string()

                        publicKey = Gson().fromJson(publicKeyJson, PublicKeyResponse::class.java).key
                        runOnUiThread {

                        }
                    }
                }
            }
        })
    }
}
