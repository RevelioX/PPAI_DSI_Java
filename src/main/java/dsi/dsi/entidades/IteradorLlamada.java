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
        if (indiceActual >= 0 && indiceActual < llamadas.size()) {
            return llamadas.get(indiceActual);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        while (indiceActual < llamadas.size()) {
            if (!llamadas.get(indiceActual).verificarPeriodo(fechaInicio, fechaFin) || !llamadas.get(indiceActual).verificarExistenciaDeRespuestas()) {
                llamadas.remove(indiceActual);
            } else {
                indiceActual++;
            }
        }
        return indiceActual < llamadas.size();
    }

    public Llamada next() {
        if (!haTerminado()) {
            indiceActual++;
        }
        return null;
    }

}
