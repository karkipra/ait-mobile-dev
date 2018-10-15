package com.pratikkarki.todorecycleviewdemo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pratikkarki.todorecycleviewdemo.R
import com.pratikkarki.todorecycleviewdemo.data.Todo
import kotlinx.android.synthetic.main.todo_row.view.*

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    var todoItems = mutableListOf<Todo>(
            Todo("2018. 09. 10", false, "Eat"),
            Todo("2018. 09. 10", false, "Drink")
    )

    val context : Context

    constructor(context: Context) : super() {
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(
                R.layout.todo_row, parent, false
        )
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return todoItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todo = todoItems[position]

        holder.tvDate.text = todo.createDate
        holder.cbDone.text = todo.todoText
        holder.cbDone.isChecked = todo.done
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvDate = itemView.tvDate
        val cbDone = itemView.cbDone

    }
}