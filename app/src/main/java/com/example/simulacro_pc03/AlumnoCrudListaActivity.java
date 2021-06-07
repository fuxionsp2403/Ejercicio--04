package com.example.simulacro_pc03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.simulacro_pc03.adapter.AlumnoAdapter;
import com.example.simulacro_pc03.api.ServiceAlumnoApi;
import com.example.simulacro_pc03.entity.Alumno;
import com.example.simulacro_pc03.util.ConnectionRest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlumnoCrudListaActivity extends AppCompatActivity {

    List<Alumno> lstData = new ArrayList<Alumno>();
    AlumnoAdapter adapter = null;
    ListView lstView = null;
    ServiceAlumnoApi api = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_crud_lista);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity_menu, menu);

        lstView = findViewById(R.id.idCrudAlumnoList);
        adapter = new AlumnoAdapter(this, R.layout.activity_alumno_crud_item, lstData);
        lstView.setAdapter(adapter);

        api = ConnectionRest.getConnection().create(ServiceAlumnoApi.class);
        lista();

        return true;
    }

    private void lista() {
        mensaje("Logueo -> " + "en método lista 1");
        Call<List<Alumno>> call = api.listarAlumno();
        call.enqueue(new Callback<List<Alumno>>() {
            @Override
            public void onResponse(Call<List<Alumno>> call, Response<List<Alumno>> response) {
                mensaje("Logueo -> " + "en método lista 2");
                if (response.isSuccessful()) {
                    mensaje("Logueo -> " + "en método lista 3");
                    List<Alumno> lista =  response.body();
                    mensaje("Logueo -> size: " + lista.size());
                    lstData.clear();
                    lstData.addAll(lista);
                    adapter.notifyDataSetChanged();
                } else {
                    mensaje("Error ->" + "Error en la respuesta");
                }
            }

            @Override
            public void onFailure(Call<List<Alumno>> call, Throwable t) {

            }


        });
    }

    private void mensaje(String s) {
        Toast menstoast = Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG);
        menstoast.show();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id = item.getItemId();


        if (id == R.id.idMenuCrudAlumno){
            Intent intent = new Intent(this, AlumnoCrudListaActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}