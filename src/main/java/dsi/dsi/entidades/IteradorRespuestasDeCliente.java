package dsi.dsi.entidades;

import java.util.Iterator;
import java.util.List;

public class IteradorRespuestasDeCliente implements Iterator<RespuestaCliente> {

    private List<RespuestaCliente> respuestaClientes;
    private int actual;

    public IteradorRespuestasDeCliente(List<RespuestaCliente> respuestaClientes) {
        this.respuestaClientes = respuestaClientes;
    }

    @Override
    public boolean hasNext() {
        if(actual == respuestaClientes.size()){
            return false;
        }else{
            return true;
        }
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
            return respuestaClientes.get(actual);
    }

    public void primero(){
        actual = 0;
    }

}
