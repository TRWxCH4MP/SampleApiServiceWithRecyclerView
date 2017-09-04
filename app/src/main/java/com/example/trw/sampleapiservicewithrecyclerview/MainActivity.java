package com.example.trw.sampleapiservicewithrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trw.sampleapiservicewithrecyclerview.adapter.MainAdapter;
import com.example.trw.sampleapiservicewithrecyclerview.http.HttpManager;
import com.example.trw.sampleapiservicewithrecyclerview.item.BaseItem;
import com.example.trw.sampleapiservicewithrecyclerview.item.Item;
import com.example.trw.sampleapiservicewithrecyclerview.repo.Collection;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView tv_title;
    private ImageView imageView;
    private ProgressBar progressBar;

    private RecyclerView recyclerView;
    private MainAdapter adapter;

    private static String API_KEY = "AIzaSyBDJ-humCFVkDiwM3c0nl2w0rjZV7J3Q7M";
    private static String URL = "http://www.akexorcist.com";
    private static String BLOG_ID = "2112378201659339351";
    private static String POST_ID = "2873721426328362980";

    ArrayList<String> titleList;
    ArrayList<String> imageList;

    Collection collection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstances();

        if (savedInstanceState == null) {
            callServer();
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: " + new Gson().toJson(collection));
        outState.putParcelable("collection", collection);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        collection = savedInstanceState.getParcelable("collection");
        Log.d(TAG, "onRestoreInstanceState: " + new Gson().toJson(collection));
        progressBar.setVisibility(View.GONE);
        setAdapterItem(collection);
    }

    private void callServer() {
        Call<Collection> call = HttpManager.getInstance().getService().Repo(BLOG_ID, API_KEY, 10, true);
        call.enqueue(new Callback<Collection>() {
            @Override
            public void onResponse(Call<Collection> call, Response<Collection> response) {
                if (response.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);
                    collection = response.body();

                    setAdapterItem(collection);

                } else {
                    Toast.makeText(MainActivity.this
                            , response.errorBody().toString()
                            , Toast.LENGTH_SHORT)
                            .show();
                }
            }

            @Override
            public void onFailure(Call<Collection> call, Throwable t) {
                Toast.makeText(MainActivity.this
                        , t.toString()
                        , Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    private void setAdapterItem(Collection collection) {
        adapter = new MainAdapter();
        adapter.setItemList(CreateItem.createItem(collection));
        recyclerView.setAdapter(adapter);
    }

    private void initInstances() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        tv_title = (TextView) findViewById(R.id.tv_title);
        imageView = (ImageView) findViewById(R.id.imageView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

}
