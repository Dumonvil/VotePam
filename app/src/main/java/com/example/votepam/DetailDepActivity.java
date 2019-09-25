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
import com.example.votepam.Models.DepModel;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailDepActivity extends AppCompatActivity {
    ImageView ivBack;
    CircleImageView imguser;
    TextView tFirstname,tName,tNumber,tBan;
    DepModel depModel;
    Button BtnVote;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_dep);
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
                Intent intent = new Intent(DetailDepActivity.this,ShowDepActivity.class);
                startActivity(intent);
                finish();
            }
        });
        initBind();

    }

    private void initBind() {
        ParseQuery<DepModel> parseQuery = new ParseQuery<DepModel>(DepModel.class);
        parseQuery.whereEqualTo("objectId",getIntent().getStringExtra("data"));
        parseQuery.findInBackground(new FindCallback<DepModel>() {
            @Override
            public void done(List<DepModel> objects, ParseException e) {
                if(e!=null){
                    Log.d("Exception",e.getMessage());
                    e.printStackTrace();
                    return;
                }
                depModel = objects.get(0);
                tFirstname.setText(depModel.getFirstname());
                tName.setText(depModel.getName());
                tNumber.setText(depModel.getCandidateNumber());
                tBan.setText(depModel.getPart());
                ParseFile image = depModel.getImage();
                if(image != null){
                    Glide.with(DetailDepActivity.this).load(image.getUrl()).into(imguser);
                }
            }
        });
    }
}
