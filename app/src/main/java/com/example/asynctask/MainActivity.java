package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txt_msg;
    Button btn_start, btn_stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_msg = findViewById(R.id.text_message);
        btn_start = findViewById(R.id.start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExampleAsyncTask task = new ExampleAsyncTask();
                task.execute();
            }
        });
        btn_stop = findViewById(R.id.stop);
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_msg.setSelected(false);
                txt_msg.setVisibility(View.INVISIBLE);
            }
        });
    }
    private class ExampleAsyncTask extends AsyncTask<String, String, String>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(getBaseContext(),"Async Task Started!!!!!!!!",Toast.LENGTH_SHORT).show();
        }
        @Override
        protected String doInBackground(String... strings) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            txt_msg.setVisibility(View.VISIBLE);
            txt_msg.setSelected(true);
        }
    }
}