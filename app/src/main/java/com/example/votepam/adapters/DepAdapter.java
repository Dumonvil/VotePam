package com.example.votepam.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.votepam.Models.DepModel;
import com.example.votepam.R;
import com.parse.ParseFile;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DepAdapter extends RecyclerView.Adapter<DepAdapter.ViewHolder> {
    Context context;
    List<DepModel> listdep;

    public DepAdapter(Context context, List<DepModel> listsenator) {
        this.context = context;
        this.listdep = listsenator;
    }

    @NonNull
    @Override
    public DepAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemdep,parent,false);
        return new DepAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DepModel depModel = listdep.get(position);
        holder.bind(depModel);
    }


    @Override
    public int getItemCount() {
        return listdep.size();
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

        public void bind(DepModel depModel) {
            Name.setText(depModel.getName());
            Firstname.setText(depModel.getFirstname());
            ParseFile image = depModel.getImage();
            if(image != null){
                Glide.with(context).load(image.getUrl()).into(img);
            }
        }
    }
}
