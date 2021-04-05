package com.edu.pe.mainResultado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.edu.pe.MainActivity2;
import com.edu.pe.R;
import com.edu.pe.clases.Departamento;

public class ResultadoActivity2 extends AppCompatActivity {

    Departamento obj = null;
    TextView txtResul;
    Button botonRetornar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado2);

        txtResul = (TextView)findViewById(R.id.txtRes);
        botonRetornar = (Button)findViewById(R.id.BtnRetornar);

        obj = (Departamento) getIntent().getSerializableExtra("dato");

        txtResul.setText(obj.toString());

        botonRetornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retornar = new Intent(getApplicationContext() , MainActivity2.class);
                startActivity(retornar);
            }
        });
    }
}