package com.jackson.ssrjjetpack.room

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


/*
* User  2019-09-17
* Copyright (c) 2019 KL Co.Ltd. All right reserved.
*
*/
/*
* class description here
* @author Jackson
* @version 1.0.0
* since 2019 09 17
*/
// 使用@Entity注解实体类，Room会为实体中定义的每个字段创建一列，如果想避免使用@Ignore注解
@Entity(tableName = "userDataBase")  // Room默认使用类名作为数据库表名，要修改表名使用 @Entity 的 tableName属性
class User {
    @PrimaryKey(autoGenerate = true)   // 自增长ID
    var uid: Int = 0

    @ColumnInfo(name = "first_name")  // 定义列名,不自定义的话，默认为字段名
    var firstName: String? = null

    @ColumnInfo(name = "last_name")
    var lastName: String? = null

    @Embedded
    public var address: Address? = null

}