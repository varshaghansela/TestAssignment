package com.example.myapplication.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.UserItemBinding
import com.example.myapplication.ui.models.User

class UserListAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder?>() {

    private var userList: MutableList<User> = mutableListOf()

    fun addAll(userList: MutableList<User>) {

        this.userList.addAll(userList)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return MyViewHolder(
            UserItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val user = userList[position]
        (holder as MyViewHolder).binding.user = user

    }

    override fun getItemCount(): Int {
        return userList.size
    }


    private fun getItem(position: Int): User {
        return userList[position]
    }

    class MyViewHolder(var binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root)
}