package com.edu.pe.mainResultado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.pe.MainActivity;
import com.edu.pe.R;
import com.edu.pe.clases.Viaje;

public class ResultadoActivity extends AppCompatActivity{

    Button botonRetornar;
    ImageView imagen;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        botonRetornar = (Button)findViewById(R.id.BtnRetornar);
        imagen = (ImageView)findViewById(R.id.lbImagen);
        txtResult = (TextView)findViewById(R.id.txtRes);

        botonRetornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retorno = new Intent(getApplicationContext() , MainActivity.class);
                startActivity(retorno);
            }
        });

        // Recuperar la clase Viaje
        Viaje obj = (Viaje)getIntent().getSerializableExtra("dato");
        txtResult.setText(obj.toString());
        MostrarImagen(obj);
    }

    public void MostrarImagen(Viaje obj){
        int direccion = getResources().getIdentifier("drawable/"+obj.getTipo().toLowerCase() ,
                null , getPackageName());
        imagen.setImageResource(direccion);
    }
}