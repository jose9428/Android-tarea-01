package com.edu.pe.clases;

import java.util.Random;

public class JuegoAhorcado {
    int adivinar;
    int intento;
    int numero;
    boolean gano;

    public JuegoAhorcado(){
        this.adivinar = GenerarNumero();
        this.intento = 0;
        this.gano = false;
    }

    public int GenerarNumero(){
        Random rand = new Random();
        return rand.nextInt(61) ;
    }

    public String NombreImagen(){
        String imagen[] = {"sin_imagen" , "c1" , "c2" , "c3" , "c4" , "c5" , "c6"};
        return imagen[intento];
    }

    public String MensajeAdivina(){
        intento++;
        if(getNumero() > getAdivinar()){
            return "INGRESE UN NUMERO MENOR A "+getNumero();
        }else if(getNumero() < getAdivinar()){
            return "INGRESE UN MAYOR A "+getNumero();
        }else{
            this.gano = true;
            return "GANASTES EN EL INTENTO : "+getIntento()+"\nEL NUMERO FUE :"+getNumero();
        }
    }

    public int getIntento() {
        return intento;
    }

    public void setIntento(int intento) {
        this.intento = intento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAdivinar() {
        return adivinar;
    }

    public void setAdivinar(int adivinar) {
        this.adivinar = adivinar;
    }

    public boolean isGano() {
        return gano;
    }

    public void setGano(boolean gano) {
        this.gano = gano;
    }
}
