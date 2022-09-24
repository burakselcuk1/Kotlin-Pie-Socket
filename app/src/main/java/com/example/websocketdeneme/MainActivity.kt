package com.example.websocketdeneme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.websocketdeneme.databinding.ActivityMainBinding
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client: OkHttpClient =  OkHttpClient()

        binding.connect.setOnClickListener {
            Log.d("PieSocket","Connecting");
            val apiKey = "VCXCEuvhGcBDP7XhiJJUDvR1e1D3eiVjgZ9VRiaV"; //Demo key, get yours at https://piesocket.com
            val channelId = 1;

            val request: Request = Request
                .Builder()
                .url("wss://demo.piesocket.com/v3/$channelId?api_key=$apiKey&notify_self")
                .build()
            val listener = PieSocketListener()
            val ws: WebSocket = client.newWebSocket(request, listener)
        }

    }
}