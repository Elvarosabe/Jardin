package com.example.soulbro.jardin;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by SoulBro on 26/03/2017.
 */

public class ComponentesAdapter extends RecyclerView.Adapter<ComponentesAdapter.ComponentesViewHolder> {
    private List<Componentes> items;

    public static class ComponentesViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView nombre;


        public ComponentesViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.nombre);
        }
    }

    public ComponentesAdapter(List<Componentes> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ComponentesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.compo_card, viewGroup, false);
        return new ComponentesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ComponentesViewHolder viewHolder, int i) {
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.nombre.setText(items.get(i).getNombre());

    }
}
