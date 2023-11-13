package dsi.dsi.entidades;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@Getter
@Setter
public class DatosCSV {

  private String nombreCliente;
  private String estado;
  private int duracion;
  private List<String> respuesta;
  private List<String> preguntas;
  private String encuesta;

}