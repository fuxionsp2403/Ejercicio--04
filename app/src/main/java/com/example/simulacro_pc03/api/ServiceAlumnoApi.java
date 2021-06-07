package com.example.simulacro_pc03.api;



import com.example.simulacro_pc03.entity.Alumno;

import java.util.List;
import java.util.Optional;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ServiceAlumnoApi {

    @GET("alumno")
    public abstract  Call<List<Alumno>> listarAlumno();

    @GET("alumno/{id}")
    public abstract  Call<Optional<Alumno>> buscarAlumno(String id);

    @POST("alumno")
    public abstract Call<Alumno> insertarAlumno(@Body Alumno obj);


    @PUT("alumno")
    public abstract Call<Alumno> actualizarAlumno(@Body Alumno obj);


    @DELETE("alumno/{id}")
    public abstract Call<Alumno> eliminarAlumno(@Path("id") String id);


}
