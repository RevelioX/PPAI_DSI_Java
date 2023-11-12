package dsi.dsi.entidades;

import lombok.Getter;

import java.util.List;

@Getter
public class TuplaDescripcionEncuestaYPreguntas {
    private List<String> preguntas;

    private String descEncuesta;

    public TuplaDescripcionEncuestaYPreguntas(List<String> preguntas, String descEncuesta) {
        this.preguntas = preguntas;
        this.descEncuesta = descEncuesta;
    }


}
