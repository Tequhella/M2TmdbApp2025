package com.example.m2tmdbapp2025

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.m2tmdbapp2025.model.PersonPopularResponse
import okhttp3.Callback
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val LOGTAG = MainActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tmdbapi = ApiClient.instance.create(ITmdbApi::class.java)
        val call = tmdbapi.getPopularPerson(TMDB_API_KEY, 1)

        call.enqueue(object : Callback<PersonPopularResponse>) {
            override fun onResponse(
                call: Call<PersonPopularResponse>,
                response: Response<PersonPopularResponse>
            ) {
                if (response.isSuccessful) {
                    Log.d(LOGTAG,"API OK")
                }
            }

        }
        override fun onFailure(call: Call<PersonPopularResponse>, t: Throwable) {
            Log.e(LOGTAG, "Call to TMDB API failed")
        }

    })

}