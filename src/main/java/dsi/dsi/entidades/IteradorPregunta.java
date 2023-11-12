package dsi.dsi.entidades;

import java.util.Iterator;
import java.util.List;

public class IteradorPregunta implements Iterator {

    private List<Pregunta> preguntas;
    private int actual;
    @Override
    public boolean hasNext() {
        if(actual == preguntas.size()){
            return false;
        }else{
            return true;
        }
    }

    public IteradorPregunta(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    @Override
    public Object next() {

        actual = actual + 1;
        return null;
    }

    public Pregunta getActual(){
        return preguntas.get(actual);
    }

    public void primero(){
        actual = 0;
    }
}
