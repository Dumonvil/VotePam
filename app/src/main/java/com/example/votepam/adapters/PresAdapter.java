package com.example.votepam.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.votepam.DetailPresActivity;
import com.example.votepam.Models.PresModel;
import com.example.votepam.R;
import com.parse.ParseFile;

import org.parceler.Parcels;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PresAdapter extends RecyclerView.Adapter<PresAdapter.ViewHolder> {
    Context context;
    List<PresModel> listpres;

    public PresAdapter(Context context, List<PresModel> listpresident) {
        this.context = context;
        this.listpres = listpresident;
    }

    @NonNull
    @Override
    public PresAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itempres,parent,false);
        return new PresAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PresModel presModel = listpres.get(position);
        holder.bind(presModel);
    }


    @Override
    public int getItemCount() {
        return listpres.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView Name,Firstname;
        CircleImageView img;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.name);
            Firstname = itemView.findViewById(R.id.firstname);
            img = itemView.findViewById(R.id.profile_image);
            cardView = itemView.findViewById(R.id.card);
        }

        public void bind(final PresModel presModel) {
            Name.setText(presModel.getName());
            Firstname.setText(presModel.getFirstname());
            ParseFile image = presModel.getImage();
            if(image != null){
                Glide.with(context).load(image.getUrl()).into(img);
            }
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DetailPresActivity.class);
                    intent.putExtra("data",presModel.getObjectId());
                    context.startActivity(intent);
                }
            });
        }
    }
}
