package dsi.dsi.entidades;

import java.util.Iterator;
import java.util.List;

public class IteradorEncuesta implements Iterador {

    List<Encuesta> lista;
    int actual;

    public IteradorEncuesta(List<Encuesta> encuestas) {
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

    public Encuesta getActual(){
        return lista.get(actual);
    }

    public void primero(){
        actual = 0;
    }

    public void cortarIteracion(){
        actual = lista.size();
    }
}
