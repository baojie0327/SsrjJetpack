package com.jackson.ssrjjetpack.room

import androidx.room.*

@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User)

    @Insert
    fun insertAll(vararg users:User)

    @Delete
    fun delete(user:User)

    @Update
    fun update(user: User)

    @Query("SELECT * FROM userDataBase")
    fun getAll():List<User>

   @Query("SELECT * FROM userDataBase WHERE uid IN (:userIds)")
   fun loadAllByIds(userIds:IntArray):List<User>

    @Query("SELECT * FROM userDataBase WHERE first_name LIKE :first AND last_name LIKE:last LIMIT 1")
    fun findByName(first:String,last:String):User


}