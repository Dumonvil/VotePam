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
import com.example.votepam.Models.PresModel;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;

import org.parceler.Parcels;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailPresActivity extends AppCompatActivity {
    ImageView ivBack;
    CircleImageView imguser;
    TextView tFirstname,tName,tNumber,tBan;
    PresModel presModel;
    Button BtnVote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pres);
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
                Intent intent = new Intent(DetailPresActivity.this,ShowPresActivity.class);
                startActivity(intent);
                finish();
            }
        });
        initBind();

    }

    private void initBind() {
        ParseQuery<PresModel> parseQuery = new ParseQuery<PresModel>(PresModel.class);
        parseQuery.whereEqualTo("objectId",getIntent().getStringExtra("data"));
        parseQuery.findInBackground(new FindCallback<PresModel>() {
            @Override
            public void done(List<PresModel> objects, ParseException e) {
                if(e!=null){
                    Log.d("Exception",e.getMessage());
                    e.printStackTrace();
                    return;
                }
                presModel = objects.get(0);
                tFirstname.setText(presModel.getFirstname());
                tName.setText(presModel.getName());
                tNumber.setText(presModel.getCandidateNumber());
                tBan.setText(presModel.getPart());
                ParseFile image = presModel.getImage();
                if(image != null){
                    Glide.with(DetailPresActivity.this).load(image.getUrl()).into(imguser);
                }
            }
        });
    }
}
