package dsi.dsi.controlador;

import dsi.dsi.entidades.IteradorLlamada;
import dsi.dsi.entidades.Llamada;
import dsi.dsi.repositorios.LlamadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


@Controller
public class ControladorLlamada {

    private Date fechaFin;
    private Date fechaInicio;

    private List<Llamada> llamadas;

    @Autowired
    private LlamadaRepository llamadaRepository;

    public List<Llamada> traerLlamadas() {
        return llamadaRepository.findAll();
    }

    public void setLlamadas(List<Llamada> llamadas) {
        this.llamadas = llamadas;
    }

    @RequestMapping(value = "/filtrarLlamadas", method = RequestMethod.GET)
    public ModelAndView filtrarLlamadas(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicioStr,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFinStr) {

        try {
            fechaInicio = Date.from(fechaInicioStr.atStartOfDay(ZoneId.systemDefault()).toInstant());
            fechaFin = Date.from(fechaFinStr.atStartOfDay(ZoneId.systemDefault()).toInstant());

            llamadas = traerLlamadas(); // Obtener todas las llamadas

            IteradorLlamada iteradorLlamada = new IteradorLlamada(llamadas, fechaInicio, fechaFin);

            // Ejemplo de uso del iterador
            while (!iteradorLlamada.haTerminado()) {
                Llamada llamadaActual = iteradorLlamada.next();

                if (iteradorLlamada.verificarPeriodo(fechaInicio, fechaFin)) {
                    // Realizar acciones con la llamada dentro del periodo
                }

                if (iteradorLlamada.verificarExistenciaDeRespuestas()) {
                    // Realizar acciones si hay respuestas para la llamada
                }
            }

            ModelAndView mav = new ModelAndView("llamadasFiltradas");
            mav.addObject("llamadasFiltradas", llamadas);
            return mav;
        } catch (Exception e) {
            ModelAndView mav = new ModelAndView("error");
            mav.addObject("mensaje", "Ocurrió un error al filtrar las llamadas");
            return mav;
        }}


}