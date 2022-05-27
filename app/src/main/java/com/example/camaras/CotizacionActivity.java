package com.example.camaras;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CotizacionActivity extends AppCompatActivity {

    EditText etMsj;
    TextView etcel;
    Button llamada;
    Button btnEnviar, btnwhats;
    String numero = "50251810896";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotizacion);

        etMsj = findViewById(R.id.informacion);
        btnEnviar = findViewById(R.id.btnwhats);
        btnwhats = findViewById(R.id.btnwhats);
        etcel = findViewById(R.id.num);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        llamada = (Button) findViewById(R.id.button3);
        llamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:50251810896"));
                if(ActivityCompat.checkSelfPermission(CotizacionActivity.this, Manifest.permission.CALL_PHONE)!=
                        PackageManager.PERMISSION_GRANTED )
                    return;
                startActivity(i);
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