package dsi.dsi.entidades;

import java.util.Iterator;
import java.util.List;

public class IteradorPregunta implements Iterador {

    List<Pregunta> lista;
    int actual;

    public IteradorPregunta(List<Pregunta> encuestas) {
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

    public Pregunta getActual(){
        return lista.get(actual);
    }

    public void primero(){
        actual = 0;
    }

    public void cortarIteracion(){
        actual = lista.size();
    }
}
