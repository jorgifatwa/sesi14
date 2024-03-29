package com.kursusgitar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.kursusgitar.Model.Parsing.getLogin;

import com.kursusgitar.REST.RetrofitClient;
import com.kursusgitar.REST.RetrofitInterface;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RetrofitInterface rfInterface;
    LinearLayout layoutProgress;
    EditText edUser, edPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        layoutProgress = findViewById(R.id.layoutProgress);
        rfInterface = RetrofitClient.getClient().create(RetrofitInterface.class);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginProcess();
            }
        });
    }
    private boolean validateInputs() {
        edUser = findViewById(R.id.edUser);
        edPass = findViewById(R .id.edPass);


        if (edUser.getText().toString().length() <= 0
                || edPass.getText().toString().length() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    private void loginProcess(){
        if(validateInputs()) {
            Map<String,String> parameter = new HashMap<>();
            parameter.put("username",edUser.getText().toString());
            parameter.put("password",edPass.getText().toString());


            layoutProgress.setVisibility(View.VISIBLE);

            Call<getLogin> getLoginCall = rfInterface.getLogin(parameter);
            getLoginCall.enqueue(new Callback<getLogin>() {
                @Override
                public void onResponse(Call<getLogin> call, Response<getLogin> response) {
                    if (response.code() == 200){
                        String nama =response.body().getLogin().getNamaUser();
                        Toast.makeText(MainActivity.this, "Welcome " + nama, Toast.LENGTH_LONG).show();
                        keMainMenu();
                    } else if (response.code() == 400) {
                        Toast.makeText(MainActivity.this, "User Not Found", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Address Not Found", Toast.LENGTH_SHORT).show();
                    }
                    layoutProgress.setVisibility(View.GONE);
                }

                @Override
                public void onFailure(Call<getLogin> call, Throwable t) {
                    Log.d("failure", t.getMessage());
                    layoutProgress.setVisibility(View.GONE);
                }
            });
        } else {
            Toast.makeText(this, "Input are Incorrect", Toast.LENGTH_LONG).show();
        }
    }

    private void keMainMenu() {
        Intent intent = new Intent(MainActivity.this, MainMenuActivity.class);
        startActivity(intent);
    }
    }

