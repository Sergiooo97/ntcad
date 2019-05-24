package com.example.anggarisky.splashtohomeangga;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerVIewAdap1 extends RecyclerView.Adapter<RecyclerVIewAdap1.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre1, edad1, grado1, apellido1;
        ImageView imageEest;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre1=(TextView)itemView.findViewById(R.id.txtNombre1);
            edad1=(TextView)itemView.findViewById(R.id.txtEdad1);
            imageEest=(ImageView)itemView.findViewById(R.id.imgEst1);
            grado1 = (TextView) itemView.findViewById(R.id.txtGrado1);
            apellido1 = (TextView) itemView.findViewById(R.id.txtApellido1);

        }
    }
    public List<Primergrado> alumnosLIsta1;

    public RecyclerVIewAdap1(List<Primergrado> alumnosLIsta1) {
        this.alumnosLIsta1 = alumnosLIsta1;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_estudiante1, parent, false);
        RecyclerVIewAdap1.ViewHolder viewHolder = new ViewHolder((view));
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombre1.setText(alumnosLIsta1.get(position).getNombre1());
        holder.grado1.setText(alumnosLIsta1.get(position).getGrado1());
        holder.edad1.setText(alumnosLIsta1.get(position).getEdad1());
        holder.apellido1.setText(alumnosLIsta1.get(position).getApellido1());

        holder.imageEest.setImageResource(alumnosLIsta1.get(position).getImageEst());

    }

    @Override
    public int getItemCount()
    {
        return alumnosLIsta1.size();
    }
}
