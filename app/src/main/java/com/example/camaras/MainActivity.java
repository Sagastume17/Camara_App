package com.example.camaras;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password, repassword;
    Button btnIngresar, btnregistro;
    DBHelper myDB;
   // Button llamada;
    Button mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);

        btnregistro = (Button) findViewById(R.id.btnregistro);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);

        myDB = new DBHelper(this);

        mensaje = (Button) findViewById(R.id.btn2);
        mensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  mensaje = new Intent(MainActivity.this,CotizacionActivity.class);
                startActivity(mensaje);
            }
        });

        btnregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (user.equals("") || pass.equals("") || repass.equals("")) {
                    Toast.makeText(MainActivity.this, "Llenar todos los Campos.", Toast.LENGTH_LONG).show();
                } else {
                    if (pass.equals(repass)) {
                        Boolean userCheckResult = myDB.checkusername(user);
                        if (userCheckResult == false) {
                            Boolean regResult = myDB.insertData(user, pass);
                            if (regResult == true) {
                                Toast.makeText(MainActivity.this, "Registro Sactisfactorio.", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(MainActivity.this, "Registro Fallo.", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Datos Ingresados.\n Ingrese a la APP", Toast.LENGTH_LONG).show();
                        }

                    } else {
                        Toast.makeText(MainActivity.this, "Contraseña no Coincide", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);

            }
        });

    }
}