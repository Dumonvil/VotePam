package com.example.votepam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.votepam.Models.DepModel;
import com.example.votepam.Models.PresModel;
import com.example.votepam.adapters.DepAdapter;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class ShowDepActivity extends AppCompatActivity {
    private final String TAG = "ShowDepActivity";
    Toolbar toolbar;
    TextView tfirstname,tname;
    ImageView ivuser1,ivBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_dep);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ivuser1 = findViewById(R.id.ivuser);
        ivBack = findViewById(R.id.ivback);
        tname = findViewById(R.id.name);
        tfirstname = findViewById(R.id.firstname);


        ParseUser user = ParseUser.getCurrentUser();

        ParseFile img = user.getParseFile("profileImage");
        try {
            Bitmap bitmap = BitmapFactory.decodeStream(img.getDataStream());
            ivuser1.setImageBitmap(bitmap);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        tfirstname.setText(user.getString("firstname"));
        tname.setText(user.getString("name"));

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowDepActivity.this,CategoryActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }


}
