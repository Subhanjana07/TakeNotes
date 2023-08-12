package com.company.takenote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    EditText newTitle,newDescription;
    Button save,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        Toolbar toolbar = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add Note");

        newTitle = findViewById(R.id.editTextUpdateTitle);
        newDescription = findViewById(R.id.editTextUpdateDescription);
        save = findViewById(R.id.buttonUpdateSave);
        cancel = findViewById(R.id.buttonUpdateCancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((newTitle.getText().toString()).equals(""))
                    Toast.makeText(AddNoteActivity.this, "Please enter a title", Toast.LENGTH_SHORT).show();
                else
                    saveNote();
            }
        });
    }
    public void saveNote(){
        String noteTitle =newTitle.getText().toString();
        String notedDescription =newDescription.getText().toString();

        Intent intent =new Intent();
        intent.putExtra("noteTitle",noteTitle);
        intent.putExtra("notedDescription",notedDescription);
        setResult(RESULT_OK,intent);
        finish();
    }
}