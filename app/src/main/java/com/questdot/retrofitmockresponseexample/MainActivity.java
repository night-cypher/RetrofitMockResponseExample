package com.questdot.retrofitmockresponseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.questdot.retrofitmockresponseexample.api.RestClient;
import com.questdot.retrofitmockresponseexample.models.ResponseData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView txtResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResponse = (TextView)findViewById(R.id.txtResponse);

        RestClient.getClient(this).login("abc", "123456").enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                txtResponse.setText(response.body().getData().toString());
                Log.d("MainActivity", response.body().getData().toString());
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {

            }
        });
    }
}
