package dsi.dsi.entidades;

import java.util.Iterator;
import java.util.List;

public class IteradorLlamada implements Iterator<Llamada> {


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Llamada next() {
        return null;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    private List<Llamada> llamadas;
    private int indiceActual = 0;

    public IteradorLlamada(List<Llamada> llamadas) {
        this.llamadas = llamadas;
    }

    public void primero() {
        indiceActual = 0;
    }

    public Llamada getActual() {
        if (indiceActual >= 0 && indiceActual < llamadas.size()) {
            return llamadas.get(indiceActual).getLlamada();
        }
    }
}
