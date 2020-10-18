package com.example.boomerangbags;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BagAdapter extends RecyclerView.Adapter<BagAdapter.BagViewHolder> {

    String s1[], s2[];
    int images[];
    Context context;

    public BagAdapter(Context cont, String strA[], String strB[], int pictures[]) {
        context = cont;
        s1 = strA;
        s2 = strB;
        images = pictures;
    }

    @NonNull
    @Override
    public BagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create LayoutInflater object inflat recycler_row and parent
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recycler_row, parent, false);
        return new BagViewHolder(view );
    }

    @Override
    public void onBindViewHolder(@NonNull BagViewHolder holder, int position) {

        holder.bagIdTv.setText(s1[position]);
        holder.descriptionTv.setText(s2[position]);
        holder.bagImange.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class BagViewHolder extends RecyclerView.ViewHolder {

        TextView bagIdTv, descriptionTv;
        ImageView bagImange;

        public BagViewHolder(@NonNull View itemView) {
            super(itemView);
            bagIdTv = itemView.findViewById(R.id.bagID_tv);
            descriptionTv = itemView.findViewById(R.id.description_tv);
            bagImange = itemView.findViewById(R.id.BagView);

        }
    }
}
