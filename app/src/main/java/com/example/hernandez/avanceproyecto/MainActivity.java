package com.example.hernandez.avanceproyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boton = (Button) findViewById(R.id.ingresar);
        boton.setOnClickListener (new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String usuario = ((EditText) findViewById(R.id.Usuario)).getText().toString();
                String password = ((EditText) findViewById(R.id.password)).getText().toString();
                if (usuario.equals("admin") && password.equals("admin")) {
                    Intent nuevoform = new Intent(MainActivity.this, secundario.class);
                    startActivity(nuevoform);

                }
                else {
                    Toast.makeText(getApplicationContext(), "Usuario incorrecto", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
