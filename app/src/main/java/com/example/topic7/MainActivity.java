package com.example.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.PrintStream;

public class MainActivity extends AppCompatActivity {
   EditText etWord,etMeaning;
    Button btnWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etWord=findViewById(R.id.etword);
        etMeaning=findViewById(R.id.etmeaning);
        btnWord=findViewById(R.id.btnWord);
        btnWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
            }
        });
    }
    private void Save() {
        try {
            PrintStream printStream = new PrintStream(openFileOutput("words.txt", MODE_PRIVATE | MODE_APPEND));
            printStream.println(etWord.getText().toString() + "->" + etMeaning.getText().toString());
            Toast.makeText(this, "Saved to" + getFilesDir(), Toast.LENGTH_SHORT).show();
        }catch (IOException e){
            Log.d("Dictionary app","Error:"+e.toString());
            e.printStackTrace();


        }
    }
}
