package com.example.aditya.daggerretrofitokhttp_tutorial.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.aditya.daggerretrofitokhttp_tutorial.App;
import com.example.aditya.daggerretrofitokhttp_tutorial.Post;
import com.example.aditya.daggerretrofitokhttp_tutorial.R;
import com.example.aditya.daggerretrofitokhttp_tutorial.Restapi;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Inject
    Retrofit retrofit;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App) getApplication()).getNetComponent().inject(this);

        //Create textview and findViewByID
        textView = (TextView) findViewById(R.id.textview_post);
        //Create a retrofit call object
        Call<List<Post>> posts = retrofit.create(Restapi.class).getPosts();

        //Enque the call
        posts.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
               //Set the response to the textview
                textView.setText(response.body().get(0).getBody());

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                //Set the error to the textview
                textView.setText(t.toString());
            }
        });


    }


}
