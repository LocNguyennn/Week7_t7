package com.watasolutions.week7_t7.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.watasolutions.week7_t7.R
import com.watasolutions.week7_t7.model.User
import kotlinx.android.synthetic.main.item_view_user.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view_user,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.email.text = currentItem.username
        holder.itemView.password.text = currentItem.password
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user : List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}