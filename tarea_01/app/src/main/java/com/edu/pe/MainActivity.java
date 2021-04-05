package com.edu.pe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.edu.pe.clases.Viaje;
import com.edu.pe.mainResultado.ResultadoActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioGroup grupoButton;
    TextView txtDias , txtNumPers;
    Button botonAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDias = (TextView)findViewById(R.id.txtDias);
        txtNumPers = (TextView)findViewById(R.id.txtNumPers);
        grupoButton = (RadioGroup) findViewById(R.id.rbGroup);
        botonAceptar = (Button)findViewById(R.id.btnIniciar);
        botonAceptar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(botonAceptar == view){
            ProcesarDatos();
        }
    }

    public void ProcesarDatos(){
        Viaje v = new Viaje();
        v.setCantDias(Integer.parseInt(txtDias.getText().toString().trim()));
        v.setCantPersonas(Integer.parseInt(txtNumPers.getText().toString().trim()));
        v.setTipo(ObtenerTipo());

        Intent enviar = new Intent(this , ResultadoActivity.class);
        enviar.putExtra("dato" , v);
        startActivity(enviar);
    }

    public String ObtenerTipo(){
        String tipo = "";
        switch (grupoButton.getCheckedRadioButtonId()){
            case R.id.rb1:
                tipo = "Arequipa";
                break;
            case R.id.rb2:
                tipo = "Cuzco";
                break;
            case R.id.rb3:
                tipo = "Tumbes";
                break;
            case R.id.rb4:
                tipo = "Cajamarca";
                break;
        }
        return tipo;
    }
}