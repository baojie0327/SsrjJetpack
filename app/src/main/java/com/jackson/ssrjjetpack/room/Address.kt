package com.jackson.ssrjjetpack.room

import androidx.room.ColumnInfo


/*
* Address  2019-09-18
* Copyright (c) 2019 KL Co.Ltd. All right reserved.
*
*/
/*
* class description here
* @author Jackson
* @version 1.0.0
* since 2019 09 18
*/
class Address {
    public var street: String? = null
    public var state: String? = null
    public var city: String? = null

    @ColumnInfo(name = "post_code")
    public var postCode = 0
}