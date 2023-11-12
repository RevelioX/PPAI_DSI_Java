package dsi.dsi.entidades;

import java.util.Iterator;
import java.util.List;

public class IteradorEncuesta implements Iterator {

    List<Encuesta> encuestas;
    int actual;

    public IteradorEncuesta(List<Encuesta> encuestas) {
        this.encuestas = encuestas;
    }

    @Override
    public boolean hasNext() {
        if(actual == encuestas.size()){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Object next() {
        actual = actual + 1;
        return null;
    }

    public Encuesta getActual(){
        return encuestas.get(actual);
    }

    public void primero(){
        actual = 0;
    }

    public void cortarIteracion(){
        actual = encuestas.size() - 1;
    }
}
