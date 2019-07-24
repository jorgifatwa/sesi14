package com.kursusgitar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.kursusgitar.Adapter.GitarisAdapter;
import com.kursusgitar.Model.Gitaris;
import com.kursusgitar.Model.Parsing.getAllGitaris;
import com.kursusgitar.REST.RetrofitClient;
import com.kursusgitar.REST.RetrofitInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        final RecyclerView recyclerView = findViewById(R.id.recyclerGitaris);
        final LinearLayout layoutProgress = findViewById(R.id.layoutProgress);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        RetrofitInterface retrofitInterface = RetrofitClient.getClient().create(RetrofitInterface.class);

        layoutProgress.setVisibility(View.VISIBLE);

        Call<getAllGitaris> getAllGitaris = retrofitInterface.getAllGitaris();
        getAllGitaris.enqueue(new Callback<getAllGitaris>() {
            @Override
            public void onResponse(Call<getAllGitaris> call, Response<getAllGitaris> response) {
                List<Gitaris> gitarList = response.body().getGitaris();
                RecyclerView.Adapter adapter = new GitarisAdapter(gitarList);
                recyclerView.setAdapter(adapter);
                layoutProgress.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<com.kursusgitar.Model.Parsing.getAllGitaris> call, Throwable t) {
                Log.d("failure", t.getMessage());
                layoutProgress.setVisibility(View.GONE);
            }
        });



    }
}
