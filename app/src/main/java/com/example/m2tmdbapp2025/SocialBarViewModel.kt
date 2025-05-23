package com.example.m2tmdbapp2025

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.m2tmdbapp2025.db.SocialBarDao
import com.example.m2tmdbapp2025.db.SocialBarEntity
import kotlinx.coroutines.launch

class SocialBarViewModel(private val socialBarDao: SocialBarDao) : ViewModel() {
    var nbLikes: LiveData<MutableMap<Int, Int>> = socialBarDao.getAllLikes().asLiveData()
    var isFavorite: LiveData<MutableMap<Int, Boolean>> = socialBarDao.getAllFavorites().asLiveData()

    fun insert(socialBarEntity: SocialBarEntity) = viewModelScope.launch { socialBarDao.insert(socialBarEntity) }
}

class SocialBarViewModelFactory(private val socialBarDao: SocialBarDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SocialBarViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SocialBarViewModel(socialBarDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}