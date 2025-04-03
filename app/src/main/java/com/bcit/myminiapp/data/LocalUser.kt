package com.bcit.myminiapp.data

import android.content.Context
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase

@Entity(tableName = "user_table")
data class LocalUser(
    @PrimaryKey(autoGenerate = true) val uid: Int? = null,
    @ColumnInfo(name = "user_name") val userName: String?,
    val email: String?
)

@Dao
interface UserDao {
    @Query("SELECT * FROM user_table")
    fun getAll(): List<LocalUser>

    @Insert
    fun add(user: LocalUser)

}

@Database(entities = [LocalUser::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
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