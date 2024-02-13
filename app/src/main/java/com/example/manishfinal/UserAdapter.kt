package com.example.manishfinal

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth

class UserAdapter(val contex :Context, val userlist : ArrayList<User>):
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
       val view: View = LayoutInflater.from(contex).inflate(R.layout.user_layout,parent,false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userlist.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        val currentUser =userlist[position]
        holder.textname.text= currentUser.name

        holder.itemView.setOnClickListener {
            val intent =Intent(contex, ChatActivity::class.java)

            intent.putExtra("name",currentUser.name)
            intent.putExtra("name",currentUser.uid)
            contex.startActivity(intent)

        }

    }


    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val textname= itemView.findViewById<TextView>(R.id.text_name)
    }
}