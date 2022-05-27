package com.example.camaras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void activity_main(View view) {
        setContentView(R.layout.activity_main);
    }
    public void kit4(View view){ setContentView(R.layout.kit4); }
    public void regresar(View view) {
        setContentView(R.layout.activity_home);
    }
    public void kit8(View view){ setContentView(R.layout.kit8); }
    public void menu(View view) {
        setContentView(R.layout.activity_home);
    }
    public void kit16(View view){ setContentView(R.layout.kit16); }
    public void menu1(View view) {
        setContentView(R.layout.activity_home);
    }
    public void accesorios(View view){ setContentView(R.layout.accerorios); }
    public void menu2(View view) {
        setContentView(R.layout.activity_home);
    }
    public void activity_cotizacion(View view) {
        setContentView(R.layout.activity_cotizacion);
    }
    public void Salir(View view){
        finish();
    }
}