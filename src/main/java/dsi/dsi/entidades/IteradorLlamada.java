package dsi.dsi.entidades;

import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class IteradorLlamada implements Iterador {

    List<Llamada> lista;
    int actual;



    public IteradorLlamada(List<Llamada> encuestas) {
        this.lista = encuestas;
    }

    public boolean haTerminado() {
        if(actual >= lista.size()){
            return false;
        }else{
            return true;
        }
    }
    @Override
    public void siguiente() {
        actual = actual + 1;
    }

    public Llamada getActual(){
        return lista.get(actual);
    }

    public void primero(){
        actual = 0;
    }

    public void cortarIteracion(){
        actual = lista.size();
    }

}

