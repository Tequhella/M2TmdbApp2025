package com.example.m2tmdbapp2025

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ITmdbApi {
    @GET("users/{userId}")
    suspend fun getUser(@Path("userId") userId: Int): Response<com.google.firebase.firestore.auth.User>

    // Ajoutez d'autres points de terminaison ici...
}