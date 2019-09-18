package com.example.votepam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {
    TextInputLayout text1, text2;
    Button btn_connect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        text1 = findViewById(R.id.tI_id);
        text2 = findViewById(R.id.tI_name);

        btn_connect = findViewById(R.id.button);

        btn_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = text1.getEditText().getText().toString();
                String iduser = text2.getEditText().getText().toString();
                if (username.isEmpty()){
                    Snackbar.make(view,"Antre non'w",Snackbar.LENGTH_LONG).show();
                    //Toast.makeText(LoginActivity.this, "Antre non'w", Toast.LENGTH_SHORT).show();
                }else if (iduser.isEmpty()){
                    Snackbar.make(view,"Antre id ou",Snackbar.LENGTH_LONG).show();
                    //Toast.makeText(LoginActivity.this, "Antre id ou", Toast.LENGTH_SHORT).show();
                }else {
                    ConnectivityManager connectivityManager = (ConnectivityManager)
                            getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();

                    if (activeNetwork != null){
                        if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI || activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)  {
                            login(username,iduser);

                        }
                    }else{
                        Snackbar.make(view,"No Internet Connection",Snackbar.LENGTH_LONG).show();
                        //Toast.makeText(LoginActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    private void login(String username, String iduser) {
        ParseUser.logInInBackground(username, iduser, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e!= null){
                    Toast.makeText(LoginActivity.this, "non ou ou id ou pa bon", Toast.LENGTH_SHORT).show();
                }
                goActivity();
            }
        });
    }

    private void goActivity() {
        Intent i = new Intent(LoginActivity.this,DetailUserActivity.class);
        startActivity(i);
        finish();
    }

}
