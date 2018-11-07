package hu.aut.android.todorecyclerviewdemo.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface TodoDAO {

    @Query("SELECT * FROM todo")
    fun findAllTodos(): List<Todo>

    @Insert
    fun insertTodo(item: Todo)

    @Delete
    fun deleteTodo(item: Todo)
}