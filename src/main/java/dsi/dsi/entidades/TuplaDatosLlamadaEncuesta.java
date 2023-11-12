package dsi.dsi.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TuplaDatosLlamadaEncuesta {

    String nombreCliente;
    String nombreEstado;
    String duracionLlamada;
    String descripcionEncuesta;
    List<String> preguntas;
    List<String> respuestas;

    public TuplaDatosLlamadaEncuesta(String nombreCliente, String nombreEstado, int duracionLlamada, String descripcionEncuesta, List<String> preguntas, List<String> respuestas) {
        this.nombreCliente = nombreCliente;
        this.nombreEstado = nombreEstado;
        this.duracionLlamada = "" + duracionLlamada;
        this.descripcionEncuesta = descripcionEncuesta;
        this.preguntas = preguntas;
        this.respuestas = respuestas;
    }

    @Override
    public String toString() {
        return "TuplaDatosLlamadaEncuesta{" +
                "nombreCliente='" + nombreCliente + '\'' +
                ", nombreEstado='" + nombreEstado + '\'' +
                ", duracionLlamada='" + duracionLlamada + '\'' +
                ", descripcionEncuesta='" + descripcionEncuesta + '\'' +
                ", preguntas=" + preguntas +
                ", respuestas=" + respuestas +
                '}';
    }
}
