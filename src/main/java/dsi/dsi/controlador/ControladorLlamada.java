package dsi.dsi.controlador;

import dsi.dsi.entidades.Encuesta;
import dsi.dsi.entidades.IteradorLlamada;
import dsi.dsi.entidades.Llamada;
import dsi.dsi.entidades.TuplaDatosLlamadaEncuesta;
import dsi.dsi.repositorios.LlamadaRepository;
import dsi.dsi.servicios.EncuestaService;
import dsi.dsi.servicios.LlamadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class ControladorLlamada {

    private Date fechaFin;
    private Date fechaInicio;

    private List<Llamada> llamadas;

    @Autowired
    private LlamadaService llamadaService;

    @Autowired
    private EncuestaService encuestaService;

    public List<Llamada> traerLlamadas() {
        return llamadaService.findLlamadas();
    }

    public void setLlamadas(List<Llamada> llamadas) {
        this.llamadas = llamadas;
    }

    @RequestMapping(value = "/filtrarLlamadas", method = RequestMethod.GET)
    public ResponseEntity<?> filtrarLlamadas(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicioStr,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFinStr) {

        try {
            fechaInicio = Date.from(fechaInicioStr.atStartOfDay(ZoneId.systemDefault()).toInstant());
            fechaFin = Date.from(fechaFinStr.atStartOfDay(ZoneId.systemDefault()).toInstant());

            llamadas = traerLlamadas();
            IteradorLlamada iteradorLlamada = new IteradorLlamada(llamadas, fechaInicio, fechaFin);
            iteradorLlamada.primero();
            List<Llamada> llamadasFiltradas = new ArrayList<>();
            while (iteradorLlamada.hasNext()) {
                Llamada llamadaActual = iteradorLlamada.getActual();
                System.out.println(llamadaActual);
                if (llamadaActual.verificarPeriodo(fechaInicio, fechaFin)) {
                    llamadasFiltradas.add(llamadaActual);
                    //TODO && llamadaActual.verificarExistenciaDeRespuestas() agregarlo al final del if
                }
                iteradorLlamada.next();

            }
            return ResponseEntity.ok(llamadasFiltradas);
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping("/llamadas")
    @GetMapping
    public ResponseEntity<List<Llamada>> getAll(){
        List<Llamada> lista = llamadaService.findLlamadas();
        return ResponseEntity.ok(lista);
    }

    @RequestMapping("llamadasXD")
    @GetMapping
    public ResponseEntity<?> getThis(){
        Llamada llamada = llamadaService.findFirst();
        List<Encuesta> encuestas = encuestaService.findAll();
        TuplaDatosLlamadaEncuesta datos = llamada.mostarDatos(encuestas);
        return ResponseEntity.ok(datos);
    }
}