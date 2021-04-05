package com.edu.pe.clases;

import java.io.Serializable;

public class Departamento implements Serializable {
    String nomTipo;
    int tipo;
    String cliente;
    int anios;

    public double Costo(){
        double costo[] = {800000 , 100000 , 150000};

        return costo[tipo];
    }

    public double Interes(){
        double interes = 0.0;

        if(anios>=2 && anios<=5){
            interes = 0.1 * Costo();
        }else  if(anios>=6 && anios<=9){
            interes = 0.15 * Costo();
        }else  if(anios>=10 && anios<=15){
            interes = 0.2 * Costo();
        }else if(anios>15){
            interes = 0.28 * Costo();
        }

        return interes;
    }

    public double CuotaInicial(){
        return 0.1 * Costo();
    }

    public double Saldo() {
        return Costo() - CuotaInicial() + Interes();
    }

    public double CuotaMensual() {
        return Saldo() / (getAnios() * 12);
    }

    @Override
    public String toString(){
        String cadena = "";

        cadena+="Nombre del cliente : "+cliente+"\n";
        cadena+="Tipo de departamento : "+nomTipo+"\n";
        cadena+="Costo : "+Costo()+"\n";
        cadena+="Numero de años : "+anios+"\n";
        cadena+="Interes a pagar : "+Interes()+"\n";
        cadena+="Cuota Inicial : "+CuotaInicial()+"\n";
        cadena+="Saldo : "+Saldo()+"\n";
        cadena+="Cuota Mensual : "+CuotaMensual();

        return cadena;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getAnios() {
        return anios;
    }

    public void setAnios(int anios) {
        this.anios = anios;
    }

    public String getNomTipo() {
        return nomTipo;
    }

    public void setNomTipo(String nomTipo) {
        this.nomTipo = nomTipo;
    }
}
