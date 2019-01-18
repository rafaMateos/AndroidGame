package com.example.rafa.deardeath2characters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private Context mContext;
    private static List<Personaje> mData;
    private static IRecyclerCliks iRecyclerCliks;

    public RecyclerViewAdapter(Context mContext, List<Personaje> mData) {

        
        this.mContext = mContext;
        this.mData = mData;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.tv_Nombre.setText(mData.get(i).get_nombre());
        myViewHolder.image.setImageResource(mData.get(i).getImage());

    }

    @Override
    public int getItemCount() {

        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tv_Nombre;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            itemView.setOnClickListener(this);

            tv_Nombre = (TextView) itemView.findViewById(R.id.NombrePer);
            image = (ImageView) itemView.findViewById(R.id.idImagen);

        }


        @Override
        public void onClick(View v) {

            Intent intent = new Intent(v.getContext(), Main2Activity.class);
            intent.putExtra("Personaje",mData.get(getAdapterPosition()));
            startActivity(v.getContext(),intent,null);

        }


    }

}
