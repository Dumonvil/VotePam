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

import com.example.votepam.Models.SenModel;
import com.example.votepam.adapters.SenatorAdapter;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class ShowSenActivity extends AppCompatActivity {
    private final String TAG = "ShowSenActivity";
    Toolbar toolbar;
    TextView tfirstname,tname;
    ImageView ivuser1,ivBack;
    List<SenModel> senModels;
    RecyclerView recyclerView;
    SenatorAdapter senatorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_sen);
        recyclerView = findViewById(R.id.rv_sen);
        senModels = new ArrayList<>();
        senatorAdapter = new SenatorAdapter(this,senModels);
        recyclerView.setLayoutManager( new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(senatorAdapter);


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
                Intent intent = new Intent(ShowSenActivity.this,CategoryActivity.class);
                startActivity(intent);
                finish();
            }
        });

        showList();
    }

    private void showList() {
        ParseQuery<SenModel> parseQuery = new ParseQuery<SenModel>(SenModel.class);
        parseQuery.findInBackground(new FindCallback<SenModel>() {
            @Override
            public void done(List<SenModel> objects, ParseException e) {
                if (e!= null){
                    Log.e(TAG,"Error with query");
                    e.printStackTrace();
                    return;
                }
                senModels.addAll(objects);
                senatorAdapter.notifyDataSetChanged();
                for (int i = 0; i < objects.size(); i++){
                    SenModel senModel = objects.get(i);
                    Log.d(TAG,"Post: " + senModel.getFirstname() + "username: " +senModel.getName());
                }
            }
        });
    }
}
