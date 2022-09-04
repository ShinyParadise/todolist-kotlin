package com.example.toDoListKotlin.ui.startup

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.toDoListKotlin.ui.screens.listScreen.ListViewModel
import com.example.toDoListKotlin.ui.screens.listScreen.ListsLiveDataComponent
import com.example.toDoListKotlin.ui.theme.ToDoListAppTheme

// Пока что первый экран - в активити, потому что с транзакциями фрагментов возникла
// ошибочка (incorrect fragment container id - вроде все понятно, но айди неверным
// быть не может, я его брал и из R класса и пробовал через вью биндинг, но ничего
// не помогло)
class MainActivity : AppCompatActivity() {
    private val listViewModel: ListViewModel = ListViewModel()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            ToDoListAppTheme {
                ListsLiveDataComponent(listsLiveData = listViewModel.toDoLists)
            }
        }
    }
}
