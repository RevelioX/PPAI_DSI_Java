package dsi.dsi.entidades;

import java.util.Iterator;
import java.util.List;

public class IteradorRespuestasDeCliente implements Iterator<String> {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public String next() {
        return null;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }


}
