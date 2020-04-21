package com.example.eksplorebogor.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eksplorebogor.R;
import com.example.eksplorebogor.model.wisAlam;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListWisAlamAdapter extends RecyclerView.Adapter<ListWisAlamAdapter.CardViewViewHolder> {
    private final ArrayList<wisAlam> listAlam;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListWisAlamAdapter(ArrayList<wisAlam> listAlam) {
        this.listAlam = listAlam;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_wisata_alam, parent, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {
        wisAlam wisAlam = listAlam.get(position);

        Glide.with(holder.itemView.getContext())
                .load(wisAlam.getPhoto())
                .apply(new RequestOptions().override(200, 200))
                .into(holder.imgPhoto);

        holder.tvName.setText(wisAlam.getName());
        holder.tvDesc.setText(wisAlam.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listAlam.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listAlam.size();
    }


    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgPhoto;
        private final TextView tvName;
        private final TextView tvDesc;

        CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.item_name);
            tvDesc = itemView.findViewById(R.id.item_desc);
        }
    }
    public interface OnItemClickCallback {
        void onItemClicked(wisAlam data);
    }
}
