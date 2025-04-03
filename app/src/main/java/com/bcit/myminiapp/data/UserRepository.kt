package com.bcit.myminiapp.data

class UserRepository(private val userDao: UserDao) {

    //data access logic
    // layer of abstraction between data sources and business logic

    fun insertEntity(user: LocalUser) {
        userDao.add(user)
    }

    fun getAll(): List<LocalUser> {
        return userDao.getAll()
    }
}