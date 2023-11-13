package dsi.dsi.entidades;

public interface Iterador<T> {

    public T getActual();

    public void siguiente();

    public void primero();

    public boolean haTerminado();


}
