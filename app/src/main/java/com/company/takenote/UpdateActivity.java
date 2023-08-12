package com.company.takenote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText updateTitle,updateDescription;
    Button updateSave,updateCancel;
    int updateid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Toolbar toolbar = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Update Note");

        updateTitle = findViewById(R.id.editTextUpdateTitle);
        updateDescription = findViewById(R.id.editTextUpdateDescription);
        updateSave = findViewById(R.id.buttonUpdateSave);
        updateCancel = findViewById(R.id.buttonUpdateCancel);

        getData();

        updateCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        updateSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    updateNote();
            }
        });
    }

    public void updateNote(){

        String titlelast = updateTitle.getText().toString();
        String descriptionlast = updateDescription.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("titlelast",titlelast);
        intent.putExtra("descriptionlast",descriptionlast);

        if(updateid != -1)
        {
            intent.putExtra("updateid",updateid);
            setResult(RESULT_OK,intent);
            finish();
        }


    }

    public void getData(){
        Intent i = getIntent();
        updateid = i.getIntExtra("id",-1);
        String updateTitle1 = i.getStringExtra("updateTitle");
        String updateDescription1 = i.getStringExtra("updateDescription");

        Log.d("UpdateActivity",updateTitle1);
        Log.d("UpdateActivity",updateDescription1);

        updateTitle.setText(updateTitle1);
        updateDescription.setText(updateDescription1);
    }
}