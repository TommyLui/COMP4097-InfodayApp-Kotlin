package edu.hkbu.comp.comp4097.infoday.data
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.hkbu.comp.comp4097.infoday.ui.events.SampleData

@Database(entities = arrayOf(Event::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun eventDao() : EventDao
    companion object {
        private var instance: AppDatabase? = null
        suspend fun getInstance(context: Context) : AppDatabase {
            if (instance != null)
                return instance!!
            //build an instance
            instance = Room.databaseBuilder(context, AppDatabase::class.java,
                "infoDay").build()
            //initDB()
            return instance!!
        }
        suspend fun initDB() {
            //instance?.clearAllTables() //add this line when you are still debugging
            SampleData.EVENT.forEach { instance?.eventDao()?.insert(it) }
        }
    }
}