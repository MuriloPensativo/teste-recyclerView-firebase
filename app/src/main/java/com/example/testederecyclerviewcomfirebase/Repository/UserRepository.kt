package com.example.testederecyclerviewcomfirebase.Repository

import androidx.lifecycle.MutableLiveData
import com.example.testederecyclerviewcomfirebase.Models.User
import com.google.firebase.database.*

class UserRepository {

    private val databaseReference : DatabaseReference = FirebaseDatabase.getInstance().getReference("jogos")

    @Volatile private var INSTANCE : UserRepository ?= null

    fun getInstance() : UserRepository {
        return INSTANCE ?: synchronized(this){
            val instance = UserRepository()
            INSTANCE = instance
            instance
        }
    }

    fun loadUsers(userList : MutableLiveData<List<User>>){

        databaseReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    val _userList : List<User> = snapshot.children.map{ dataSnapshot ->
                        dataSnapshot.getValue(User::class.java)!!
                    }
                    userList.postValue(_userList)
                } catch (e : Exception){
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }

        })

    }

}