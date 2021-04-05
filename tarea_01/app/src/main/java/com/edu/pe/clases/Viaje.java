package com.edu.pe.clases;

import java.io.Serializable;

public class Viaje implements Serializable {
    private String tipo;
    private int cantDias;
    private int cantPersonas;

    public double CostoXDia(){
        double costo = 0.0;

        switch (tipo.toLowerCase()){
            case "arequipa": costo = 130 ; break;
            case "cuzco": costo = 150 ; break;
            case "tumbes": costo = 100 ; break;
            case "cajamarca": costo = 110 ; break;
        }

        return costo;
    }

    public double CostoTotal(){
        return CostoXDia() * getCantDias();
    }

    public double Descuento(){
        if(getCantPersonas() > 4){
            return 0.15 * CostoTotal();
        }
        return 0;
    }

    public double TotalPagar(){
        return CostoTotal() - Descuento();
    }

    @Override
    public String toString(){
        String cadena = "";
        cadena+="Tipo Viaje : "+getTipo()+"\n";
        cadena+="# personas : "+getCantPersonas()+"\n";
        cadena+="# dias : "+getCantDias()+"\n";
        cadena+="Costo x dia : "+CostoXDia()+"\n";
        cadena+="Costo Total : "+CostoTotal()+"\n";
        cadena+="Descuento : "+Descuento()+"\n";
        cadena+="Total a pagar : "+TotalPagar()+"\n";
        return cadena;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantDias() {
        return cantDias;
    }

    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }
}
