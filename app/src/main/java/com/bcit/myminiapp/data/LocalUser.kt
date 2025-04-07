package com.bcit.myminiapp.data

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase

@Entity(tableName = "history")
data class HistoryEntry(
    @PrimaryKey val studyId: String, // Makes it unique!
    val title: String,
    val timestamp: Long
)

@Dao
interface HistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entry: HistoryEntry)

    @Query("SELECT * FROM history ORDER BY timestamp DESC")
    suspend fun getAll(): List<HistoryEntry>

    @Query("DELETE FROM history WHERE studyId NOT IN (SELECT studyId FROM history ORDER BY timestamp DESC LIMIT 50)")
    suspend fun trimToLast50()
}

@Database(entities = [HistoryEntry::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}

//singleton pattern
object MyDatabase {
    fun getDatbase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "my_db")
            .allowMainThreadQueries()
            .build()

    }
}