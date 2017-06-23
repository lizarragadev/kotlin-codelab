package com.miramicodigo.pokekotlin.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.miramicodigo.pokekotlin.R;
import com.miramicodigo.pokekotlin.model.Pokemon;

import java.util.ArrayList;

/**
 * Created by gusn8 on 23-06-17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private ArrayList<Pokemon> list;
    private Context context;

    public MyAdapter(Context context, ArrayList<Pokemon> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_pokemon, viewGroup, false);
        ViewHolder vholder = new ViewHolder(v);
        return vholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Pokemon pokemon= list.get(i);
        viewHolder.tvName.setText(pokemon.getName().toString());
        viewHolder.tvCP.setText(pokemon.getCp()+"");
        viewHolder.ivPhoto.setImageResource(pokemon.getPhoto());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvName;
        private TextView tvCP;
        private ImageView ivPhoto;
        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view  = itemView;
            tvName = (TextView) itemView.findViewById(R.id.tvItemName);
            tvCP = (TextView) itemView.findViewById(R.id.tvItemCPValue);
            ivPhoto = (ImageView) itemView.findViewById(R.id.ivItemPhoto);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int posicion = getAdapterPosition();
                    Toast.makeText(v.getContext(), "Mensaje", Toast.LENGTH_SHORT).show();
                    //Intent intent = new Intent(context, DetalleActivity.class);
                    //intent.putExtra("poke", items.get(posicion));
                    //context.startActivity(intent);
                }
            });
        }
    }
}
