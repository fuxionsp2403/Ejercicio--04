package com.example.simulacro_pc03.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.simulacro_pc03.R;
import com.example.simulacro_pc03.entity.Alumno;

import java.util.List;

public class AlumnoAdapter extends ArrayAdapter<Alumno> {

    private Context context;
    private List<Alumno> lista;


    public AlumnoAdapter(@NonNull Context context, int resource, @NonNull List<Alumno> lista) {
        super(context, resource,  lista);
        this.context = context;
        this.lista = lista;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.activity_alumno_crud_item, parent, false);

        Alumno obj = lista.get(position);


        TextView txtNombre = row.findViewById(R.id.idCrudAlumnoTitulo);
        txtNombre.setText(obj.getNombres());
        return row;


    }
}
