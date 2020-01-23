package com.example.in_class_exercise_2_action_bar_network_request_task;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.springframework.web.client.RestTemplate;

public class GetAWebResourceTask extends AsyncTask<String, Void, String> {
    final public static String TAG = "GetAWebResourceTask";
    private RestTemplate restTemplate;
    private TextView textView;

    public GetAWebResourceTask(RestTemplate restTemplate, TextView textView) {
        this.restTemplate = restTemplate;
        this.textView = textView;
    }


    @Override
    protected String doInBackground(String... strings) {
        String result = restTemplate.getForObject(strings[0], String.class);
        Log.d(TAG, result);
        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        textView.setText(s);
    }
}
