package dsi.dsi.entidades;

import java.util.Iterator;
import java.util.List;

public class IteradorRespuestasDeCliente implements Iterador {

    List<RespuestaCliente> lista;
    int actual;

    public IteradorRespuestasDeCliente(List<RespuestaCliente> encuestas) {
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

    public RespuestaCliente getActual(){
        return lista.get(actual);
    }

    public void primero(){
        actual = 0;
    }

    public void cortarIteracion(){
        actual = lista.size();
    }
}
