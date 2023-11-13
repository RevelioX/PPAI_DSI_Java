package dsi.dsi.controlador;

import com.opencsv.CSVWriter;
import dsi.dsi.entidades.*;
import dsi.dsi.repositorios.LlamadaRepository;
import dsi.dsi.servicios.EncuestaService;
import dsi.dsi.servicios.LlamadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;


@Controller
@CrossOrigin(origins = "http://localhost:5173")
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
    public ResponseEntity<?> tomarPeriodo(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicioStr,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFinStr) {

        try {
            fechaInicio = Date.from(fechaInicioStr.atStartOfDay(ZoneId.systemDefault()).toInstant());
            fechaFin = Date.from(fechaFinStr.atStartOfDay(ZoneId.systemDefault()).toInstant());

            llamadas = traerLlamadas();
            IteradorLlamada iteradorLlamada = new IteradorLlamada(llamadas);
            iteradorLlamada.primero();
            List<Llamada> llamadasFiltradas = new ArrayList<>();
            while (iteradorLlamada.haTerminado()) {
                Llamada llamadaActual = iteradorLlamada.getActual();
                if (llamadaActual.verificarPeriodo(fechaInicio, fechaFin) && llamadaActual.verificarExistenciaDeRespuestas()) {
                    llamadasFiltradas.add(llamadaActual);
                }
                iteradorLlamada.siguiente();

            }
            if (llamadasFiltradas.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron llamadas en ese rango de fechas");
            }
            return ResponseEntity.ok(llamadasFiltradas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado");
        }
    }

    @RequestMapping("/llamadas")
    @GetMapping
    public ResponseEntity<List<Llamada>> getAll(){
        List<Llamada> lista = llamadaService.findLlamadas();
        return ResponseEntity.ok(lista);
    }

    @RequestMapping("/llamadaEncuesta")
    @GetMapping
    public ResponseEntity<?> llamadaSeleccion(@RequestParam("idLlamada") int idLlamada){
        Llamada llamada = llamadaService.findid(idLlamada);
        List<Encuesta> encuestas = encuestaService.findAll();
        TuplaDatosLlamadaEncuesta datos = llamada.mostarDatos(encuestas);
        return ResponseEntity.ok(datos);
    }

    @RequestMapping("/csv")
    public ResponseEntity<?> crearCSV(@RequestBody DatosCSV datosCSV)  {
        String csvFilePath = "DatosCliente.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
            String[] header = {"Nombre", "Estado", "Duracion", "Respuesta", "Pregunta", "Encuesta"};
            writer.writeNext(header);

            String respuestas = String.join(",", datosCSV.getRespuesta());
            String preguntas = String.join(",", datosCSV.getPreguntas());

            String[] row1 = {
                    datosCSV.getNombreCliente(),
                    datosCSV.getEstado(),
                    String.valueOf(datosCSV.getDuracion()),
                    respuestas,
                    preguntas,
                    datosCSV.getEncuesta()
            };
            writer.writeNext(row1);

            return ResponseEntity.ok("CSV creado Correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error generando el CSV");
        }
    }

}