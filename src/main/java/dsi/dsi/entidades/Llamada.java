package dsi.dsi.entidades;

import dsi.dsi.repositorios.EncuestaRepository;
import dsi.dsi.servicios.EncuestaService;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "llamada")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Llamada {



    @Id
    @Column(name = "id_llamada")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;


    @Column(name = "duracion")
    private int duracion;

    @Column(name = "fechallamada")
    private Date fechaLlamada;


    @OneToMany
    @JoinColumn(name = "respuestaencuesta")
    private List<RespuestaCliente> respuestaCliente;

    @OneToOne
    @JoinColumn(name = "cambioestado")
    private CambioEstado cambioEstado;

    public String getNombreCliente() {
        return cliente.getNombre() + " " + cliente.getApellido();
    }
    public int getDuracion() {
        return duracion;
    }

    public TuplaDatosLlamadaEncuesta mostarDatos() {
        String cliente = this.getCliente().getNombre();
        String estado = cambioEstado.esActivo();
        int duracion = getDuracion();
        List<String> descripcionesRespuestas = buscarDescripcionesDeRespuestasCliente();
        TuplaDescripcionEncuestaYPreguntas tupla = buscarDescripcionEncuestasYPreguntas(descripcionesRespuestas);
        return new TuplaDatosLlamadaEncuesta(cliente,estado,duracion,tupla.getDescEncuesta(),tupla.getPreguntas(),descripcionesRespuestas);
    }

    public Date getFechaLlamada() {
        return fechaLlamada;
    }

    public List<RespuestaCliente> getRespuestasCliente() {
        return (List<RespuestaCliente>) respuestaCliente;
    }

    public boolean verificarPeriodo(Date fechaInicio, Date fechaFin) {
        Date fechaLlamada = this.getFechaLlamada();
        return fechaLlamada.after(fechaInicio) && fechaLlamada.before(fechaFin);
    }

    public boolean verificarExistenciaDeRespuestas() {
        List<RespuestaCliente> respuestas = this.getRespuestasCliente();
        return respuestas != null && !respuestas.isEmpty();
    }


    public List<String> buscarDescripcionesDeRespuestasCliente(){
        IteradorRespuestasDeCliente iteradorRespuestasDeCliente = new IteradorRespuestasDeCliente();
        iteradorRespuestasDeCliente.primero();
        List<String> respuestas = new ArrayList<>();
        while(!iteradorRespuestasDeCliente.hasNext()){
            RespuestaCliente actual = iteradorRespuestasDeCliente.getActual();
            String descripcion = actual.mostrarDatosRTA();
            respuestas.add(descripcion);
            iteradorRespuestasDeCliente.next();
        }
        return respuestas;
    }

    public List<Encuesta> traerEncuestas(){
        EncuestaService service = new EncuestaService();
        return service.findAll();
    }

    public TuplaDescripcionEncuestaYPreguntas buscarDescripcionEncuestasYPreguntas(List<String> descripcionesRespuestas){
        List<Encuesta> encuestas = traerEncuestas();
        IteradorEncuesta iterador = new IteradorEncuesta(encuestas);
        List<String> preguntas = new ArrayList<>();
        String descripcionEncuesta = "";
        iterador.primero();
        while(iterador.hasNext()){
            Encuesta encuesta = iterador.getActual();
            preguntas = encuesta.coincidePregunta(descripcionesRespuestas);
            if(preguntas != null){
                descripcionEncuesta = encuesta.getDescripcion();
                iterador.cortarIteracion();
            }
        }
        return new TuplaDescripcionEncuestaYPreguntas(preguntas,descripcionEncuesta);
    }


}
