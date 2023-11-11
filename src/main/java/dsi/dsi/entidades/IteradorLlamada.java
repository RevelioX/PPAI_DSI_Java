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

    @Override
    public boolean hasNext() {
        return indiceActual < llamadas.size();
    }

    @Override
    public Llamada next() {
        if (hasNext()) {
            return llamadas.get(indiceActual++);
        }
        return null;
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

    public boolean verificarPeriodo(Date fechaInicio, Date fechaFin) {
        Llamada llamadaActual = getActual();
        if (llamadaActual != null) {
            return llamadaActual.verificarPeriodo(fechaInicio, fechaFin);
        }
        return false;
    }

    public boolean verificarExistenciaDeRespuestas() {
        Llamada llamadaActual = getActual();
        if (llamadaActual != null) {
            return llamadaActual.verificarExistenciaDeRespuestas();
        }
        return false;
    }

    public void siguiente() {
        if (!haTerminado()) {
            indiceActual++;
        }
    }

}
