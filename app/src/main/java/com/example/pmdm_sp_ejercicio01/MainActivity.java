package com.example.pmdm_sp_ejercicio01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    /*Desarrollar una aplicación que mediante el uso de las SharedPreference, simule el
    funcionamiento de un Login Persistente
    Con la primera actividad se almacena XXXXXXXX en las sharedPreferences y se abre la
    actividad secundaria (me es indiferente)
    Una vez hecho el login, cada vez que se se entre en la aplicación si el usuario está
    logeado, se saltará la ventana de login y directamente se abrirá la actividad 2
    La 2 segunda actividad tendrá un botón para quitar la persistencia del login
    Eliminar las sharedPreferences*/

    private EditText txtUser;
    private EditText txtPass;
    private Button btnEnter;

    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializaVariables();
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);


        String user = sp.getString(Constantes.USER, "");
        String pass = sp.getString(Constantes.PASS,"");

        if(!user.isEmpty()){
            txtUser.setText(user);
        }
        if(!pass.isEmpty()){
            txtPass.setText(pass);
        }

        if(!txtUser.getText().toString().isEmpty() && !txtPass.getText().toString().isEmpty()){
            startActivity(intent);
        }



        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = txtUser.getText().toString();
                String pass = txtPass.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString(Constantes.USER, user);
                editor.putString(Constantes.PASS,pass);
                editor.apply();

                startActivity(intent);
            }
        });
    }

    private void inicializaVariables() {

        txtUser = findViewById(R.id.txtUser);
        txtPass = findViewById(R.id.txtPass);
        btnEnter = findViewById(R.id.btnEnter);
    }
}