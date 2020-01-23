package com.example.in_class_exercise_2_action_bar_network_request_task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        textView = findViewById(R.id.text_view);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        GetAWebResourceTask getAWebResourceTask = new GetAWebResourceTask(restTemplate, textView);

        if (item.getItemId() == R.id.posts) {
            String temp = "https://jsonplaceholder.typicode.com/posts";
            getAWebResourceTask.execute(temp);

        } else if (item.getItemId() == R.id.users) {
            Log.v("TOOLBAR: ", "YOU PRESSED USERS");
            String temp = "https://jsonplaceholder.typicode.com/users";
            getAWebResourceTask.execute(temp);
        }

        return super.onOptionsItemSelected(item);
    }

}
