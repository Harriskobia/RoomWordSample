package com.harye.rws

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface WordDao {

    @Query("SELECT * FROM word_table ORDER BY word ASC") /* get all words ordered alphabetically */
    fun getAlphabetizedWords(): Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE )
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table") /* Deletes all records in the table */
    suspend fun deleteAll()

}