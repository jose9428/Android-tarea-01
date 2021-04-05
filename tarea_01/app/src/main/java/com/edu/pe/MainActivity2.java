package com.edu.pe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.pe.clases.Departamento;
import com.edu.pe.mainResultado.ResultadoActivity2;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener , View.OnClickListener {
    Spinner spDepart;
    TextView txtAnios , txtCliente;
    Button botonAceptar;
    Button botonNuevo;
    ImageView imagen;

    String items[] = {"70 Mtrs" , "90 Mtrs" , "110 Mtrs"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        botonAceptar = (Button)findViewById(R.id.btnAceptar);
        botonNuevo = (Button)findViewById(R.id.btnNuevo);
        txtAnios = (TextView)findViewById(R.id.txtAnios);
        txtCliente = (TextView)findViewById(R.id.txtCliente);
        spDepart = (Spinner)findViewById(R.id.spTipo);
        imagen = (ImageView)findViewById(R.id.lbImagenDep);

        ArrayAdapter<String> adapta = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        //ArrayAdapter adapta = ArrayAdapter.createFromResource(this ,R.array.departamentos,android.R.layout.simple_list_item_1);
        spDepart.setAdapter(adapta);
        spDepart.setOnItemSelectedListener(this);
        botonAceptar.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String nom[] = {"depa1" , "depa2"  , "depa3"};
       // int direccion = getResources().getIdentifier("drawable/"+nom[i] ,null , getPackageName());
        int id = getResources().getIdentifier(nom[i], "drawable", getPackageName());
        imagen.setImageResource(id);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        if(botonAceptar == view){
            Calcular();
        }else if(botonNuevo == view){
            Limpiar();
        }
    }

    public void Calcular(){
        Departamento obj = new Departamento();
        obj.setAnios(Integer.parseInt(txtAnios.getText().toString().trim()));
        obj.setCliente(txtCliente.getText().toString().trim());
        obj.setNomTipo(spDepart.getSelectedItem().toString());
        obj.setTipo(spDepart.getSelectedItemPosition());

        Intent enviar = new Intent(this , ResultadoActivity2.class);
        enviar.putExtra("dato" , obj);
        startActivity(enviar);
    }

    public void Limpiar(){
        txtCliente.setText("");
        txtAnios.setText("");
    }
}