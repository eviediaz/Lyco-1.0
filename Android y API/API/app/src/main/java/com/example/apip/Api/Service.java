package com.example.apip.Api;

import com.example.apip.Model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface Service {
    @GET("usuario")
    public abstract Call<List<Usuario>>lstUsuarios();
    @POST("usuario/agregar")
    public abstract Call<Usuario> addUsuario(@Body Usuario obj);
    @PUT ("usuario/modificar")
    public abstract Call<Usuario> modifyUsuario(@Body Usuario obj);
    @DELETE("usuario/eliminar/{id}")
    public abstract Call<Usuario> removeUsuario(@Path("id")String id);

}
