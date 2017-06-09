package com.example.hernandez.avanceproyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class secundario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundario);

        Button notificar  = (Button)findViewById(R.id.notif);
        //nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        notificar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });


        ImageButton consultar = (ImageButton) findViewById(R.id.consultar);
        consultar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent consult = new Intent(secundario.this,com.example.hernandez.avanceproyecto.consultas.class);
                startActivity(consult);

            }
        });


        ImageButton apartar = (ImageButton) findViewById(R.id.apartar);
        apartar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent apart = new Intent(secundario.this, com.example.hernandez.avanceproyecto.apartados.class);
                startActivity(apart);

            }
        });

        ImageButton notificacion = (ImageButton) findViewById(R.id.notificacion);
        notificacion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent notific = new Intent(secundario.this, com.example.hernandez.avanceproyecto.notificaciones.class);
                startActivity(notific );



            }
        });


    }

}

