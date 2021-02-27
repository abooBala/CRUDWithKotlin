package com.demo.roomcrud.db

import android.content.Context
import android.media.SubtitleData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Subscriber::class], version = 1)
abstract class SubscriberDatabase : RoomDatabase() {

//    Abstract reference for the DAO interface
    abstract  val subscriberDAO : SubscriberDAO

//    Create singletons with a companion object
    companion object{
    @Volatile
    private var INSTANCE : SubscriberDatabase? = null

        fun getInstance(context: Context):SubscriberDatabase {
            synchronized(this){
                var instance:SubscriberDatabase? = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                    SubscriberDatabase::class.java,
                        "subscriber_data_database"
                    ).build()
                }
                return instance
            }
        }
    }
}