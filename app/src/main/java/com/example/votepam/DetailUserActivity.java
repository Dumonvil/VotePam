package com.example.votepam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.votepam.Models.UserModel;
import com.parse.ParseUser;

public class DetailUserActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button btnVote;
    TextView tfirstname,tname,tdate,tlieu,tiduser,tname1,tfirstname1;
    ImageView ivuser1, imageView,ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);
        toolbar = findViewById(R.id.toolbar);
        btnVote = findViewById(R.id.btn_vote);
        ivuser1 = findViewById(R.id.ivuser);
        ivBack = findViewById(R.id.ivback);
        imageView = findViewById(R.id.imageview);
        tname = findViewById(R.id.tnom1);
        tfirstname = findViewById(R.id.tprenom1);
        tdate = findViewById(R.id.tdate1);
        tlieu = findViewById(R.id.tlieu1);
        tiduser = findViewById(R.id.iduser);
        tname1 = findViewById(R.id.name);
        tfirstname1 = findViewById(R.id.firstname);


        btnVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailUserActivity.this,CategoryActivity.class);
                startActivity(intent);

            }
        });

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
       



    }
}
