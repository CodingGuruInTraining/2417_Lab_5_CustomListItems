package com.example.hl4350hb.customlistitemsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addNewButton = (Button) findViewById(R.id.new_todo_item_button);
        final EditText newToDoEditView = (EditText) findViewById(R.id.new_todo_item_edittext);

        ListView todoListView = (ListView) findViewById(R.id.todo_listview);

        // Create ArrayAdapter
        final ToDoListAdapter toDoListAdapter = new ToDoListAdapter(this, R.layout.todo_list_item);

        // Configure the ListView to use this Adapter for data
        todoListView.setAdapter(toDoListAdapter);

        // Add listener to the button to add items to the ListView
        addNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Read EditText
                String newItemText = newToDoEditView.getText().toString();

                // Make sure some data is entered
                if (newItemText.length() == 0) {
                    Toast.makeText(MainActivity.this, "Enter a ToDo item", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Create a new ToDoItem from the text and add to the ArrayAdapter
                ToDoItem newItem = new ToDoItem(newItemText);
                toDoListAdapter.add(new ToDoItem(newItemText));

                // Notify the ArrayAdapter of change
                toDoListAdapter.notifyDataSetChanged();

                // Clear EditText
                newToDoEditView.getText().clear();
            }
        });
    }
}
