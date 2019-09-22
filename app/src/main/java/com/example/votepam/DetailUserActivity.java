package com.example.votepam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseUser;

public class DetailUserActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button btnVote;
    TextView tfirstname,tname,tdate,tlieu,tname1,tfirstname1;
    ImageView ivuser1, imageView,ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnVote = findViewById(R.id.btn_vote);
        ivuser1 = findViewById(R.id.ivuser);
        ivBack = findViewById(R.id.ivback);
        imageView = findViewById(R.id.imageview);
        tname = findViewById(R.id.name);
        tfirstname = findViewById(R.id.firstname);
        tdate = findViewById(R.id.tdate1);
        tlieu = findViewById(R.id.tlieu1);
        tname1 = findViewById(R.id.tnom1);
        tfirstname1 = findViewById(R.id.tprenom1);

        ParseUser user = ParseUser.getCurrentUser();

        ParseFile img = user.getParseFile("profileImage");
        try {
            Bitmap bitmap = BitmapFactory.decodeStream(img.getDataStream());
            ivuser1.setImageBitmap(bitmap);
            imageView.setImageBitmap(bitmap);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        tfirstname1.setText(user.getString("firstname"));
        tname1.setText(user.getString("name"));
        tfirstname.setText(user.getString("firstname"));
        tname.setText(user.getString("name"));
        tlieu.setText(user.getString("birthplace"));
        tdate.setText(user.getString("birthdate"));

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
