package com.example.m2tmdbapp2025

import androidx.lifecycle.ViewModel

class SocialBarViewModel : ViewModel() {
    var nbLikes = mutableMapOf<Int,Int>()
    var isFavorite = mutableMapOf<Int, Boolean>()
}