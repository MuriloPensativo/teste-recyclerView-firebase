package com.example.testederecyclerviewcomfirebase.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testederecyclerviewcomfirebase.Models.User
import com.example.testederecyclerviewcomfirebase.R
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private val userList = ArrayList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.game_item,
            parent,false
        )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = userList[position]

        holder.tituloJogo.text = currentItem.nome
        holder.dataJogo.text = currentItem.lancamento
        Picasso.get().load(currentItem.imgURI).into(holder.fotoJogo)

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun updateUserList(userList : List<User>){

        this.userList.clear()
        this.userList.addAll(userList)
        notifyDataSetChanged()

    }

    class MyViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){

        val tituloJogo : TextView = itemView.findViewById(R.id.titulo_jogo)
        val dataJogo : TextView = itemView.findViewById(R.id.data_jogo)
        val fotoJogo : ImageView = itemView.findViewById(R.id.foto_jogo)

    }

}
