package com.example.votepam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.votepam.Models.SenModel;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailSenActivity extends AppCompatActivity {
    ImageView ivBack;
    CircleImageView imguser;
    TextView tFirstname,tName,tNumber,tBan;
    SenModel senModel;
    Button BtnVote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sen);
        ivBack = findViewById(R.id.ivback);
        imguser = findViewById(R.id.ivuser);
        tFirstname = findViewById(R.id.firstname);
        tBan = findViewById(R.id.tbaniere);
        tName = findViewById(R.id.name);
        tNumber = findViewById(R.id.tnumber);
        BtnVote = findViewById(R.id.btn_vote);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailSenActivity.this,ShowSenActivity.class);
                startActivity(intent);
                finish();
            }
        });
        initBind();

    }

    private void initBind() {
        ParseQuery<SenModel> parseQuery = new ParseQuery<SenModel>(SenModel.class);
        parseQuery.whereEqualTo("objectId",getIntent().getStringExtra("data"));
        parseQuery.findInBackground(new FindCallback<SenModel>() {
            @Override
            public void done(List<SenModel> objects, ParseException e) {
                if(e!=null){
                    Log.d("Exception",e.getMessage());
                    e.printStackTrace();
                    return;
                }
                senModel = objects.get(0);
                tFirstname.setText(senModel.getFirstname());
                tName.setText(senModel.getName());
                tNumber.setText(senModel.getCandidateNumber());
                tBan.setText(senModel.getPart());
                ParseFile image = senModel.getImage();
                if(image != null){
                    Glide.with(DetailSenActivity.this).load(image.getUrl()).into(imguser);
                }
            }
        });

    }
}

