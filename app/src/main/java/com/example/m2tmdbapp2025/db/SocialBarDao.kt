package com.example.m2tmdbapp2025.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.MapColumn
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SocialBarDao {

    @Query("SELECT person_id, is_favorite FROM social_bar_table")
    fun getAllFavorites(): Flow<MutableMap<@MapColumn(columnName = "person_id") Int, @MapColumn(
        columnName = "is_favorite"
    ) Boolean>>

    @Query("SELECT person_id, nb_likes FROM social_bar_table")
    fun getAllLikes(): Flow<MutableMap<@MapColumn(columnName = "person_id") Int, @MapColumn(
        columnName = "nb_likes"
    ) Int>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(socialBarEntity: SocialBarEntity) : Long
}