package com.example.apip.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apip.Api.Service;
import com.example.apip.Model.Usuario;
import com.example.apip.R;
import com.example.apip.Util.ConnectionREST;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText _etIdUsuario;
    private EditText _etNombreUsuario;
    private EditText _etApellidoUsuario;
    private EditText _etEdadUsuario;
    private EditText _etNombreUsuarioUsuario;
    private EditText _etCorreo;
    private EditText _etPasswordUsuario;
    private EditText _etTipoUsuario;
    private EditText _etResultado;
    private Button _btnRegistrar;
    private Button _btnEliminar;
    private Button _btnModificar;
    private Service serviceAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _etIdUsuario = (EditText) findViewById(R.id.TfIdUsuario);
        _etNombreUsuario = (EditText) findViewById(R.id.TfNombre);
        _etApellidoUsuario = (EditText) findViewById(R.id.TfApellidos);
        _etEdadUsuario = (EditText) findViewById(R.id.TfEdad);
        _etNombreUsuarioUsuario = (EditText) findViewById(R.id.TfNombreUsuarioUsuario);
        _etCorreo = (EditText) findViewById(R.id.TfCorreo);
        _etPasswordUsuario = (EditText) findViewById(R.id.tfContraseña);
        _etTipoUsuario = (EditText) findViewById(R.id.TfTipoUsuario);
        _etResultado = (EditText) findViewById(R.id.editResultado);
        _btnRegistrar = (Button) findViewById(R.id.bRegistrar);
        _btnEliminar = (Button) findViewById(R.id.bEliminar);
        _btnModificar = (Button) findViewById(R.id.bModificar);
        serviceAPI = ConnectionREST.getConnection().create(Service.class);
        load();

        _btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario objUsu = new Usuario(getId(),getNombre(),getApellido(),getEdad(),getNomUsu(),getCorreo(),getContra(),getTipo()
                );
                addUsuario(objUsu);
            }
        });

        _btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarUsuario(String.valueOf(_etIdUsuario.getText()));
            }
        });

        _btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario objU = new Usuario(getId(),getNombre(),getApellido(),getEdad(),getNomUsu(),getCorreo(),getContra(),getTipo()
                );
                modifyUsuario(objU);
            }
        });

    }
    private void eliminarUsuario(String id ) {
        Call<Usuario> call = serviceAPI.removeUsuario(id);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.isSuccessful())
                {
                    mensaje("Los datos se eliminaron satisfactoriamente!!!");
                }
                else
                {
                    mensaje("Ocurrio un error desconocido!!!");
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                mensaje("Ocurrio un error!!!" + t.getMessage());
            }
        });
    }

    public void addUsuario(Usuario uObj)
    {
        Call<Usuario> call = serviceAPI.addUsuario(uObj);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.isSuccessful())
                {
                    Usuario pro = response.body();
                    mensaje("Registro grabado satisfactoriamente!");
                }
                else
                {
                    mensaje("Ocurrio un error al grabar los datos!");
                }
            }
            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                mensaje("Ocurrio un error desconocido!" + t.getMessage());
            }
        });
    }
    private void modifyUsuario(Usuario uObj) {
        Call<Usuario> call = serviceAPI.modifyUsuario(uObj);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.isSuccessful())
                {
                    Usuario pro = response.body();

                    mensaje("Los datos se modificaron satisfactoriamente!!!");
                }
                else
                {
                    mensaje("Ocurrio un error desconocido!!!");
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                mensaje("Ocurrio un error!!!" + t.getMessage());
            }
        });
    }

    public int getEdad()
    {
        return Integer.parseInt(_etEdadUsuario.getText().toString());
    }
    public String getId()
    {
        return _etIdUsuario.getText().toString();
    }
    public String getNombre()
    {
        return _etNombreUsuario.getText().toString();
    }
    public String getApellido()
    {
        return _etApellidoUsuario.getText().toString();
    }
    public String getNomUsu()
    {
        return _etNombreUsuarioUsuario.getText().toString();
    }
    public String getCorreo()
    {
        return _etCorreo.getText().toString();
    }
    public String getContra()
    {
        return _etPasswordUsuario.getText().toString();
    }
    public String getTipo()
    {
        return _etTipoUsuario.getText().toString();
    }

    private void load() {
        Call<List<Usuario>> call = serviceAPI.lstUsuarios();
        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                if(response.isSuccessful())
                {
                    List<Usuario> respuesta = response.body();
                    for (Usuario x: respuesta)
                    {
                        Toast.makeText(MainActivity.this," " +x.getIdUsuario() + "-" + x.getNombreUsuario() + "-",
                                Toast.LENGTH_SHORT).show();

                    }
                }
                else{
                        mensaje("Ocurrio un error pipipi");
                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                mensaje("Ocurrio un error:" + t.getMessage());
            }
        });
    }
    public void mensaje(String msg)
    {
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setMessage(msg);
        alerta.show();
    }
}