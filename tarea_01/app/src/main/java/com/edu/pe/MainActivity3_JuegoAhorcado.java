package com.edu.pe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.pe.clases.JuegoAhorcado;
import com.edu.pe.clases.Viaje;

public class MainActivity3_JuegoAhorcado extends AppCompatActivity implements View.OnClickListener {
    Button botonIniciar , botonAceptar;
    ImageView imagen;
    TextView txtNumero , txtRes;
    boolean juego = true;
    JuegoAhorcado objJuego = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3__juego_ahorcado);

        botonAceptar = findViewById(R.id.btnAceptar);
        botonIniciar = findViewById(R.id.btnIniciar);
        imagen = findViewById(R.id.imageView);
        txtNumero = findViewById(R.id.txtNumero);
        txtRes= findViewById(R.id.txtResult);
        botonAceptar.setOnClickListener(this);
        botonIniciar.setOnClickListener(this);

        Habilitar();
        LimpiarCasillas();

        Reiniciar();
    }

    @Override
    public void onClick(View view) {
        if(view == botonIniciar){
            juego = !juego;

            objJuego = new JuegoAhorcado();
            LimpiarCasillas();

            if(juego == false){
                botonAceptar.setEnabled(false);
                txtNumero.setEnabled(false);
            }else{
                botonAceptar.setEnabled(true);
                txtNumero.setEnabled(true);
            }

        }else if(view == botonAceptar){
            Calcular();
        }
        Habilitar();
    }

    public void Calcular(){
        int numero = Integer.parseInt(txtNumero.getText().toString().trim());
        objJuego.setNumero(numero);
        String mensaje = objJuego.MensajeAdivina();
        MostrarImagen(objJuego.NombreImagen());
        txtRes.setText(mensaje);
        txtNumero.setText("");

        if(objJuego.isGano()){
            Toast.makeText(this , "Felicidades !!" , Toast.LENGTH_LONG).show();
            Reiniciar();
        }else{
            txtRes.setText(mensaje + "\nTe Quedan "+(6 - objJuego.getIntento())+" intentos");
            if(objJuego.getIntento() >= 6){
                Toast.makeText(this , "Juego terminado" , Toast.LENGTH_SHORT).show();
                txtRes.setText("PERDISTES EL JUEGO\nEL NUMERO FUE : "+objJuego.getAdivinar());
                Reiniciar();
            }
        }
    }

    public void Reiniciar(){
        juego = !juego;
        Habilitar();
        botonAceptar.setEnabled(false);
        txtNumero.setEnabled(false);
    }
    public void Habilitar(){
        if(!juego){
            botonIniciar.setText("INICIAR JUEGO");
        }else{
            botonIniciar.setText("REINICIAR JUEGO");
        }
    }

    public void MostrarImagen(String nomImagen){
        int direccion = getResources().getIdentifier("drawable/"+nomImagen,
                null , getPackageName());
        imagen.setImageResource(direccion);
    }

    public void LimpiarCasillas(){
        txtNumero.setText("");
        txtRes.setText("");
        MostrarImagen("sin_imagen");
    }
}