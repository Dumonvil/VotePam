package com.example.votepam.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.votepam.Models.SenModel;
import com.example.votepam.R;
import com.parse.ParseFile;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SenatorAdapter extends RecyclerView.Adapter<SenatorAdapter.ViewHolder>{

    Context context;
    List<SenModel> listsenator;

    public SenatorAdapter(Context context, List<SenModel> listsenator) {
        this.context = context;
        this.listsenator = listsenator;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemsen,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SenModel senModel = listsenator.get(position);
        holder.bind(senModel);

    }

    @Override
    public int getItemCount() {
        return listsenator.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView Name,Firstname;
        CircleImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.name);
            Firstname = itemView.findViewById(R.id.firstname);
            img = itemView.findViewById(R.id.profile_image);
        }

        public void bind(SenModel senModel) {
        Name.setText(senModel.getName());
        Firstname.setText(senModel.getFirstname());
            ParseFile image = senModel.getImage();
            if(image != null){
                Glide.with(context).load(image.getUrl()).into(img);
            }
        }
    }
}
