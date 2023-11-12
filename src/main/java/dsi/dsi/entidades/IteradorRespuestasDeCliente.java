package dsi.dsi.entidades;

import java.util.Iterator;
import java.util.List;

public class IteradorRespuestasDeCliente implements Iterator<RespuestaCliente> {

    private List<RespuestaCliente> respuestaClientes;
    private int actual;

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public RespuestaCliente next() {
        return null;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    public RespuestaCliente getActual(){
        if (actual >= 0 && actual < respuestaClientes.size()) {
            return respuestaClientes.get(actual);
        }
        return null;
    }

    public void primero(){
        actual = 0;
    }

}
