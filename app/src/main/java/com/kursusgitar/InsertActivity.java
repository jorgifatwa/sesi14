package com.kursusgitar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kursusgitar.Model.CRUDMessage;
import com.kursusgitar.REST.RetrofitClient;
import com.kursusgitar.REST.RetrofitInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertActivity extends AppCompatActivity {

    Integer flagCode;
    Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        btnSimpan = findViewById(R.id.btn_SimpanData);

        Bundle data = getIntent().getExtras();
        if (data != null) {
            flagCode = data.getInt("flag");
            if (flagCode == 1) {
                btnSimpan.setText("Edit");
            }
        } else {
            flagCode = 0;
            btnSimpan.setText("Simpan");
        }
    }

    public void simpanGitaris(View view) {

        EditText inputID = findViewById(R.id.inpIdGitaris);
        EditText inputGitaris = findViewById(R.id.inpNamaGitaris);
        EditText inputAlamat= findViewById(R.id.inpAlamatGitaris);
        EditText inputUmur = findViewById(R.id.inpUmur);
        EditText inputTingkat= findViewById(R.id.inpTingkat);

        String idGitaris = inputID.getText().toString();
        String namaGitaris = inputGitaris.getText().toString();
        String alamatGitaris = inputAlamat.getText().toString();
        String Umur = inputUmur.getText().toString();
        String Tingkat = inputTingkat.getText().toString();


        RetrofitInterface retrofitInterface = RetrofitClient.getClient().create(RetrofitInterface.class);

        if(flagCode == 0){
            Call<CRUDMessage> insertGitaris = retrofitInterface.insertGitaris(namaGitaris,alamatGitaris,Umur,Tingkat);
            insertGitaris.enqueue(new Callback<CRUDMessage>() {
                @Override
                public void onResponse(Call<CRUDMessage> call, Response<CRUDMessage> response) {
                    Toast.makeText(InsertActivity.this,
                            "Insert Gitaris" + response.body().getMessage(),
                            Toast.LENGTH_SHORT).show();
                    finish();
                }

                @Override
                public void onFailure(Call<CRUDMessage> call,Throwable t) {
                    Log.d("Failure", t.getMessage());

                }


            });
        } else {
            Call<CRUDMessage> editGitaris = retrofitInterface.editGitaris(idGitaris,namaGitaris,alamatGitaris,Umur,Tingkat);
            editGitaris.enqueue(new Callback<CRUDMessage>() {
                @Override
                public void onResponse(Call<CRUDMessage> call, Response<CRUDMessage> response) {
                    Toast.makeText(InsertActivity.this,
                            "Update Gitaris" + response.body().getMessage(),
                            Toast.LENGTH_SHORT).show();
                    finish();
                }

                @Override
                public void onFailure(Call<CRUDMessage> call,Throwable t) {
                    Log.d("Failure", t.getMessage());

                }


            });
        }


    }
}
