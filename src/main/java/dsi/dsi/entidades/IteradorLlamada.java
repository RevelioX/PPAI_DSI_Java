package dsi.dsi.entidades;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class IteradorLlamada implements Iterator<Llamada> {

    private List<Llamada> llamadas;
    private int indiceActual = 0;
    private Date fechaInicio;
    private Date fechaFin;

    public IteradorLlamada(List<Llamada> llamadas, Date fechaInicio, Date fechaFin) {
        this.llamadas = llamadas;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public void primero() {
        indiceActual = 0;
    }


    public boolean haTerminado() {
        return !hasNext();
    }

    public Llamada getActual() {
        return llamadas.get(indiceActual);
    }



    @Override
    public boolean hasNext() {
        if(indiceActual == llamadas.size()){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Llamada next() {
        indiceActual = indiceActual + 1;
        return null;
    }

}
