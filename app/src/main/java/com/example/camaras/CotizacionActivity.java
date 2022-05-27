package com.example.camaras;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class mensaje extends AppCompatActivity {
    EditText etMsj;
    TextView etcel;
    Button btnEnviar, btnwhats;
    String numero = "50259014641";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotizacion);
        // codigo
        etMsj = findViewById(R.id.editTextTextPersonName);
        btnEnviar = findViewById(R.id.btnmsj);
        btnwhats = findViewById(R.id.btnwhats);
        etcel = findViewById(R.id.num);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        btnwhats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etcel.getText().toString().isEmpty()){
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT,etMsj.getText().toString());
                    sendIntent.setType("text/plain");
                    sendIntent.setPackage("com.whatsapp");
                    startActivity(sendIntent);

                }else{
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_VIEW);
                    String uri = "whatsapp://send?phone="+etcel.getText().toString()+"&text="+etMsj.getText().toString();
                    sendIntent.setData(Uri.parse(uri));
                    startActivity(sendIntent);}
            }
        });

    }
}